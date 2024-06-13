package org.evote.backend.services;

import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.exceptions.UserAlreadyVotedException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.exceptions.CodeMismatchException;
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

    public String generateVotingToken(String email, String code) {
        Account account = accountService.getAccountByEmail(email).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        User user = account.getUser();
        if (user == null) {
            throw new UserNotFoundException("User associated with this account not found");
        }
        if (!code.equals(user.getCode())) {
            throw new CodeMismatchException("Provided code does not match the user's code");
        }
        if (account.getHasVoted()) {
            throw new UserAlreadyVotedException("User has already voted");
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
        Account dbAccount = account.get();
        User user = dbAccount.getUser();
        if (user == null) {
            throw new UserNotFoundException("User associated with this account not found");
        }
        if (isDataValid(dbAccount)) {
            List<SingleVoteDTO> votes = voteDTO.getVotes();
            for (SingleVoteDTO vote : votes) {
                Candidate candidate = candidateService.getCandidateById(vote.getCandidateId());
                if (!isValidPrecinct(user, candidate)) {
                    throw new CandidateWrongPrecinctException("Candidate not found");
                }
                Vote newVote = new Vote() {{
                    setCandidate(candidate);
                    setVoterBirthdate(user.getBirthDate());
                    setVoterCityType(CityType.valueOf(user.getCityType().toString()));
                    setVoterEducation(user.getEducation().toString());
                    setSex(user.getSex());
                    setVoterCountry(user.getAddress().getCountry());
                    setVoteTime(Time.valueOf(LocalTime.now()));
                }};
                voteRepository.save(newVote);
            }
            dbAccount.setHasVoted(true);
            accountRepository.save(dbAccount);
            return "Voted successfully";
        }
        return "Voting failed";
    }

    private boolean isValidPrecinct(User user, Candidate candidate) {
        return user.getPrecincts().stream()
                .anyMatch(p -> p.getPrecinct_id().equals(candidate.getPrecinct().getPrecinct_id())
                        && ElectionType.valueOf(String.valueOf(p.getElectionType())) == candidate.getPrecinct().getElectionType());
    }

    private boolean isDataValid(Account account) {
        return userService.isUserDataComplete(account.getUser().getUser_id()) && addressService.isAddressDataComplete(account.getUser().getAddress().getAddress_id()) && !accountService.hasUserVoted(account);
    }
}
