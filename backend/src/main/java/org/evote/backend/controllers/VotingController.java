package org.evote.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.evote.backend.config.JwtService;
import org.evote.backend.services.AccountService;
import org.evote.backend.services.VotingService;
import org.evote.backend.users.account.dtos.VotingCodeDTO;
import org.evote.backend.users.account.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vote")
@RequiredArgsConstructor
public class VotingController {

    @Autowired
    private JwtService jwtService;
    private final AccountService accountService;
    private final VotingService votingService;

    @PostMapping("/{accountID}")
    @PreAuthorize("@authenticationService.hasAccount(#accountID)")
    public ResponseEntity<String> vote(@PathVariable Integer accountID, @RequestBody VotingCodeDTO votingCodeDTO) {
        String code = votingCodeDTO.getCode();
        boolean isValid = votingService.verifyCode(accountID, code);
        if (isValid) {
            String newVotingToken = votingService.generateVotingToken(accountID);
            return ResponseEntity.ok(newVotingToken);
        } else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid code");
        }
    }
}
