package org.evote.backend.unit.controllers;

import org.evote.backend.controllers.AuthenticationController;
import org.evote.backend.dtos.user.AuthenticationResponseDTO;
import org.evote.backend.services.AuthenticationService;
import org.evote.backend.users.account.entity.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    public void testRegister() {
        Account account = new Account();
        account.setEmail("test@mail.com");
        account.setPassword("password123");
        when(authenticationService.register(account)).thenReturn("Account created successfully");
        assertEquals("Account created successfully", authenticationController.register(account).getBody());
    }

    @Test
    public void testRegisterBadRequest() {
        Account account = new Account();
        account.setEmail("test@mail.com");
        account.setPassword("pass");
        when(authenticationService.register(account)).thenThrow(new RuntimeException("Bad request"));
        assertEquals("Bad request", authenticationController.register(account).getBody());
    }

    @Test
    public void testLogin() {
        Account account = new Account();
        account.setEmail("test@mail.com");
        account.setPassword("password123");
        account.setAccount_id(1);
        when(authenticationService.login(account)).thenReturn(new AuthenticationResponseDTO("token", account.getAccount_id()));

        AuthenticationResponseDTO response = (AuthenticationResponseDTO) authenticationController.login(account).getBody();

        assertEquals("token", response.getToken());
        assertEquals(1, response.getId());
    }

    @Test
    public void testLoginBadRequest() {
        Account account = new Account();
        account.setEmail("test@mail.com");
        account.setPassword("password123");
        when(authenticationService.login(account)).thenThrow(new RuntimeException("Login failed"));
        ResponseEntity<?> response = authenticationController.login(account);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Login failed", response.getBody());
    }
}
