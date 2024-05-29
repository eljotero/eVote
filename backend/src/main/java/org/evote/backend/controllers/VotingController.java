package org.evote.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.evote.backend.config.JwtService;
import org.evote.backend.users.account.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VotingController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/vote")
    public ResponseEntity<String> vote(@RequestBody Account account) {
        String newVotingToken = jwtService.generateVotingToken(account);
        return ResponseEntity.ok(newVotingToken);
    }
}
