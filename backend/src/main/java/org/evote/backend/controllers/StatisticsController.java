package org.evote.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.evote.backend.services.StatisticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping("/allResults/{electionId}")
    public ResponseEntity<?> getAllResults(@PathVariable int electionId) {
        Map<String, Object> allResults = new HashMap<>();
        allResults.put("results", statisticsService.getResults(electionId));
        allResults.put("resultsByEducation", statisticsService.getResultsByEducation(electionId));
        allResults.put("resultsBySex", statisticsService.getResultsBySex(electionId));
        allResults.put("resultsByCountry", statisticsService.getResultsByCountry(electionId));
        allResults.put("resultsByAgeGroup", statisticsService.getResultsByAgeGroup(electionId));
        allResults.put("resultsByCityType", statisticsService.getResultsByCityType(electionId));
        return ResponseEntity.ok(allResults);
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