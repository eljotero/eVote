package org.evote.backend.services;

import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountAlreadyExistsException;
import org.evote.backend.users.account.exceptions.AccountAuthenticationException;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

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

    public Account authenticate(String email, String password) {
        Account account = accountRepository.findByEmail(email);
        if (account == null) {
            throw new AccountAuthenticationException("Account with email " + email + " not found");
        }
        if (!account.getPassword().equals(password)) {
            throw new AccountAuthenticationException("Invalid password");
        }
        return account;
    }
}
