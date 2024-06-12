package org.evote.backend.unit.controllers;

import org.evote.backend.controllers.AuthenticationController;
import org.evote.backend.users.account.dtos.AccountCreateDTO;
import org.evote.backend.users.account.dtos.AccountLoginDTO;
import org.evote.backend.users.account.dtos.AccountMapper;
import org.evote.backend.users.account.dtos.AuthenticationResponseDTO;
import org.evote.backend.services.AuthenticationService;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.exceptions.PasswordTooShortException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class AuthenticationControllerTests {
    @InjectMocks
    private AuthenticationController authenticationController;

    @Mock
    private AuthenticationService authenticationService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
/*
    @Test
    public void testRegister() {
        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
        accountCreateDTO.setEmail("test@mail.com");
        accountCreateDTO.setPassword("password123");
        when(authenticationService.register(accountCreateDTO)).thenReturn(AccountMapper.toAccount(accountCreateDTO));
        assertEquals(accountCreateDTO.getEmail(), Objects.requireNonNull(authenticationController.register(accountCreateDTO).getBody()).getEmail());
    }



    @Test
    public void testRegisterPasswordToShort() {
        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
        accountCreateDTO.setEmail("test@mail.com");
        accountCreateDTO.setPassword("pass");

        when(authenticationService.register(accountCreateDTO)).thenThrow(new PasswordTooShortException("Password must be at least 8 characters long"));
        assertThrows(PasswordTooShortException.class, () -> authenticationController.register(accountCreateDTO));
    }

    @Test
    public void testLogin() {
        AccountLoginDTO accountLoginDTO = new AccountLoginDTO();
        accountLoginDTO.setEmail("test@mail.com");
        accountLoginDTO.setPassword("password123");
        when(authenticationService.login(accountLoginDTO)).thenReturn(new AuthenticationResponseDTO("token", 1));

        AuthenticationResponseDTO response = (AuthenticationResponseDTO) authenticationController.login(accountLoginDTO).getBody();

        assertEquals("token", response.getToken());
        assertEquals(1, response.getId());
    }

    @Test
    public void testLoginAccountNotFound() {
        AccountLoginDTO accountLoginDTO = new AccountLoginDTO();
        accountLoginDTO.setEmail("test@mail.com");
        accountLoginDTO.setPassword("password123");

        when(authenticationService.login(accountLoginDTO)).thenThrow(new AccountNotFoundException("Account not found"));
        assertThrows(AccountNotFoundException.class, () -> authenticationController.login(accountLoginDTO));
    }

 */
}
