package org.evote.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.evote.backend.services.StatisticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping("/results/{electionId}")
    public ResponseEntity<?> getResults(@PathVariable int electionId) {
        return ResponseEntity.ok(statisticsService.getResults(electionId));
    }

    @GetMapping("/resultsByEducation/{electionId}")
    public ResponseEntity<?> getResultsByEducation(@PathVariable int electionId) {
        return ResponseEntity.ok(statisticsService.getResultsByEducation(electionId));
    }

    @GetMapping("/resultsBySex/{electionId}")
    public ResponseEntity<?> getResultsBySex(@PathVariable int electionId) {
        return ResponseEntity.ok(statisticsService.getResultsBySex(electionId));
    }

    @GetMapping("/resultsByCountry/{electionId}")
    public ResponseEntity<?> getResultsByCountry(@PathVariable int electionId) {
        return ResponseEntity.ok(statisticsService.getResultsByCountry(electionId));
    }

    @GetMapping("/resultsByAgeGroup/{electionId}")
    public ResponseEntity<?> getResultsByAgeGroup(@PathVariable int electionId) {
        return ResponseEntity.ok(statisticsService.getResultsByAgeGroup(electionId));
    }

    @GetMapping("/resultsByCityType/{electionId}")
    public ResponseEntity<?> getResultsByCityType(@PathVariable int electionId) {
        return ResponseEntity.ok(statisticsService.getResultsByCityType(electionId));
    }

    @GetMapping("/detailedResults/{electionId}")
    public ResponseEntity<?> getDetailedResults(@PathVariable int electionId) {
        return ResponseEntity.ok(statisticsService.getDetailedResults(electionId));
    }

    @GetMapping("/detailedVotesByParty/{electionId}/{politicalPartyId}")
    public ResponseEntity<?> getDetailedVotesByParty(@PathVariable int electionId, @PathVariable int politicalPartyId) {
        return ResponseEntity.ok(statisticsService.getDetailedVotesByParty(electionId, politicalPartyId));
    }

    @GetMapping("/detailedEducationVotesByParty/{electionId}/{politicalPartyId}")
    public ResponseEntity<?> getDetailedEducationVotesByParty(@PathVariable int electionId, @PathVariable int politicalPartyId) {
        Map<String, Map<String, Integer>> detailedEducationVotes = statisticsService.getDetailedEducationVotesByParty(electionId, politicalPartyId);
        return ResponseEntity.ok(detailedEducationVotes);
    }

    @GetMapping("/detailedCityTypeVotesByParty/{electionId}/{politicalPartyId}")
    public ResponseEntity<?> getDetailedCityTypeVotesByParty(@PathVariable int electionId, @PathVariable int politicalPartyId) {
        Map<String, Map<String, Integer>> detailedCityTypeVotes = statisticsService.getDetailedCityTypeVotesByParty(electionId, politicalPartyId);
        return ResponseEntity.ok(detailedCityTypeVotes);
    }
}