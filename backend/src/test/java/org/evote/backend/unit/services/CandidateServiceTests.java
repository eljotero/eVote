package org.evote.backend.unit.services;

import org.evote.backend.services.CandidateService;
import org.evote.backend.votes.candidate.dtos.CandidateCreateDTO;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.evote.backend.votes.candidate.exception.CandidateAlreadyExistsException;
import org.evote.backend.votes.candidate.exception.CandidateNotFoundException;
import org.evote.backend.votes.candidate.repository.CandidateRepository;
import org.evote.backend.votes.election.entity.Election;
import org.evote.backend.votes.election.exception.ElectionNotFoundException;
import org.evote.backend.votes.election.repository.ElectionRepository;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.evote.backend.votes.political_party.exception.PoliticalPartyNotFoundException;
import org.evote.backend.votes.political_party.repository.PoliticalPartyRepository;
import org.evote.backend.votes.precinct.entity.Precinct;
import org.evote.backend.votes.precinct.exception.PrecinctNotFoundException;
import org.evote.backend.votes.precinct.repository.VotesPrecinctRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CandidateServiceTests {

    @InjectMocks
    private CandidateService candidateService;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private PoliticalPartyRepository politicalPartyRepository;

    @Mock
    private VotesPrecinctRepository precinctRepository;

    @Mock
    private ElectionRepository electionRepository;

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
        candidate.setCandidateId(id);

        when(candidateRepository.findById(id)).thenReturn(Optional.of(candidate));

        Candidate result = candidateService.getCandidateById(id);

        assertEquals(candidate, result);
    }

    @Test
    public void testAddCandidate() {
        CandidateCreateDTO candidateCreateDTO = new CandidateCreateDTO();
        candidateCreateDTO.setName("John");
        candidateCreateDTO.setSurname("Doe");
        candidateCreateDTO.setBirthDate(Date.valueOf("1980-01-01"));
        candidateCreateDTO.setEducation("Bachelor's Degree");
        candidateCreateDTO.setPolitical_party_id(1);
        candidateCreateDTO.setPrecinct_id(1);
        candidateCreateDTO.setElection_id(1);

        Candidate candidate = new Candidate();
        PoliticalParty politicalParty = new PoliticalParty();
        Precinct precinct = new Precinct();
        Election election = new Election();

        when(candidateRepository.findByNameAndSurnameAndBirthDateAndEducation(
                candidateCreateDTO.getName(),
                candidateCreateDTO.getSurname(),
                candidateCreateDTO.getBirthDate(),
                candidateCreateDTO.getEducation())).thenReturn(null);

        when(politicalPartyRepository.findById(candidateCreateDTO.getPolitical_party_id())).thenReturn(Optional.of(politicalParty));
        when(precinctRepository.findById(candidateCreateDTO.getPrecinct_id())).thenReturn(Optional.of(precinct));
        when(electionRepository.findById(candidateCreateDTO.getElection_id())).thenReturn(Optional.of(election));

        when(candidateRepository.save(any(Candidate.class))).thenReturn(candidate);

        Candidate result = candidateService.addCandidate(candidateCreateDTO);

        assertNotNull(result);
        verify(candidateRepository, times(1)).save(any(Candidate.class));
    }

    @Test
    public void testAddCandidateAlreadyExists() {
        CandidateCreateDTO candidateCreateDTO = new CandidateCreateDTO();
        candidateCreateDTO.setName("John");
        candidateCreateDTO.setSurname("Doe");
        candidateCreateDTO.setBirthDate(Date.valueOf("1980-01-01"));
        candidateCreateDTO.setEducation("Bachelor's Degree");

        Candidate existingCandidate = new Candidate();

        when(candidateRepository.findByNameAndSurnameAndBirthDateAndEducation(
                candidateCreateDTO.getName(),
                candidateCreateDTO.getSurname(),
                candidateCreateDTO.getBirthDate(),
                candidateCreateDTO.getEducation())).thenReturn(existingCandidate);

        assertThrows(CandidateAlreadyExistsException.class, () -> candidateService.addCandidate(candidateCreateDTO));
    }

    @Test
    public void testAddCandidatePoliticalPartyNotFound() {
        CandidateCreateDTO candidateCreateDTO = new CandidateCreateDTO();
        candidateCreateDTO.setPolitical_party_id(1);

        when(politicalPartyRepository.findById(candidateCreateDTO.getPolitical_party_id())).thenReturn(Optional.empty());

        assertThrows(PoliticalPartyNotFoundException.class, () -> candidateService.addCandidate(candidateCreateDTO));
    }

    @Test
    public void testAddCandidatePrecinctNotFound() {
        CandidateCreateDTO candidateCreateDTO = new CandidateCreateDTO();
        candidateCreateDTO.setPolitical_party_id(1);
        candidateCreateDTO.setPrecinct_id(1);

        PoliticalParty politicalParty = new PoliticalParty();

        when(politicalPartyRepository.findById(candidateCreateDTO.getPolitical_party_id())).thenReturn(Optional.of(politicalParty));
        when(precinctRepository.findById(candidateCreateDTO.getPrecinct_id())).thenReturn(Optional.empty());

        assertThrows(PrecinctNotFoundException.class, () -> candidateService.addCandidate(candidateCreateDTO));
    }

    @Test
    public void testAddCandidateElectionNotFound() {
        CandidateCreateDTO candidateCreateDTO = new CandidateCreateDTO();
        candidateCreateDTO.setPolitical_party_id(1);
        candidateCreateDTO.setPrecinct_id(1);
        candidateCreateDTO.setElection_id(1);

        PoliticalParty politicalParty = new PoliticalParty();
        Precinct precinct = new Precinct();

        when(politicalPartyRepository.findById(candidateCreateDTO.getPolitical_party_id())).thenReturn(Optional.of(politicalParty));
        when(precinctRepository.findById(candidateCreateDTO.getPrecinct_id())).thenReturn(Optional.of(precinct));
        when(electionRepository.findById(candidateCreateDTO.getElection_id())).thenReturn(Optional.empty());

        assertThrows(ElectionNotFoundException.class, () -> candidateService.addCandidate(candidateCreateDTO));
    }


    @Test
    public void testDeleteCandidate() {
        Integer id = 1;
        Candidate candidate = new Candidate();
        candidate.setCandidateId(id);

        when(candidateRepository.findById(id)).thenReturn(Optional.of(candidate));

        candidateService.deleteCandidate(id);

        verify(candidateRepository, times(1)).delete(candidate);
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

    @Test
    public void testUpdateCandidate() {
        Integer id = 1;
        CandidateCreateDTO candidateNewInfo = new CandidateCreateDTO();
        candidateNewInfo.setName("John");
        candidateNewInfo.setSurname("Doe");
        candidateNewInfo.setBirthDate(Date.valueOf("1980-01-01"));
        candidateNewInfo.setEducation("Bachelor's Degree");
        candidateNewInfo.setPolitical_party_id(1);
        candidateNewInfo.setPrecinct_id(1);
        candidateNewInfo.setElection_id(1);

        Candidate candidate = new Candidate();
        PoliticalParty politicalParty = new PoliticalParty();
        Precinct precinct = new Precinct();
        Election election = new Election();

        when(candidateRepository.findById(id)).thenReturn(Optional.of(candidate));
        when(politicalPartyRepository.findById(candidateNewInfo.getPolitical_party_id())).thenReturn(Optional.of(politicalParty));
        when(precinctRepository.findById(candidateNewInfo.getPrecinct_id())).thenReturn(Optional.of(precinct));
        when(electionRepository.findById(candidateNewInfo.getElection_id())).thenReturn(Optional.of(election));

        when(candidateRepository.save(any(Candidate.class))).thenReturn(candidate);

        Candidate result = candidateService.updateCandidate(id, candidateNewInfo);

        assertNotNull(result);
        verify(candidateRepository, times(1)).save(any(Candidate.class));
    }

    @Test
    public void testGetCandidatesByPoliticalPartyId() {
        Integer politicalPartyId = 1;
        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setPoliticalPartyId(politicalPartyId);

        Candidate candidate1 = new Candidate();
        candidate1.setPoliticalParty(politicalParty);
        Candidate candidate2 = new Candidate();
        candidate2.setPoliticalParty(politicalParty);
        List<Candidate> candidates = Arrays.asList(candidate1, candidate2);

        when(candidateRepository.findAll()).thenReturn(candidates);

        List<Candidate> result = candidateService.getCandidatesByPoliticalPartyId(politicalPartyId);

        assertEquals(candidates, result);
    }

    @Test
    public void testGetCandidatesByElectionIdAndPrecinctId() {
        Integer electionId = 1;
        Integer precinctId = 1;
        Election election = new Election();
        election.setElectionId(electionId);
        Precinct precinct = new Precinct();
        precinct.setPrecinct_id(precinctId);

        Candidate candidate1 = new Candidate();
        candidate1.setElection(election);
        candidate1.setPrecinct(precinct);
        Candidate candidate2 = new Candidate();
        candidate2.setElection(election);
        candidate2.setPrecinct(precinct);
        List<Candidate> candidates = Arrays.asList(candidate1, candidate2);

        when(candidateRepository.findAll()).thenReturn(candidates);

        List<Candidate> result = candidateService.getCandidatesByElectionIdAndPrecinctId(electionId, precinctId);

        assertEquals(candidates, result);
    }
}