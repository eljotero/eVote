package org.evote.backend.services;

import org.evote.backend.config.JwtService;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.exceptions.UserAlreadyVotedException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.exceptions.UserNotFoundException;
import org.evote.backend.users.user.repository.UserRepository;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.evote.backend.votes.enums.CityType;
import org.evote.backend.votes.vote.dtos.SingleVoteDTO;
import org.evote.backend.votes.vote.dtos.VoteDTO;
import org.evote.backend.votes.vote.entity.Vote;
import org.evote.backend.votes.vote.repository.VoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Service
public class VotingService {

    private final AccountRepository accountRepository;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final CandidateService candidateService;
    private final VoteRepository voteRepository;

    public VotingService(AccountRepository accountRepository, JwtService jwtService, UserRepository userRepository, CandidateService candidateService, VoteRepository voteRepository) {
        this.accountRepository = accountRepository;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.candidateService = candidateService;
        this.voteRepository = voteRepository;
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
        String token = jwtService.generateVotingToken(account);
//        account.setHasVoted(true);
//        accountRepository.save(account);
        return token;
    }

    @Transactional(value = "chainedTransactionManager")
    public String vote(String token, VoteDTO voteDTO) {
        String email = jwtService.extractEmail(token);
        Account account = accountRepository.findByEmail(email);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }
        User user = account.getUser();
        if (user == null) {
            throw new UserNotFoundException("User associated with this account not found");
        }
        if (hasVoted(account.getAccount_id())) {
            throw new UserAlreadyVotedException("User has already voted");
        }
        List<SingleVoteDTO> votes = voteDTO.getVotes();
        for (SingleVoteDTO vote : votes) {
            Vote newVote = new Vote();
            Candidate candidate = candidateService.getCandidateById(vote.getCandidateId());
            newVote.setCandidate(candidate);
            newVote.setVoterBirthdate(user.getBirthDate());
            newVote.setVoterCityType(CityType.valueOf(user.getCityType().toString()));
            newVote.setVoterEducation(user.getEducation().toString());
            newVote.setSex(user.getSex());
            newVote.setVoterCountry(user.getAddress().getCountry());
            newVote.setVoteTime(Time.valueOf(LocalTime.now()));
            voteRepository.save(newVote);
        }
        return "Voted successfully";
    }
}
