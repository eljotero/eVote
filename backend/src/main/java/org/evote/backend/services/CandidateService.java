package org.evote.backend.services;

import org.evote.backend.votes.candidate.entity.Candidate;
import org.evote.backend.votes.candidate.exception.CandidateAlreadyExistsException;
import org.evote.backend.votes.candidate.exception.CandidateNotFoundException;
import org.evote.backend.votes.candidate.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }
    public List<Candidate> getCandidatesByElectionIdAndPrecinctId(int electionId, int precinctId) {
        return candidateRepository.findAll().stream()
                .filter(candidate -> candidate.getElection_id() == electionId && candidate.getPrecinct_id() == precinctId)
                .collect(Collectors.toList());
    }

    public Candidate getCandidateById(UUID id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("Candidate with id " + id + " not found"));
    }

    public Candidate addCandidate(Candidate candidate) {
        if (candidateRepository.findById(candidate.getCandidate_id()).isPresent()) {
            throw new CandidateAlreadyExistsException("Candidate with id " + candidate.getCandidate_id() + " already exists");
        }
        return candidateRepository.save(candidate);
    }

    public void deleteCandidate(UUID id) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("Candidate with id " + id + " not found"));
        candidateRepository.delete(candidate);
    }


    public Candidate updateCandidate(UUID id, Candidate candidate) {
        Candidate candidateToUpdate = candidateRepository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("Candidate with id " + id + " not found"));
        candidateToUpdate.setElection_id(candidate.getElection_id());
        candidateToUpdate.setPrecinct_id(candidate.getPrecinct_id());
        // do dodania reszta pól
        return candidateRepository.save(candidateToUpdate);
    }
}