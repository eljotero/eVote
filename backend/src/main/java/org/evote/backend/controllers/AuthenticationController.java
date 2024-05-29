package org.evote.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.evote.backend.config.JwtService;
import org.evote.backend.services.AuthenticationService;
import org.evote.backend.users.account.dtos.*;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.votes.candidate.dtos.CandidateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    private JwtService jwtService;

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

    @PostMapping("/vote")
    public ResponseEntity<String> vote(@RequestBody Account account) {
        String newVotingToken = jwtService.generateVotingToken(account);
        return ResponseEntity.ok(newVotingToken);
    }

}
