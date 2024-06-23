package org.evote.backend.services;

import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountAlreadyExistsException;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.exceptions.UserAlreadyVotedException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {


    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Cacheable(value = "accounts")
    public Account getAccountById(Integer id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account with id " + id + " not found"));
    }

    public Account addAccount(Account account) {
        if (accountRepository.findByEmail(account.getEmail()) != null) {
            throw new AccountAlreadyExistsException("Account with email " + account.getEmail() + " already exists");
        }
        return accountRepository.save(account);
    }

    public void deleteAccount(Integer id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account with id " + id + " not found"));
        accountRepository.delete(account);
    }

    public Optional<Account> getAccountByEmail(String email) {
        return Optional.ofNullable(accountRepository.findByEmail(email));
    }

    public Boolean hasUserVoted(Account account) {
        if (account.getHasVoted()) {
            throw new UserAlreadyVotedException("User has already voted");
        }
        return false;
    }
}
