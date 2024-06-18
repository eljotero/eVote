
package org.evote.backend.unit.services;

import org.evote.backend.services.AccountService;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountAlreadyExistsException;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.exceptions.UserAlreadyVotedException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccountServiceTests {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    private Account account;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        account = new Account();
        account.setEmail("test@test.com");
        account.setPassword("password");
    }

    @Test
    public void testAddAccount() {
        when(accountRepository.findByEmail(account.getEmail())).thenReturn(null);
        when(accountRepository.save(account)).thenReturn(account);

        Account createdAccount = accountService.addAccount(account);

        assertNotNull(createdAccount);
        assertEquals(account.getEmail(), createdAccount.getEmail());
        verify(accountRepository, times(1)).findByEmail(account.getEmail());
        verify(accountRepository, times(1)).save(account);
    }

    @Test
    public void testAddAccountAlreadyExists() {
        when(accountRepository.findByEmail(account.getEmail())).thenReturn(account);

        AccountAlreadyExistsException exception = assertThrows(AccountAlreadyExistsException.class, () -> accountService.addAccount(account));
        assertEquals("Account with email " + account.getEmail() + " already exists", exception.getMessage());
        verify(accountRepository, times(1)).findByEmail(account.getEmail());
    }

    @Test
    public void testGetAccountById() {
        when(accountRepository.findById(account.getAccount_id())).thenReturn(Optional.of(account));

        Account foundAccount = accountService.getAccountById(account.getAccount_id());

        assertNotNull(foundAccount);
        assertEquals(account.getAccount_id(), foundAccount.getAccount_id());
        verify(accountRepository, times(1)).findById(account.getAccount_id());
    }

    @Test
    public void testGetAccountByIdNotFound() {
        when(accountRepository.findById(account.getAccount_id())).thenReturn(Optional.empty());

        AccountNotFoundException exception = assertThrows(AccountNotFoundException.class, () -> accountService.getAccountById(account.getAccount_id()));
        assertEquals("Account with id " + account.getAccount_id() + " not found", exception.getMessage());
        verify(accountRepository, times(1)).findById(account.getAccount_id());
    }


    @Test
    public void testGetAllAccounts() {
        when(accountRepository.findAll()).thenReturn(List.of(account));
        List<Account> expectedAccounts = List.of(account);
        List<Account> actualAccounts = accountService.getAllAccounts();

        assertNotNull(actualAccounts);
        assertEquals(expectedAccounts.size(), actualAccounts.size());
        assertTrue(actualAccounts.containsAll(expectedAccounts));
        verify(accountRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteAccount() {
        when(accountRepository.findById(account.getAccount_id())).thenReturn(Optional.of(account));
        accountService.deleteAccount(account.getAccount_id());
        verify(accountRepository, times(1)).delete(account);
    }

    @Test
    public void testDeleteAccountAccountNotFound() {
        when(accountRepository.findById(account.getAccount_id())).thenReturn(Optional.empty());
        assertThrows(AccountNotFoundException.class, () -> accountService.deleteAccount(account.getAccount_id()));
    }

    @Test
    public void testGetAccountByEmail() {
        when(accountRepository.findByEmail(account.getEmail())).thenReturn(account);
        Optional<Account> result = accountService.getAccountByEmail(account.getEmail());
        assertEquals(account, result.get());
    }

    @Test
    public void testHasUserVoted() {
        Account account = new Account();
        account.setHasVoted(false);
        when(accountRepository.findByEmail(account.getEmail())).thenReturn(account);
        assertEquals(false, accountService.hasUserVoted(account));
        assertEquals(false, account.getHasVoted());
    }

    @Test
    public void testHasUserVotedAlreadyVoted() {
        Account account = new Account();
        account.setHasVoted(true);
        when(accountRepository.findByEmail(account.getEmail())).thenReturn(account);
        UserAlreadyVotedException exception = assertThrows(UserAlreadyVotedException.class, () -> accountService.hasUserVoted(account));
        assertEquals("User has already voted", exception.getMessage());
    }

}


