package org.evote.backend.services;

import org.evote.backend.config.JwtService;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.exceptions.UserAlreadyVotedException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.evote.backend.users.address.exceptions.AddressInfoNotComplete;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.exceptions.UserInfoNotComplete;
import org.evote.backend.users.user.exceptions.UserNotFoundException;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.evote.backend.votes.candidate.exception.CandidateWrongPrecinctException;
import org.evote.backend.votes.enums.CityType;
import org.evote.backend.votes.enums.ElectionType;
import org.evote.backend.votes.vote.dtos.SingleVoteDTO;
import org.evote.backend.votes.vote.dtos.VoteDTO;
import org.evote.backend.votes.vote.entity.Vote;
import org.evote.backend.votes.vote.repository.VoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class VotingService {

    private final AccountRepository accountRepository;
    private final JwtService jwtService;
    private final CandidateService candidateService;
    private final VoteRepository voteRepository;
    private final UserService userService;
    private final AddressService addressService;
    private final AccountService accountService;

    public VotingService(AccountRepository accountRepository, JwtService jwtService, CandidateService candidateService, VoteRepository voteRepository, UserService userService, AddressService addressService, AccountService accountService) {
        this.accountRepository = accountRepository;
        this.jwtService = jwtService;
        this.candidateService = candidateService;
        this.voteRepository = voteRepository;
        this.userService = userService;
        this.addressService = addressService;
        this.accountService = accountService;
    }

    public Boolean hasVoted(Integer id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        return Boolean.TRUE.equals(account.getHasVoted());
    }

    public boolean verifyCode(Integer id, String code) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        User user = account.getUser();
        if (user == null) {
            throw new UserNotFoundException("User associated with this account not found");
        }
        return code.equals(user.getCode());
    }

    public String generateVotingToken(Integer id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        if (hasVoted(id)) {
            throw new UserAlreadyVotedException("User has already voted");
        }
        if (!userService.isUserDataComplete(account.getUser().getUser_id())) {
            throw new UserInfoNotComplete("User data is not complete");
        }
        if (!addressService.isAddressDataComplete(account.getUser().getAddress().getAddress_id())) {
            throw new AddressInfoNotComplete("Address data is not complete");
        }
        return jwtService.generateVotingToken(account);
    }

    @Transactional(value = "chainedTransactionManager")
    public String vote(String token, VoteDTO voteDTO) {
        String email = jwtService.extractEmail(token);
        Optional<Account> account = accountService.getAccountByEmail(email);
        if (account.isEmpty()) {
            throw new AccountNotFoundException("Account not found");
        }
        User user = account.get().getUser();
        if (user == null) {
            throw new UserNotFoundException("User associated with this account not found");
        }
        if (!isDataValid(account.get())) {
            throw new UserInfoNotComplete("User data is not complete");
        }
        List<SingleVoteDTO> votes = voteDTO.getVotes();
        for (SingleVoteDTO vote : votes) {
            Vote newVote = new Vote();
            Candidate candidate = candidateService.getCandidateById(vote.getCandidateId());
            if (!isValidPrecinct(user, candidate)) {
                throw new CandidateWrongPrecinctException("Candidate not found");
            }
            newVote.setCandidate(candidate);
            newVote.setVoterBirthdate(user.getBirthDate());
            newVote.setVoterCityType(CityType.valueOf(user.getCityType().toString()));
            newVote.setVoterEducation(user.getEducation().toString());
            newVote.setSex(user.getSex());
            newVote.setVoterCountry(user.getAddress().getCountry());
            newVote.setVoteTime(Time.valueOf(LocalTime.now()));
            voteRepository.save(newVote);
        }
        account.get().setHasVoted(true);
        accountRepository.save(account.get());
        return "Voted successfully";
    }

    private boolean isValidPrecinct(User user, Candidate candidate) {
        return user.getPrecincts().stream()
                .anyMatch(p -> p.getPrecinct_id().equals(candidate.getPrecinct().getPrecinct_id())
                        && ElectionType.valueOf(String.valueOf(p.getElectionType())) == candidate.getPrecinct().getElectionType());
    }

    private boolean isDataValid(Account account) {
        return userService.isUserDataComplete(account.getUser().getUser_id()) && addressService.isAddressDataComplete(account.getUser().getAddress().getAddress_id()) && accountService.hasUserVoted(account);
    }
}
