package org.evote.backend.services;

import org.evote.backend.config.JwtService;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.exceptions.UserAlreadyVotedException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.evote.backend.votes.enums.CityType;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.exceptions.UserNotFoundException;
import org.evote.backend.users.user.repository.UserRepository;
import org.evote.backend.votes.candidate.repository.CandidateRepository;
import org.evote.backend.votes.vote.dtos.SubmitVoteDTO;
import org.evote.backend.votes.vote.entity.Vote;
import org.evote.backend.votes.vote.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
public class VotingService {

    private final AccountRepository accountRepository;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final VoteRepository voteRepository;
    private final CandidateRepository candidateRepository;

    public VotingService(AccountRepository accountRepository, JwtService jwtService, UserRepository userRepository, VoteRepository voteRepository, CandidateService candidateService, CandidateRepository candidateRepository) {
        this.accountRepository = accountRepository;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.voteRepository = voteRepository;
        this.candidateRepository = candidateRepository;
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
        User user = account.getUser();
        if (user == null) {
            throw new UserNotFoundException("User associated with this account not found");
        }
        if (user.getSex() == null || user.getAddress() == null || user.getPrecincts() == null || user.getName() == null
            || user.getSurname() == null || user.getBirthDate() == null || user.getPersonalIdNumber() == null
            || user.getEducation() == null || user.getCityType() == null || user.getProfession() == null) {
            throw new UserNotFoundException("User data is incomplete");
        }
        String token = jwtService.generateVotingToken(account);
        account.setHasVoted(true);
        accountRepository.save(account);
        return token;
    }

    public void submitVote(SubmitVoteDTO submitVoteDTO) {
        Vote vote = new Vote();
        vote.setVoter_birthdate(submitVoteDTO.getVoterBirthDate());
        vote.setVoter_city_type(submitVoteDTO.getVoterCityType());
        vote.setVoter_education(submitVoteDTO.getVoterEducation());
        vote.setVoter_country(submitVoteDTO.getVoterCountry());
        vote.setVote_time(new Time(System.currentTimeMillis()));
        vote.setCandidate(candidateRepository.findById(submitVoteDTO.getCandidateId())
                .orElseThrow(() -> new RuntimeException("Candidate not found")));

        voteRepository.save(vote);
    }

}
