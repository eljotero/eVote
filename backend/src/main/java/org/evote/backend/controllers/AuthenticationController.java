package org.evote.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.evote.backend.services.AuthenticationResponse;
import org.evote.backend.services.AuthenticationService;
import org.evote.backend.users.account.entity.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody Account account) {
        return ResponseEntity.ok(authenticationService.register(account));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody Account account) {
        return ResponseEntity.ok(authenticationService.login(account));
    }

}
