package org.evote.backend.controllers;

import lombok.AllArgsConstructor;
import org.evote.backend.services.CandidateService;
import org.evote.backend.votes.candidate.dtos.CandidateCreateDTO;
import org.evote.backend.votes.candidate.dtos.CandidateDTO;
import org.evote.backend.votes.candidate.dtos.CandidateMapper;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/candidates")
@AllArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllCandidates() {
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
    public ResponseEntity<?> addCandidate(@RequestBody CandidateCreateDTO candidateCreateDTO) {
        Candidate candidate = candidateService.addCandidate(candidateCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(CandidateMapper.toCandidateDTO(candidate));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCandidate(@PathVariable Integer id) {
        candidateService.deleteCandidate(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCandidate(@PathVariable Integer id, @RequestBody CandidateCreateDTO candidateCreateDTO) {
        Candidate candidate = candidateService.updateCandidate(id, candidateCreateDTO);
        return ResponseEntity.ok(CandidateMapper.toCandidateDTO(candidate));
    }

}