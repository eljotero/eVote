package org.evote.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.evote.backend.config.JwtService;
import org.evote.backend.services.AccountService;
import org.evote.backend.users.account.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VotingController {

    @Autowired
    private JwtService jwtService;
    private final AccountService accountService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/vote/{accountID}")
    public ResponseEntity<String> vote(@PathVariable Integer accountID) {
        Account account = accountService.getAccountById(accountID);
        String newVotingToken = jwtService.generateVotingToken(account);
        return ResponseEntity.ok(newVotingToken);
    }
}
