package org.evote.backend.controllers;


import org.evote.backend.config.JwtService;
import org.evote.backend.services.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;
    private final JwtService jwtService;


    public EmailController(EmailService emailService, JwtService jwtService) {
        this.emailService = emailService;
        this.jwtService = jwtService;
    }

    @PostMapping("/sendEmail")
    public ResponseEntity<?> sendEmail(@RequestHeader("Authorization") String token) {
        try {
            String jwtToken = token.substring(7);
            String email = jwtService.extractEmail(jwtToken);
            return ResponseEntity.ok(emailService.sendEmail(email));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}