package org.evote.backend.unit.services;

import org.evote.backend.config.JwtService;
import org.evote.backend.services.VotingService;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.exceptions.UserAlreadyVotedException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.evote.backend.users.address.entity.Address;
import org.evote.backend.users.enums.CityType;
import org.evote.backend.users.enums.Education;
import org.evote.backend.users.precinct.entity.Precinct;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.exceptions.UserNotFoundException;
import org.evote.backend.users.user.repository.UserRepository;
import org.evote.backend.users.enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VotingServiceTests {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private JwtService jwtService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private VotingService votingService;

    private Account account;
    private User user;
    private int id;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        id = 1;
        user = new User();
        user.setCode("validCode");

        account = new Account();
        account.setEmail("test@example.com");
        account.setPassword("password");
        account.setRole(Role.USER); // Ustawienie roli
        account.setHasVoted(false);
        account.setIsAccountActive(true);
        account.setUser(user);
    }

    @Test
    public void testHasVotedAccountNotFound() {
        when(accountRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(AccountNotFoundException.class, () -> votingService.hasVoted(id));
    }

    @Test
    public void testHasVoted() {
        account.setHasVoted(true);
        when(accountRepository.findById(id)).thenReturn(Optional.of(account));
        assertTrue(votingService.hasVoted(id));
    }

    @Test
    public void testVerifyCodeAccountNotFound() {
        when(accountRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(AccountNotFoundException.class, () -> votingService.verifyCode(id, "anyCode"));
    }

    @Test
    public void testVerifyCodeUserNotFound() {
        account.setUser(null);
        when(accountRepository.findById(id)).thenReturn(Optional.of(account));
        assertThrows(UserNotFoundException.class, () -> votingService.verifyCode(id, "anyCode"));
    }

    @Test
    public void testVerifyCodeInvalidCode() {
        when(accountRepository.findById(id)).thenReturn(Optional.of(account));
        assertFalse(votingService.verifyCode(id, "invalidCode"));
    }

    @Test
    public void testVerifyCodeValidCode() {
        when(accountRepository.findById(id)).thenReturn(Optional.of(account));
        assertTrue(votingService.verifyCode(id, "validCode"));
    }

    @Test
    public void testGenerateVotingTokenAccountNotFound() {
        when(accountRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(AccountNotFoundException.class, () -> votingService.generateVotingToken(id));
    }

    @Test
    public void testGenerateVotingTokenUserAlreadyVoted() {
        account.setHasVoted(true);
        when(accountRepository.findById(id)).thenReturn(Optional.of(account));
        assertThrows(UserAlreadyVotedException.class, () -> votingService.generateVotingToken(id));
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

        String token = votingService.generateVotingToken(id);

        assertEquals("newVotingToken", token);
        assertTrue(account.getHasVoted());
        verify(accountRepository, times(1)).save(account);
    }
}
