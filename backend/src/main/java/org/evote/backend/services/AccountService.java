package org.evote.backend.services;

import jakarta.transaction.Transactional;
import org.evote.backend.dtos.user.UserUpdateDTO;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountAlreadyExistsException;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void setAccountToInactive(Integer id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account with id " + id + " not found"));
        account.setIsAccountActive(false);
        accountRepository.save(account);
    }
}
