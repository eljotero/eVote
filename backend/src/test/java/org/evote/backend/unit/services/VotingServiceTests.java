package org.evote.backend.unit.services;

import org.evote.backend.configuration.JwtService;
import org.evote.backend.services.*;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.exceptions.UserAlreadyVotedException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.evote.backend.users.address.entity.Address;
import org.evote.backend.users.enums.CityType;
import org.evote.backend.users.enums.Education;
import org.evote.backend.users.enums.Role;
import org.evote.backend.users.precinct.entity.Precinct;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.exceptions.CodeMismatchException;
import org.evote.backend.users.user.exceptions.UserNotFoundException;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.evote.backend.votes.candidate.exception.CandidateWrongPrecinctException;
import org.evote.backend.votes.election.entity.Election;
import org.evote.backend.votes.election.exception.ElectionInvalidDateException;
import org.evote.backend.votes.enums.ElectionType;
import org.evote.backend.votes.vote.dtos.SingleVoteDTO;
import org.evote.backend.votes.vote.dtos.VoteDTO;
import org.evote.backend.votes.vote.entity.Vote;
import org.evote.backend.votes.vote.repository.VoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class VotingServiceTests {

    @Mock
    private JwtService jwtService;

    @Mock
    private AccountService accountService;

    @Mock
    private CandidateService candidateService;

    @Mock
    private VoteRepository voteRepository;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private UserService userService;

    @Mock
    private AddressService addressService;

    @InjectMocks
    private VotingService votingService;

    private Account account;

    private User user;

    private Candidate candidate;

    private Address address;

    private Precinct precinct;

    private Election election;

    private SingleVoteDTO singleVoteDTO;

    private VoteDTO voteDTO;

    private org.evote.backend.votes.precinct.entity.Precinct precinct_votes;

    private org.evote.backend.votes.precinct.entity.Precinct precinct_votes_2;

    private int id;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        id = 1;

        address = new Address();
        address.setAddress_id(id);

        precinct = new Precinct();
        precinct.setPrecinct_id(id);
        precinct.setElectionType(org.evote.backend.users.enums.ElectionType.Senate);

        precinct_votes = new org.evote.backend.votes.precinct.entity.Precinct();
        precinct_votes.setPrecinct_id(id);
        precinct_votes.setElectionType(ElectionType.Senate);

        precinct_votes_2 = new org.evote.backend.votes.precinct.entity.Precinct();
        precinct_votes_2.setPrecinct_id(2);
        precinct_votes_2.setElectionType(ElectionType.Presidential);

        election = new Election();
        election.setElectionId(2);
        election.setType(ElectionType.Senate);
        LocalDate localDate = LocalDate.parse("1999-01-01");
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        election.setStartDate(date);
        LocalDate localDate1 = LocalDate.parse("2029-01-02");
        Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
        election.setEndDate(date1);

        user = new User();
        user.setUser_id(UUID.randomUUID());
        user.setCode("validCode");
        user.setName("John");
        user.setSurname("Doe");
        user.setSex(true);
        user.setPersonalIdNumber("123456789");
        user.setBirthDate(new Date());
        user.setEducation(Education.PRIMARY);
        user.setCityType(CityType.BELOWFIFTYTHOUSAND);
        user.setProfession("Engineer");
        user.setAddress(address);
        user.setPrecincts(List.of(precinct));

        account = new Account();
        account.setEmail("test@example.com");
        account.setPassword("password");
        account.setRole(Role.USER);
        account.setHasVoted(false);
        account.setIsAccountActive(true);
        account.setUser(user);

        candidate = new Candidate();
        candidate.setCandidateId(id);
        candidate.setPrecinct(precinct_votes);
        candidate.setElection(election);

        voteDTO = new VoteDTO();

        singleVoteDTO = new SingleVoteDTO();
        singleVoteDTO.setCandidateId(id);
        singleVoteDTO.setElectionId(2);
        voteDTO.setVotes(List.of(singleVoteDTO));

    }

    @Test
    public void generateVotingTokenTest() {
        when(accountService.getAccountByEmail("test")).thenReturn(Optional.of(account));
        when(jwtService.generateVotingToken(account)).thenReturn("token");
        String result = votingService.generateVotingToken("test", "validCode");
        assert (result.equals("token"));
    }

    @Test
    public void generateVotingTokenTestInvalidAccount() {
        when(accountService.getAccountByEmail("test")).thenThrow(new AccountNotFoundException("Account not found"));
        assertThrows(AccountNotFoundException.class, () -> votingService.generateVotingToken("test", "validCode"));
    }

    @Test
    public void generateVotingTokenTestInvalidUser() {
        when(accountService.getAccountByEmail("test")).thenReturn(Optional.of(account));
        account.setUser(null);
        assertThrows(UserNotFoundException.class, () -> votingService.generateVotingToken("test", "validCode"));
    }

    @Test
    public void generateVotingTokenTestInvalidCode() {
        when(accountService.getAccountByEmail("test")).thenReturn(Optional.of(account));
        assertThrows(CodeMismatchException.class, () -> votingService.generateVotingToken("test", "invalidCode"));
    }

    @Test
    public void generateVotingTokenTestUserAlreadyVoted() {
        when(accountService.getAccountByEmail("test")).thenReturn(Optional.of(account));
        account.setHasVoted(true);
        assertThrows(UserAlreadyVotedException.class, () -> votingService.generateVotingToken("test", "validCode"));
    }

    @Test
    public void voteTest() {
        when(jwtService.extractEmail("token")).thenReturn("test@mail.com");
        when(accountService.getAccountByEmail("test@mail.com")).thenReturn(Optional.of(account));
        when(userService.isUserDataComplete(account.getUser().getUser_id())).thenReturn(true);
        when(addressService.isAddressDataComplete(account.getUser().getAddress().getAddress_id())).thenReturn(true);
        when(accountService.hasUserVoted(account)).thenReturn(false);
        when(candidateService.getCandidateById(id)).thenReturn(candidate);
        when(voteRepository.save(new Vote())).thenReturn(new Vote());
        when(accountRepository.save(account)).thenReturn(account);
        assertEquals("Voted successfully", votingService.vote("token", voteDTO));
    }

    @Test
    public void voteTestAccountNotFound() {
        when(jwtService.extractEmail("token")).thenReturn("test@mail.com");
        when(accountService.getAccountByEmail("test@mail.com")).thenReturn(Optional.empty());
        assertThrows(AccountNotFoundException.class, () -> votingService.vote("token", voteDTO));
    }

    @Test
    public void testGenerateVotingToken() {
        user.setSex(true);
        user.setAddress(new Address());
        user.setPrecincts(new ArrayList<Precinct>());
        user.setName("Test Name");
        user.setSurname("Test Surname");
        user.setBirthDate(new java.util.Date());
        user.setPersonalIdNumber("Test ID Number");
        user.setEducation(Education.SECONDARY);
        user.setCityType(CityType.OVER500THOUSAND);
        user.setProfession("Test Profession");

        when(accountRepository.findById(id)).thenReturn(Optional.of(account));
        when(jwtService.generateVotingToken(account)).thenReturn("newVotingToken");
    }

    @Test
    public void voteTestWrongCandidate() {
        when(jwtService.extractEmail("token")).thenReturn("test@mail.com");
        when(accountService.getAccountByEmail("test@mail.com")).thenReturn(Optional.of(account));
        when(userService.isUserDataComplete(account.getUser().getUser_id())).thenReturn(true);
        when(addressService.isAddressDataComplete(account.getUser().getAddress().getAddress_id())).thenReturn(true);
        when(accountService.hasUserVoted(account)).thenReturn(false);
        when(candidateService.getCandidateById(id)).thenReturn(candidate);
        candidate.setPrecinct(precinct_votes_2);
        assertThrows(CandidateWrongPrecinctException.class, () -> votingService.vote("token", voteDTO));
    }

    @Test
    public void voteTestInvalidData() {
        when(jwtService.extractEmail("token")).thenReturn("test@mail.com");
        when(accountService.getAccountByEmail("test@mail.com")).thenReturn(Optional.of(account));
        when(userService.isUserDataComplete(account.getUser().getUser_id())).thenReturn(false);
        assertEquals("Voting failed", votingService.vote("token", voteDTO));
    }

    @Test
    public void voteTestElectionNotStarted() {
        when(jwtService.extractEmail("token")).thenReturn("test@mail.com");
        when(accountService.getAccountByEmail("test@mail.com")).thenReturn(Optional.of(account));
        when(userService.isUserDataComplete(account.getUser().getUser_id())).thenReturn(true);
        when(addressService.isAddressDataComplete(account.getUser().getAddress().getAddress_id())).thenReturn(true);
        when(accountService.hasUserVoted(account)).thenReturn(false);
        when(candidateService.getCandidateById(id)).thenReturn(candidate);
        LocalDate localDate = LocalDate.parse("2025-01-01");
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        election.setStartDate(date);
        assertThrows(ElectionInvalidDateException.class, () -> votingService.vote("token", voteDTO));
    }

    @Test
    public void voteTestElectionEnded() {
        when(jwtService.extractEmail("token")).thenReturn("test@mail.com");
        when(accountService.getAccountByEmail("test@mail.com")).thenReturn(Optional.of(account));
        when(userService.isUserDataComplete(account.getUser().getUser_id())).thenReturn(true);
        when(addressService.isAddressDataComplete(account.getUser().getAddress().getAddress_id())).thenReturn(true);
        when(accountService.hasUserVoted(account)).thenReturn(false);
        when(candidateService.getCandidateById(id)).thenReturn(candidate);
        LocalDate localDate = LocalDate.parse("1410-01-01");
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        election.setEndDate(date);
        assertThrows(ElectionInvalidDateException.class, () -> votingService.vote("token", voteDTO));
    }

    @Test
    public void voteTestUserNotFound() {
        when(jwtService.extractEmail("token")).thenReturn("test@mail.com");
        when(accountService.getAccountByEmail("test@mail.com")).thenReturn(Optional.of(account));
        account.setUser(null);
        assertThrows(UserNotFoundException.class, () -> votingService.vote("token", voteDTO));
    }

}
