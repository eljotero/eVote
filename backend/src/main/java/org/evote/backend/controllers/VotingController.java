package org.evote.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.evote.backend.services.JwtService;
import org.evote.backend.services.VotingService;
import org.evote.backend.users.account.dtos.VotingCodeDTO;
import org.evote.backend.votes.vote.dtos.VoteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @PostMapping("/vote")
    public ResponseEntity<?> vote(@RequestHeader("Authorization") String token, @RequestBody VoteDTO voteDTO) {
        return ResponseEntity.ok(votingService.vote(token.substring(7), voteDTO));
    }

    @GetMapping("/results/{electionId}")
    public ResponseEntity<?> getResults(@PathVariable int electionId) {
        return ResponseEntity.ok(votingService.getResults(electionId));
    }

    @GetMapping("/detailedResults/{electionId}")
    public ResponseEntity<?> getDetailedResults(@PathVariable int electionId) {
        return ResponseEntity.ok(votingService.getDetailedResults(electionId));
    }

    @GetMapping("/detailedVotesByParty/{electionId}/{politicalPartyId}")
    public ResponseEntity<?> getDetailedVotesByParty(@PathVariable int electionId, @PathVariable int politicalPartyId) {
        return ResponseEntity.ok(votingService.getDetailedVotesByParty(electionId, politicalPartyId));
    }

    @GetMapping("/detailedEducationVotesByParty/{electionId}/{politicalPartyId}")
    public ResponseEntity<?> getDetailedEducationVotesByParty(@PathVariable int electionId, @PathVariable int politicalPartyId) {
        Map<String, Map<String, Integer>> detailedEducationVotes = votingService.getDetailedEducationVotesByParty(electionId, politicalPartyId);
        return ResponseEntity.ok(detailedEducationVotes);
    }

    @GetMapping("/detailedCityTypeVotesByParty/{electionId}/{politicalPartyId}")
    public ResponseEntity<?> getDetailedCityTypeVotesByParty(@PathVariable int electionId, @PathVariable int politicalPartyId) {
        Map<String, Map<String, Integer>> detailedCityTypeVotes = votingService.getDetailedCityTypeVotesByParty(electionId, politicalPartyId);
        return ResponseEntity.ok(detailedCityTypeVotes);
    }

}