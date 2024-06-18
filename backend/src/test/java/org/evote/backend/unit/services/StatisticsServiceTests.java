package org.evote.backend.unit.services;

import org.evote.backend.services.StatisticsService;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.evote.backend.votes.election.entity.Election;
import org.evote.backend.votes.election.exception.ElectionNotFoundException;
import org.evote.backend.votes.election.repository.ElectionRepository;
import org.evote.backend.votes.enums.CityType;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.evote.backend.votes.vote.entity.Vote;
import org.evote.backend.votes.vote.repository.VoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class StatisticsServiceTests {

    @InjectMocks
    private StatisticsService statisticsService;

    @Mock
    private VoteRepository voteRepository;

    @Mock
    private ElectionRepository electionRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetResults() {
        int electionId = 1;
        PoliticalParty party1 = new PoliticalParty();
        party1.setName("Party1");
        Vote vote1 = mockVote(electionId, party1);
        Vote vote2 = mockVote(electionId, party1);
        Vote vote3 = mockVote(2, party1);
        when(electionRepository.findById(electionId)).thenReturn(Optional.of(mockElection(electionId)));
        when(voteRepository.findAll()).thenReturn(Arrays.asList(vote1, vote2, vote3));
        Map<String, Integer> results = statisticsService.getResults(electionId);
        assertEquals(2, (int) results.get("Party1"));
    }


    @Test
    public void testGetResultsByAgeGroup() {
        int electionId = 1;
        Election election = new Election();
        election.setElectionId(electionId);
        when(electionRepository.findById(electionId)).thenReturn(Optional.of(election));
        List<Vote> votes = Arrays.asList(
                mockVote(electionId, "1990-01-01"),
                mockVote(electionId, "1980-01-01"),
                mockVote(electionId, "2000-01-01")
        );
        when(voteRepository.findAll()).thenReturn(votes);
        Map<String, Map<String, Integer>> results = statisticsService.getResultsByAgeGroup(electionId);
        assertEquals(3, results.size());
        assertEquals(1, (int) results.get("18-29").get("Party1"));
        assertEquals(1, (int) results.get("40-49").get("Party1"));
    }

    @Test
    public void testGetResultsByGroupAgeElectionNotFound() {
        int electionId = 1;
        when(electionRepository.findById(electionId)).thenReturn(Optional.empty());
        ElectionNotFoundException exception = assertThrows(ElectionNotFoundException.class, () -> {
            statisticsService.getResultsByAgeGroup(electionId);
        });
        assertEquals("Election not found", exception.getMessage());
        verify(voteRepository, never()).findAll();
    }

    @Test
    public void testGetResultsByCityType() {
        int electionId = 1;
        PoliticalParty party1 = new PoliticalParty();
        party1.setName("Party1");
        Vote vote1 = mockVote(electionId, party1, CityType.OVER500THOUSAND);
        Vote vote2 = mockVote(electionId, party1, CityType.OVER500THOUSAND);
        Vote vote3 = mockVote(electionId, party1, CityType.TWOHUNDREDTO500THOUSAND);
        when(electionRepository.findById(electionId)).thenReturn(Optional.of(mockElection(electionId)));
        when(voteRepository.findAll()).thenReturn(Arrays.asList(vote1, vote2, vote3));
        Map<String, Map<String, Integer>> results = statisticsService.getResultsByCityType(electionId);
        assertEquals(2, (int) results.get("Powyżej 500 tysięcy").get("Party1"));
        assertEquals(1, (int) results.get("Pomiędzy 200 a 500 tysięcy").get("Party1"));
    }

    @Test
    public void testGetResultsBySex() {
        int electionId = 1;
        PoliticalParty party1 = new PoliticalParty();
        party1.setName("Party1");
        Vote vote1 = mockVote(electionId, party1, true);  // Male
        Vote vote2 = mockVote(electionId, party1, false); // Female
        Vote vote3 = mockVote(electionId, party1, true);  // Male
        when(electionRepository.findById(electionId)).thenReturn(Optional.of(mockElection(electionId)));
        when(voteRepository.findAll()).thenReturn(Arrays.asList(vote1, vote2, vote3));
        Map<String, Map<String, Integer>> results = statisticsService.getResultsBySex(electionId);
        assertEquals(2, (int) results.get("Mężczyzna").get("Party1"));
        assertEquals(1, (int) results.get("Kobieta").get("Party1"));
    }

    @Test
    public void testGetResultsBySexElectionNotFound() {
        int electionId = 1;
        when(electionRepository.findById(electionId)).thenReturn(Optional.empty());
        ElectionNotFoundException exception = assertThrows(ElectionNotFoundException.class, () -> {
            statisticsService.getResultsBySex(electionId);
        });
        assertEquals("Election not found", exception.getMessage());
        verify(voteRepository, never()).findAll();
    }

    @Test
    public void testGetResultsByCountry() {
        int electionId = 1;
        PoliticalParty party1 = new PoliticalParty();
        party1.setName("Party1");
        Vote vote1 = mockVote(electionId, party1);
        vote1.setVoterCountry("Poland");
        Vote vote2 = mockVote(electionId, party1);
        vote2.setVoterCountry("Germany");
        when(electionRepository.findById(electionId)).thenReturn(Optional.of(mockElection(electionId)));
        when(voteRepository.findAll()).thenReturn(Arrays.asList(vote1, vote2));
        Map<String, Map<String, Integer>> results = statisticsService.getResultsByCountry(electionId);
        assertEquals(1, (int) results.get("Poland").get("Party1"));
        assertEquals(1, (int) results.get("Germany").get("Party1"));
    }


    @Test
    public void testGetResultsByEducation() {
        int electionId = 1;
        PoliticalParty party1 = new PoliticalParty();
        party1.setName("Party1");
        Vote vote1 = mockVote(electionId, party1);
        vote1.setVoterEducation("Bachelor's Degree");
        Vote vote2 = mockVote(electionId, party1);
        vote2.setVoterEducation("Master's Degree");
        when(electionRepository.findById(electionId)).thenReturn(Optional.of(mockElection(electionId)));
        when(voteRepository.findAll()).thenReturn(Arrays.asList(vote1, vote2));
        Map<String, Map<String, Integer>> results = statisticsService.getResultsByEducation(electionId);
        assertEquals(1, (int) results.get("Bachelor's Degree").get("Party1"));
        assertEquals(1, (int) results.get("Master's Degree").get("Party1"));
    }

    @Test
    public void testGetResultsByEducationElectionNotFound() {
        int electionId = 1;
        when(electionRepository.findById(electionId)).thenReturn(Optional.empty());
        ElectionNotFoundException exception = assertThrows(ElectionNotFoundException.class, () -> {
            statisticsService.getResultsByEducation(electionId);
        });
        assertEquals("Election not found", exception.getMessage());
        verify(voteRepository, never()).findAll();
    }

    @Test
    public void testGetResultsByCityTypeElectionNotFound() {
        int electionId = 1;
        when(electionRepository.findById(electionId)).thenReturn(Optional.empty());
        ElectionNotFoundException exception = assertThrows(ElectionNotFoundException.class, () -> {
            statisticsService.getResultsByCityType(electionId);
        });
        assertEquals("Election not found", exception.getMessage());
        verify(voteRepository, never()).findAll();
    }

    @Test
    public void testGetResultsByCountryElectionNotFound() {
        int electionId = 1;
        when(electionRepository.findById(electionId)).thenReturn(Optional.empty());
        ElectionNotFoundException exception = assertThrows(ElectionNotFoundException.class, () -> {
            statisticsService.getResultsByCountry(electionId);
        });
        assertEquals("Election not found", exception.getMessage());
        verify(voteRepository, never()).findAll();
    }

    @Test
    public void testGetResultsElectionNotFound() {
        int electionId = 1;
        when(electionRepository.findById(electionId)).thenReturn(Optional.empty());
        assertThrows(ElectionNotFoundException.class, () -> statisticsService.getResults(electionId));
    }

    @Test
    public void testConvertCityTypeToString() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = StatisticsService.class.getDeclaredMethod("convertCityTypeToString", CityType.class);
        method.setAccessible(true);
        assertEquals("Pomiędzy 50 a 200 tysięcy", method.invoke(statisticsService, CityType.FIFTYTOTWOHUNDREDTHOUSAND));
        assertEquals("Poniżej 50 tysięcy", method.invoke(statisticsService, CityType.BELOWFIFTYTHOUSAND));
    }

    @Test
    public void testGetAgeGroup() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = StatisticsService.class.getDeclaredMethod("getAgeGroup", int.class);
        method.setAccessible(true);
        assertEquals("50-59", method.invoke(statisticsService, 51));
        assertEquals("60+", method.invoke(statisticsService, 61));
    }

    private Vote mockVote(int electionId, PoliticalParty party) {
        Vote vote = new Vote();
        vote.setCandidate(mockCandidate(electionId, party));
        return vote;
    }

    private Vote mockVote(int electionId, PoliticalParty party, CityType cityType) {
        Vote vote = mockVote(electionId, party);
        vote.setVoterCityType(cityType);
        return vote;
    }

    private Vote mockVote(int electionId, PoliticalParty party, boolean sex) {
        Vote vote = mockVote(electionId, party);
        vote.setSex(sex);
        return vote;
    }

    private Candidate mockCandidate(int electionId, PoliticalParty party) {
        Candidate candidate = new Candidate();
        Election election = mockElection(electionId);
        candidate.setElection(election);
        candidate.setPoliticalParty(party);
        return candidate;
    }

    private Election mockElection(int electionId) {
        Election election = new Election();
        election.setElectionId(electionId);
        return election;
    }

    private Vote mockVote(int electionId, String birthdate) {
        PoliticalParty party1 = new PoliticalParty();
        party1.setName("Party1");

        Vote vote = new Vote();
        vote.setCandidate(mockCandidate(electionId, party1));
        vote.setVoterBirthdate(Date.valueOf(birthdate));
        return vote;
    }


}
