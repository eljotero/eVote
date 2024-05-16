package org.evote.backend.controllers;


import org.evote.backend.config.JwtService;
import org.evote.backend.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;
    private final JwtService jwtService;

    @Autowired
    public EmailController(EmailService emailService, JwtService jwtService) {
        this.emailService = emailService;
        this.jwtService = jwtService;
    }

    @PostMapping("/sendEmail")
    public void sendEmail(@RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            String jwtToken = token.substring(7);
            String email = jwtService.extractEmail(jwtToken);
            emailService.sendEmail(email);
        }
    }
}