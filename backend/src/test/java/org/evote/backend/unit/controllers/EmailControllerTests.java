package org.evote.backend.unit.controllers;

import org.evote.backend.services.JwtService;
import org.evote.backend.controllers.EmailController;
import org.evote.backend.services.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmailControllerTests {

    @InjectMocks
    private EmailController emailController;

    @Mock
    private EmailService emailService;

    @Mock
    private JwtService jwtService;

    private final String token = "1231231";

    private final String email = "test@mail.com";

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        emailController = new EmailController(emailService, jwtService);
        when(jwtService.extractEmail(token)).thenReturn(email);
    }

    @Test
    public void testSendEmail() {
        when(emailService.sendEmail(email)).thenReturn("Kod został wysłany!");
        ResponseEntity<?> response = emailController.sendEmail(token);
        assertEquals(200, response.getStatusCodeValue());
    }

//    @Test
//    public void testSendEmailError() {
//        when(emailService.sendEmail(email)).thenThrow(new RuntimeException("Bad request"));
//        ResponseEntity<?> response = emailController.sendEmail(token);
//        assertEquals(400, response.getStatusCodeValue());
//    }
}
