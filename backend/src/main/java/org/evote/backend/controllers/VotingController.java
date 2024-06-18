package org.evote.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.evote.backend.services.JwtService;
import org.evote.backend.services.VotingService;
import org.evote.backend.users.account.dtos.VotingCodeDTO;
import org.evote.backend.votes.vote.dtos.SubmitVoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.evote.backend.votes.vote.dtos.VoteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vote")
@RequiredArgsConstructor
public class VotingController {

    private final JwtService jwtService;
    private final VotingService votingService;

    @PostMapping("/voteToken")
    public ResponseEntity<String> generateVotingToken(@RequestHeader("Authorization") String token, @RequestBody VotingCodeDTO votingCodeDTO) {
        String email = jwtService.extractEmail(token.substring(7));
        return ResponseEntity.ok(votingService.generateVotingToken(email, votingCodeDTO.getCode()));
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitVote(@RequestBody SubmitVoteDTO submitVoteDTO) {
        votingService.submitVote(submitVoteDTO);
        return ResponseEntity.ok("Vote submitted successfully");
    }
}

