package org.evote.backend.controllers;

import org.evote.backend.services.CandidateService;
import org.evote.backend.votes.candidate.dtos.candidate.CandidateDTO;
import org.evote.backend.votes.candidate.dtos.candidate.CandidateMapper;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin(origins = "http://localhost:3000")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;


    @GetMapping("/all")
    public ResponseEntity<List<CandidateDTO>> getAllCandidates() {
        List<Candidate> candidates = candidateService.getAllCandidates();
        List<CandidateDTO> candidateDTOs = candidates.stream().map(CandidateMapper::toCandidateDTO).collect(Collectors.toList());
        return ResponseEntity.ok(candidateDTOs);
    }
    @GetMapping("/filtered")
    public ResponseEntity<List<CandidateDTO>> getFilteredCandidates(@RequestParam int electionId, @RequestParam int precinctId) {
        List<Candidate> candidates = candidateService.getCandidatesByElectionIdAndPrecinctId(electionId, precinctId);
        List<CandidateDTO> candidateDTOs = candidates.stream().map(CandidateMapper::toCandidateDTO).collect(Collectors.toList());
        return ResponseEntity.ok(candidateDTOs);
    }

}