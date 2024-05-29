package org.evote.backend.services;

import org.evote.backend.config.JwtService;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.exceptions.UserAlreadyVotedException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.evote.backend.users.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class VotingService {

    private final AccountRepository accountRepository;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public VotingService(AccountRepository accountRepository, JwtService jwtService, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    public Boolean hasVoted(Integer accountID) {
        Account account = accountRepository.findById(accountID).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        if (Boolean.TRUE.equals(account.getHasVoted())) {
            return true;
        } else {
            return false;
        }
    }

    public String generateVotingToken(Integer accountID) {
        Account account = accountRepository.findById(accountID).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        if (hasVoted(accountID)) {
            throw new UserAlreadyVotedException("User has already voted");
        }
        String token = jwtService.generateVotingToken(account);
        account.setHasVoted(true);
        accountRepository.save(account);
        return token;
    }
}
