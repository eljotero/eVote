package org.evote.backend.controllers;

import org.evote.backend.services.AuthenticationService;
import org.evote.backend.users.account.dtos.*;
import org.evote.backend.users.account.entity.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/register")
    public ResponseEntity<AccountDTO> register(@RequestBody AccountCreateDTO accountCreateDTO) {
        Account account = authenticationService.register(accountCreateDTO);
        return new ResponseEntity<>(AccountMapper.toAccountDTO(account), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> login(@RequestBody AccountLoginDTO accountLoginDTO) {
        AuthenticationResponseDTO authenticationResponseDTO = authenticationService.login(accountLoginDTO);
        return new ResponseEntity<>(authenticationResponseDTO, HttpStatus.OK);
    }

}
