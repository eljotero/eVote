package org.evote.backend.unit.services;

import org.evote.backend.config.JwtService;
import org.evote.backend.services.AuthenticationService;
import org.evote.backend.users.account.dtos.AccountCreateDTO;
import org.evote.backend.users.account.dtos.AccountLoginDTO;
import org.evote.backend.users.account.dtos.AccountMapper;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountAlreadyExistsException;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.exceptions.PasswordTooShortException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class AuthenticationServiceTests {

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private JwtService jwtService;
    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthenticationService authenticationService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        authenticationService = new AuthenticationService(accountRepository, passwordEncoder, jwtService, authenticationManager);
    }


    @Test
    public void testRegister() throws AccountAlreadyExistsException {
        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
        accountCreateDTO.setPassword("password123");

        when(passwordEncoder.encode(accountCreateDTO.getPassword())).thenReturn("encodedPassword");
        when(accountRepository.save(AccountMapper.toAccount(accountCreateDTO))).thenReturn(AccountMapper.toAccount(accountCreateDTO));

        Account result = authenticationService.register(accountCreateDTO);

        assertEquals("Account created successfully", result);
        verify(accountRepository, times(1)).save(AccountMapper.toAccount(accountCreateDTO));
    }

    @Test
    public void testRegisterPasswordTooShort() {
        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
        accountCreateDTO.setPassword("pass");

        PasswordTooShortException exception = assertThrows(PasswordTooShortException.class, () -> authenticationService.register(accountCreateDTO));
        assertEquals("Password must be at least 8 characters long", exception.getMessage());
    }

    @Test
    public void testRegisterAccountAlreadyExists() {
        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
        accountCreateDTO.setEmail("test@test.com");
        accountCreateDTO.setPassword("password123");

        when(passwordEncoder.encode(accountCreateDTO.getPassword())).thenReturn("encodedPassword");
        when(accountRepository.findByEmail(accountCreateDTO.getEmail())).thenReturn(AccountMapper.toAccount(accountCreateDTO));
        when(accountRepository.save(AccountMapper.toAccount(accountCreateDTO))).thenThrow(new AccountAlreadyExistsException("Account already exists"));

        AccountAlreadyExistsException exception = assertThrows(AccountAlreadyExistsException.class, () -> authenticationService.register(accountCreateDTO));
        assertEquals("Account already exists", exception.getMessage());
    }

    @Test
    public void testLogin() {
        Account account = new Account();
        account.setEmail("test@mail.com");
        account.setPassword("password123");

        AccountLoginDTO accountLoginDTO = new AccountLoginDTO();
        accountLoginDTO.setEmail(account.getEmail());
        accountLoginDTO.setPassword(account.getPassword());

        when(authenticationManager.authenticate(any())).thenReturn(null);
        when(accountRepository.findByEmail(account.getEmail())).thenReturn(account);
        when(jwtService.generateToken(account)).thenReturn("token");
        assertEquals("token", authenticationService.login(accountLoginDTO).getToken());
    }

    @Test
    public void testLoginAccountNotFound() {
        Account account = new Account();
        account.setEmail("test@mail.com");
        account.setPassword("password123");

        AccountLoginDTO accountLoginDTO = new AccountLoginDTO();
        accountLoginDTO.setEmail(account.getEmail());
        accountLoginDTO.setPassword(account.getPassword());

        when(authenticationManager.authenticate(any())).thenReturn(null);
        when(accountRepository.findByEmail(account.getEmail())).thenReturn(null);
        AccountNotFoundException exception = assertThrows(AccountNotFoundException.class, () -> authenticationService.login(accountLoginDTO));
        assertEquals("Account not found", exception.getMessage());
    }

}
