package org.evote.backend.unit.controllers;

import org.evote.backend.controllers.CandidateController;
import org.evote.backend.services.CandidateService;
import org.evote.backend.votes.candidate.dtos.CandidateCreateDTO;
import org.evote.backend.votes.candidate.dtos.CandidateDTO;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.evote.backend.votes.election.entity.Election;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.evote.backend.votes.precinct.entity.Precinct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class CandidateControllerTests {

    @Mock
    private CandidateService candidateService;
    @InjectMocks
    private CandidateController candidateController;

    private List<Candidate> candidates;

    private CandidateCreateDTO candidateCreateDTO;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();

        PoliticalParty politicalParty1 = new PoliticalParty();
        Precinct precinct1 = new Precinct();
        Election election1 = new Election();
        politicalParty1.setPoliticalPartyId(1);
        precinct1.setPrecinct_id(1);
        election1.setElectionId(1);
        candidate1.setName("John");
        candidate1.setSurname("Doe");
        candidate1.setPoliticalParty(politicalParty1);
        candidate1.setPrecinct(precinct1);
        candidate1.setElection(election1);

        PoliticalParty politicalParty2 = new PoliticalParty();
        Precinct precinct2 = new Precinct();
        Election election2 = new Election();
        politicalParty2.setPoliticalPartyId(2);
        precinct2.setPrecinct_id(2);
        election2.setElectionId(2);
        candidate2.setPoliticalParty(politicalParty2);
        candidate2.setPrecinct(precinct2);
        candidate2.setElection(election2);

        candidateCreateDTO = new CandidateCreateDTO();
        candidateCreateDTO.setName("John");
        candidateCreateDTO.setSurname("Doe");
        candidateCreateDTO.setPolitical_party_id(1);
        candidateCreateDTO.setPrecinct_id(1);
        candidateCreateDTO.setElection_id(1);

        candidates = Arrays.asList(candidate1, candidate2);
    }

    @Test
    public void testGetAllCandidates() {
        when(candidateService.getAllCandidates()).thenReturn(candidates);

        ResponseEntity<?> responseEntity = candidateController.getAllCandidates();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(candidates.size(), ((List<Candidate>) Objects.requireNonNull(responseEntity.getBody())).size());
    }

    @Test
    public void testGetFilteredCandidates() {
        int electionId = 1;
        int precinctId = 1;
        when(candidateService.getCandidatesByElectionIdAndPrecinctId(electionId, precinctId)).thenReturn(Arrays.asList(candidates.get(0)));

        ResponseEntity<?> responseEntity = candidateController.getFilteredCandidates(electionId, precinctId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, ((List<Candidate>) Objects.requireNonNull(responseEntity.getBody())).size());
    }

    @Test
    public void testAddCandidate() {
        when(candidateService.addCandidate(candidateCreateDTO)).thenReturn(candidates.get(0));

        ResponseEntity<?> responseEntity = candidateController.addCandidate(candidateCreateDTO);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(candidateCreateDTO.getName(), ((CandidateDTO) Objects.requireNonNull(responseEntity.getBody())).getName());
        assertEquals(candidateCreateDTO.getSurname(), ((CandidateDTO) Objects.requireNonNull(responseEntity.getBody())).getSurname());
        assertEquals(candidateCreateDTO.getPolitical_party_id(), ((CandidateDTO) Objects.requireNonNull(responseEntity.getBody())).getPolitical_party_id());
        assertEquals(candidateCreateDTO.getPrecinct_id(), ((CandidateDTO) Objects.requireNonNull(responseEntity.getBody())).getPrecinct_id());
        assertEquals(candidateCreateDTO.getElection_id(), ((CandidateDTO) Objects.requireNonNull(responseEntity.getBody())).getElection_id());
    }

    @Test
    public void testDeleteCandidate() {
        int id = 1;
        doNothing().when(candidateService).deleteCandidate(id);
        ResponseEntity<?> responseEntity = candidateController.deleteCandidate(id);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }
}