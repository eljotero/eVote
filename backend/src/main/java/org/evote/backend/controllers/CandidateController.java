package org.evote.backend.controllers;

import org.evote.backend.services.CandidateService;
import org.evote.backend.votes.candidate.dtos.candidate.CandidateDTO;
import org.evote.backend.votes.candidate.dtos.candidate.CandidateMapper;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/candidates")
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

    @PostMapping("/add")
    public ResponseEntity<CandidateDTO> addCandidate(@RequestBody CandidateDTO candidateDTO) {
        Candidate candidate = candidateService.addCandidate(CandidateMapper.toCandidate(candidateDTO));
        return ResponseEntity.ok(CandidateMapper.toCandidateDTO(candidate));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable UUID id) {
        candidateService.deleteCandidate(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CandidateDTO> updateCandidate(@PathVariable UUID id, @RequestBody CandidateDTO candidateDTO) {
        Candidate candidate = candidateService.updateCandidate(id, CandidateMapper.toCandidate(candidateDTO));
        return ResponseEntity.ok(CandidateMapper.toCandidateDTO(candidate));
    }

}