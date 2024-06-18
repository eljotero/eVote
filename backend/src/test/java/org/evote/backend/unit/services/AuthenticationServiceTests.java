package org.evote.backend.unit.services;

import org.evote.backend.configuration.JwtService;
import org.evote.backend.services.AuthenticationService;
import org.evote.backend.users.account.dtos.AccountCreateDTO;
import org.evote.backend.users.account.dtos.AccountLoginDTO;
import org.evote.backend.users.account.dtos.AccountMapper;
import org.evote.backend.users.account.dtos.AuthenticationResponseDTO;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountAlreadyExistsException;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.exceptions.PasswordTooShortException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.evote.backend.users.address.repository.UserAddressRepository;
import org.evote.backend.users.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AuthenticationServiceTests {

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private JwtService jwtService;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private UserAddressRepository userAddressRepository;

    @Mock
    private Authentication auth;

    @Mock
    SecurityContext securityContext;

    private Account account;

    @InjectMocks
    private AuthenticationService authenticationService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        authenticationService = new AuthenticationService(accountRepository, passwordEncoder, jwtService, authenticationManager, userRepository, userAddressRepository);

        account = new Account();
        account.setPassword("password123");
        account.setEmail("test@mail.com");
    }

    @Test
    public void testRegister() {
        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
        accountCreateDTO.setEmail("test@test.com");
        accountCreateDTO.setPassword("password123");

        when(passwordEncoder.encode("password123")).thenReturn("encodedPassword");
        when(accountRepository.findByEmail(accountCreateDTO.getEmail())).thenReturn(null);

        Account savedAccount = new Account();
        savedAccount.setEmail(accountCreateDTO.getEmail());
        savedAccount.setPassword("encodedPassword");

        when(accountRepository.save(any(Account.class))).thenReturn(savedAccount);

        Account registeredAccount = authenticationService.register(accountCreateDTO);

        assertNotNull(registeredAccount, "Registered account should not be null");
        assertEquals(accountCreateDTO.getEmail(), registeredAccount.getEmail(), "Emails should match");
        assertEquals("encodedPassword", registeredAccount.getPassword(), "Passwords should match");

        verify(accountRepository, times(1)).save(any(Account.class));
        verify(passwordEncoder, times(1)).encode("password123");
        verify(accountRepository, times(1)).findByEmail(accountCreateDTO.getEmail());
    }



    @Test
    public void testRegisterPasswordTooShort() {
        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
        accountCreateDTO.setPassword("passwo");

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

        AccountAlreadyExistsException exception = assertThrows(AccountAlreadyExistsException.class, () -> authenticationService.register(accountCreateDTO));
        assertEquals("Account already exists", exception.getMessage());
    }

    @Test
    public void testLogin() {
        AccountLoginDTO accountLoginDTO = new AccountLoginDTO();
        accountLoginDTO.setEmail(account.getEmail());
        accountLoginDTO.setPassword(account.getPassword());

        when(authenticationManager.authenticate(any())).thenReturn(null);
        when(accountRepository.findByEmail(accountLoginDTO.getEmail())).thenReturn(account);
        when(jwtService.generateToken(account)).thenReturn("token");

        AuthenticationResponseDTO responseDTO = authenticationService.login(accountLoginDTO);

        assertNotNull(responseDTO);
        assertEquals("token", responseDTO.getToken());
    }

    @Test
    public void testLoginAccountNotFound() {
        AccountLoginDTO accountLoginDTO = new AccountLoginDTO();
        accountLoginDTO.setEmail(account.getEmail());
        accountLoginDTO.setPassword(account.getPassword());

        when(authenticationManager.authenticate(any())).thenReturn(null);
        when(accountRepository.findByEmail(accountLoginDTO.getEmail())).thenReturn(null);

        AccountNotFoundException exception = assertThrows(AccountNotFoundException.class, () -> authenticationService.login(accountLoginDTO));
        assertEquals("Account not found", exception.getMessage());
    }

    @Test
    public void testHasAccount() {
        account.setAccount_id(1);

        when(securityContext.getAuthentication()).thenReturn(auth);
        SecurityContextHolder.setContext(securityContext);
        when(auth.getName()).thenReturn(account.getEmail());
        when(accountRepository.findByEmail(account.getEmail())).thenReturn(account);

        assertTrue(authenticationService.hasAccount(1));
    }

    @Test
    public void testHasAccountNoAccount() {
        account.setAccount_id(1);

        when(securityContext.getAuthentication()).thenReturn(auth);
        SecurityContextHolder.setContext(securityContext);
        when(auth.getName()).thenReturn(account.getEmail());
        when(accountRepository.findByEmail(account.getEmail())).thenReturn(null);

        assertFalse(authenticationService.hasAccount(1));
    }
}
