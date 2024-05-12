package org.evote.backend.unit.services;

import org.evote.backend.services.CandidateService;
import org.evote.backend.users.precinct.entity.Precinct;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.evote.backend.votes.candidate.exception.CandidateAlreadyExistsException;
import org.evote.backend.votes.candidate.exception.CandidateNotFoundException;
import org.evote.backend.votes.candidate.repository.CandidateRepository;
import org.evote.backend.votes.election.entity.Election;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CandidateServiceTests {

    @InjectMocks
    private CandidateService candidateService;

    @Mock
    private CandidateRepository candidateRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCandidates() {
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();
        List<Candidate> candidates = Arrays.asList(candidate1, candidate2);

        when(candidateRepository.findAll()).thenReturn(candidates);

        List<Candidate> result = candidateService.getAllCandidates();

        assertEquals(candidates, result);
    }


    @Test
    public void testGetCandidateById() {
        Integer id = 1;
        Candidate candidate = new Candidate();
        candidate.setCandidate_id(id);

        when(candidateRepository.findById(id)).thenReturn(Optional.of(candidate));

        Candidate result = candidateService.getCandidateById(id);

        assertEquals(candidate, result);
    }

    @Test
    public void testAddCandidate() {
        Integer id = 1;
        Candidate candidate = new Candidate();
        candidate.setCandidate_id(id);

        when(candidateRepository.findById(id)).thenReturn(Optional.empty());
        when(candidateRepository.save(candidate)).thenReturn(candidate);

        Candidate result = candidateService.addCandidate(candidate);

        assertEquals(candidate, result);
    }

    @Test
    public void testDeleteCandidate() {
        Integer id = 1;
        Candidate candidate = new Candidate();
        candidate.setCandidate_id(id);

        when(candidateRepository.findById(id)).thenReturn(Optional.of(candidate));

        candidateService.deleteCandidate(id);

        verify(candidateRepository, times(1)).delete(candidate);
    }

    @Test
    public void testAddCandidateAlreadyExists() {
        Integer id = 1;
        Candidate candidate = new Candidate();
        candidate.setCandidate_id(id);

        when(candidateRepository.findById(id)).thenReturn(Optional.of(candidate));

        assertThrows(CandidateAlreadyExistsException.class, () -> candidateService.addCandidate(candidate));
    }

    @Test
    public void testGetCandidateByIdNotFound() {
        Integer id = 1;

        when(candidateRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CandidateNotFoundException.class, () -> candidateService.getCandidateById(id));
    }

    @Test
    public void testDeleteCandidateNotFound() {
        Integer id = 1;

        when(candidateRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CandidateNotFoundException.class, () -> candidateService.deleteCandidate(id));
    }
}