package org.evote.backend.unit.services;

import org.evote.backend.config.JwtService;
import org.evote.backend.services.AuthenticationService;
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
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    public void testRegister() throws AccountAlreadyExistsException {
        when(passwordEncoder.encode(account.getPassword())).thenReturn("encodedPassword");
        when(accountRepository.save(account)).thenReturn(account);

        String result = authenticationService.register(account);

        assertEquals("Account created successfully", result);
        verify(accountRepository, times(1)).save(account);
    }

    @Test
    public void testRegisterPasswordTooShort() {
        account.setPassword("pass");

        PasswordTooShortException exception = assertThrows(PasswordTooShortException.class, () -> authenticationService.register(account));
        assertEquals("Password must be at least 8 characters long", exception.getMessage());
    }

    @Test
    public void testRegisterAccountAlreadyExists() {

        when(passwordEncoder.encode(account.getPassword())).thenReturn("encodedPassword");
        when(accountRepository.findByEmail(account.getEmail())).thenReturn(new Account());
        when(accountRepository.save(account)).thenThrow(new DataAccessException("Database error") {
        });

        AccountAlreadyExistsException exception = assertThrows(AccountAlreadyExistsException.class, () -> authenticationService.register(account));
        assertEquals("Account already exists", exception.getMessage());
    }

    @Test
    public void testLogin() {
        when(authenticationManager.authenticate(any())).thenReturn(null);
        when(accountRepository.findByEmail(account.getEmail())).thenReturn(account);
        when(jwtService.generateToken(account)).thenReturn("token");
        assertEquals("token", authenticationService.login(account).getToken());
    }

    @Test
    public void testLoginAccountNotFound() {
        when(authenticationManager.authenticate(any())).thenReturn(null);
        when(accountRepository.findByEmail(account.getEmail())).thenReturn(null);
        AccountNotFoundException exception = assertThrows(AccountNotFoundException.class, () -> authenticationService.login(account));
        assertEquals("Account not found", exception.getMessage());
    }

    @Test
    public void testHasAccount() {
        account.setAccount_id(1);

        when(securityContext.getAuthentication()).thenReturn(auth);
        SecurityContextHolder.setContext(securityContext);
        when(auth.getName()).thenReturn(account.getEmail());
        when(accountRepository.findByEmail(account.getEmail())).thenReturn(account);
        assertEquals(true, authenticationService.hasAccount(1));
    }

    @Test
    public void testHasAccountNoAccount() {
        account.setAccount_id(1);

        when(securityContext.getAuthentication()).thenReturn(auth);
        SecurityContextHolder.setContext(securityContext);
        when(auth.getName()).thenReturn(account.getEmail());
        when(accountRepository.findByEmail(account.getEmail())).thenReturn(null);
        assertEquals(false, authenticationService.hasAccount(1));
    }
}
