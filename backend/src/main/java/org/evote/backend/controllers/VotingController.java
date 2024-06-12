package org.evote.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.evote.backend.config.JwtService;
import org.evote.backend.services.AccountService;
import org.evote.backend.services.VotingService;
import org.evote.backend.users.account.dtos.VotingCodeDTO;
import org.evote.backend.votes.vote.dtos.VoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/{id}")
    @PreAuthorize("@authenticationService.hasAccount(#id)")
    public ResponseEntity<String> vote(@PathVariable Integer id, @RequestBody VotingCodeDTO votingCodeDTO) {
        String code = votingCodeDTO.getCode();
        boolean isValid = votingService.verifyCode(id, code);
        if (isValid) {
            String newVotingToken = votingService.generateVotingToken(id);
            return ResponseEntity.ok(newVotingToken);
        } else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid code");
        }
    }

    @PostMapping("/temp")
    public ResponseEntity<?> vote2(@RequestHeader("Authorization") String token, @RequestBody VoteDTO voteDTO) {
        return ResponseEntity.ok(votingService.vote(token.substring(7), voteDTO));
    }
}
