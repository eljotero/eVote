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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
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
        Election election = new Election();
        election.setElectionId(electionId);
        PoliticalParty party1 = new PoliticalParty();
        party1.setName("Party1");
        Vote vote1 = new Vote();
        Candidate candidate1 = new Candidate();
        candidate1.setElection(election);
        candidate1.setPoliticalParty(party1);
        vote1.setCandidate(candidate1);
        Vote vote2 = new Vote();
        Candidate candidate2 = new Candidate();
        candidate2.setElection(election);
        candidate2.setPoliticalParty(party1);
        vote2.setCandidate(candidate2);
        when(electionRepository.findById(electionId)).thenReturn(Optional.of(election));
        when(voteRepository.findAll()).thenReturn(Arrays.asList(vote1, vote2));
        Map<String, Integer> results = statisticsService.getResults(electionId);
        assertEquals(2, (int) results.get("Party1"));
    }
    private Vote createVote(Election election, PoliticalParty party, java.sql.Date birthdate) {
        Vote vote = new Vote();
        Candidate candidate = new Candidate();
        candidate.setElection(election);
        candidate.setPoliticalParty(party);
        vote.setCandidate(candidate);
        vote.setVoterBirthdate(birthdate);
        return vote;
    }

    @Test
    public void testGetResultsByAgeGroup() throws ParseException {
        int electionId = 1;
        PoliticalParty party1 = new PoliticalParty();
        party1.setName("Party1");
        Election election = new Election();
        election.setElectionId(electionId);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate1 = new java.sql.Date(dateFormat.parse("1990-01-01").getTime());
        java.sql.Date sqlDate2 = new java.sql.Date(dateFormat.parse("1980-01-01").getTime());
        java.sql.Date sqlDate3 = new java.sql.Date(dateFormat.parse("2000-01-01").getTime());
        java.sql.Date sqlDate4 = new java.sql.Date(dateFormat.parse("1966-01-01").getTime());
        java.sql.Date sqlDate5 = new java.sql.Date(dateFormat.parse("1950-01-01").getTime());
        Vote vote1 = createVote(election, party1, sqlDate1);
        Vote vote2 = createVote(election, party1, sqlDate2);
        Vote vote3 = createVote(election, party1, sqlDate3);
        Vote vote4 = createVote(election, party1, sqlDate4);
        Vote vote5 = createVote(election, party1, sqlDate5);
        List<Vote> votes = Arrays.asList(vote1, vote2, vote3, vote4, vote5);
        when(electionRepository.findById(electionId)).thenReturn(Optional.of(election));
        when(voteRepository.findAll()).thenReturn(votes);
        Map<String, Map<String, Integer>> results = statisticsService.getResultsByAgeGroup(electionId);
        assertEquals(1, (int) results.get("18-29").get("Party1"));
        assertEquals(1, (int) results.get("30-39").get("Party1"));
        assertEquals(1, (int) results.get("40-49").get("Party1"));
        assertEquals(1, (int) results.get("50-59").get("Party1"));
        assertEquals(1, (int) results.get("60+").get("Party1"));
    }





    @Test
    public void testGetResultsByCityType() {
        int electionId = 1;
        PoliticalParty party1 = new PoliticalParty();
        party1.setName("Party1");
        Election election = new Election();
        election.setElectionId(electionId);
        Vote vote1 = createVote(election, party1, CityType.OVER500THOUSAND);
        Vote vote2 = createVote(election, party1, CityType.OVER500THOUSAND);
        Vote vote3 = createVote(election, party1, CityType.FIFTYTOTWOHUNDREDTHOUSAND);
        Vote vote4 = createVote(election, party1, CityType.FIFTYTOTWOHUNDREDTHOUSAND);
        List<Vote> votes = Arrays.asList(vote1, vote2, vote3, vote4);
        when(electionRepository.findById(electionId)).thenReturn(Optional.of(election));
        when(voteRepository.findAll()).thenReturn(votes);
        Map<String, Map<String, Integer>> results = statisticsService.getResultsByCityType(electionId);
        assertEquals(2, (int) results.get("Powyżej 500 tysięcy").get("Party1")); // zmieniono na 2
        assertEquals(2, (int) results.get("Pomiędzy 50 a 200 tysięcy").get("Party1")); // zmieniono na 2
        assertEquals(0, (int) results.getOrDefault("Pomiędzy 200 a 500 tysięcy", Collections.emptyMap()).getOrDefault("Party1", 0)); // dodano sprawdzenie dla brakującego typu miasta
        assertEquals(0, (int) results.getOrDefault("Poniżej 50 tysięcy", Collections.emptyMap()).getOrDefault("Party1", 0)); // dodano sprawdzenie dla brakującego typu miasta
    }

    private Vote createVote(Election election, PoliticalParty party, CityType cityType) {
        Vote vote = new Vote();
        Candidate candidate = new Candidate();
        candidate.setElection(election);
        candidate.setPoliticalParty(party);
        vote.setCandidate(candidate);
        vote.setVoterCityType(cityType);
        return vote;
    }


    @Test
    public void testDistributeSejmMandates_ElectionNotFound() {
        int electionId = 1;
        when(electionRepository.findById(electionId)).thenReturn(Optional.empty());

        ElectionNotFoundException exception = assertThrows(ElectionNotFoundException.class, () -> {
            statisticsService.distributeSejmMandates(electionId);
        });
        assertEquals("Election with id " + electionId + " not found", exception.getMessage());
        verify(voteRepository, never()).findAll();
    }

    @Test
    public void testCalculateMandatesDHondt() {
        Map<String, Integer> partyVotes = new HashMap<>();
        partyVotes.put("Party1", 5000);
        partyVotes.put("Party2", 4000);
        partyVotes.put("Party3", 3000);
        partyVotes.put("Party4", 2000);
        partyVotes.put("Party5", 1000);
        int totalSeats = 10;
        Map<String, Integer> expectedSeats = new HashMap<>();
        expectedSeats.put("Party1", 4);
        expectedSeats.put("Party2", 3);
        expectedSeats.put("Party3", 2);
        expectedSeats.put("Party4", 1);
        Map<String, Integer> actualSeats = statisticsService.calculateMandatesDHondt(partyVotes, totalSeats);
        assertEquals(expectedSeats, actualSeats);
    }

    @Test
    public void testGetResultsByCountry() {
        int electionId = 1;
        PoliticalParty party1 = new PoliticalParty();
        party1.setName("Party1");
        Election election = new Election();
        election.setElectionId(electionId);
        Vote vote1 = createVote(election, party1, "Poland");
        Vote vote2 = createVote(election, party1, "Germany");
        when(electionRepository.findById(electionId)).thenReturn(Optional.of(election));
        when(voteRepository.findAll()).thenReturn(Arrays.asList(vote1, vote2));
        Map<String, Map<String, Integer>> results = statisticsService.getResultsByCountry(electionId);
        assertEquals(1, (int) results.get("Poland").get("Party1"));
        assertEquals(1, (int) results.get("Germany").get("Party1"));
    }

    private Vote createVote(Election election, PoliticalParty party, String country) {
        Vote vote = new Vote();
        Candidate candidate = new Candidate();
        candidate.setElection(election);
        candidate.setPoliticalParty(party);
        vote.setCandidate(candidate);
        vote.setVoterCountry(country);
        return vote;
    }

    @Test
    public void testGetResultsByEducation_ElectionNotFound() {
        int electionId = 1;
        when(electionRepository.findById(electionId)).thenReturn(Optional.empty());

        ElectionNotFoundException exception = assertThrows(ElectionNotFoundException.class, () -> {
            statisticsService.getResultsByEducation(electionId);
        });

        assertEquals("Election not found", exception.getMessage());
    }
    @Test
    public void testGetResultsBySex() {
        int electionId = 1;
        PoliticalParty party1 = new PoliticalParty();
        party1.setName("Party1");
        Election election = new Election();
        election.setElectionId(electionId);
        Vote vote1 = createVote(election, party1, true);
        Vote vote2 = createVote(election, party1, true);
        Vote vote3 = createVote(election, party1, false);
        Vote vote4 = createVote(election, party1, false);
        List<Vote> votes = Arrays.asList(vote1, vote2, vote3, vote4);
        when(electionRepository.findById(electionId)).thenReturn(Optional.of(election));
        when(voteRepository.findAll()).thenReturn(votes);
        Map<String, Map<String, Integer>> results = statisticsService.getResultsBySex(electionId);
        assertEquals(2, (int) results.get("Mężczyzna").get("Party1"));
        assertEquals(2, (int) results.get("Kobieta").get("Party1"));
    }

    private Vote createVote(Election election, PoliticalParty party, boolean sex) {
        Vote vote = new Vote();
        Candidate candidate = new Candidate();
        candidate.setElection(election);
        candidate.setPoliticalParty(party);
        vote.setCandidate(candidate);
        vote.setSex(sex);
        return vote;
    }

    @Test
    public void testGetResultsByEducation() {
        int electionId = 1;
        PoliticalParty party1 = new PoliticalParty();
        party1.setName("Party1");
        Election election = new Election();
        election.setElectionId(electionId);
        Vote vote1 = createVote2(election, party1, "POST_SECONDARY");
        Vote vote2 = createVote2(election, party1, "SECONDARY");
        List<Vote> votes = Arrays.asList(vote1, vote2);
        when(electionRepository.findById(electionId)).thenReturn(Optional.of(election));
        when(voteRepository.findAll()).thenReturn(votes);
        Map<String, Map<String, Integer>> results = statisticsService.getResultsByEducation(electionId);
        assertEquals(1, (int) results.get("wyższe").get("Party1"));
        assertEquals(1, (int) results.get("średnie").get("Party1"));
    }

    private Vote createVote2(Election election, PoliticalParty party, String education) {
        Vote vote = new Vote();
        Candidate candidate = new Candidate();
        candidate.setElection(election);
        candidate.setPoliticalParty(party);
        vote.setCandidate(candidate);
        vote.setVoterEducation(education);
        return vote;
    }

    @Test
    public void testDistributeSejmMandates() {
        int electionId = 1;
        PoliticalParty party1 = new PoliticalParty();
        party1.setName("Party1");
        Election election = new Election();
        election.setElectionId(electionId);
        Vote vote1 = new Vote();
        Candidate candidate1 = new Candidate();
        candidate1.setElection(election);
        candidate1.setPoliticalParty(party1);
        vote1.setCandidate(candidate1);
        Vote vote2 = new Vote();
        Candidate candidate2 = new Candidate();
        candidate2.setElection(election);
        candidate2.setPoliticalParty(party1);
        vote2.setCandidate(candidate2);
        List<Vote> votes = Arrays.asList(vote1, vote2);
        when(electionRepository.findById(electionId)).thenReturn(Optional.of(election));
        when(voteRepository.findAll()).thenReturn(votes);
        Map<String, Integer> results = statisticsService.distributeSejmMandates(electionId);
        assertEquals(460, (int) results.get("Party1"));
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

    @Test
    public void testGetResultsElectionNotFound() {
        int electionId = 1;
        when(electionRepository.findById(electionId)).thenReturn(Optional.empty());
        assertThrows(ElectionNotFoundException.class, () -> statisticsService.getResults(electionId));
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
    public void testGetResultsByAgeElectionNotFound() {
        int electionId = 1;
        when(electionRepository.findById(electionId)).thenReturn(Optional.empty());
        ElectionNotFoundException exception = assertThrows(ElectionNotFoundException.class, () -> {
            statisticsService.getResultsByAgeGroup(electionId);
        });
        assertEquals("Election not found", exception.getMessage());
        verify(voteRepository, never()).findAll();
    }


}