package org.evote.backend.controllers;

import org.evote.backend.services.CandidateService;
import org.evote.backend.votes.candidate.dtos.CandidateCreateDTO;
import org.evote.backend.votes.candidate.dtos.CandidateDTO;
import org.evote.backend.votes.candidate.dtos.CandidateMapper;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;


    @GetMapping("/all")
    public ResponseEntity<?> getAllCandidates() {
        try {
            List<Candidate> candidates = candidateService.getAllCandidates();
            List<CandidateDTO> candidateDTOs = candidates.stream().map(CandidateMapper::toCandidateDTO).collect(Collectors.toList());
            return ResponseEntity.ok(candidateDTOs);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/filtered")
    public ResponseEntity<List<CandidateDTO>> getFilteredCandidates(@RequestParam int electionId, @RequestParam int precinctId) {
        try {
            List<Candidate> candidates = candidateService.getCandidatesByElectionIdAndPrecinctId(electionId, precinctId);
            List<CandidateDTO> candidateDTOs = candidates.stream().map(CandidateMapper::toCandidateDTO).collect(Collectors.toList());
            return ResponseEntity.ok(candidateDTOs);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCandidate(@RequestBody CandidateCreateDTO candidateCreateDTO) {
        try {
            Candidate candidate = candidateService.addCandidate(candidateCreateDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(CandidateMapper.toCandidateDTO(candidate));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCandidate(@PathVariable Integer id) {
        try {
            candidateService.deleteCandidate(id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCandidate(@PathVariable Integer id, @RequestBody CandidateCreateDTO candidateCreateDTO) {
        try {
            Candidate candidate = candidateService.updateCandidate(id, candidateCreateDTO);
            return ResponseEntity.ok(CandidateMapper.toCandidateDTO(candidate));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}