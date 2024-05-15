
package org.evote.backend.unit.services;

import org.evote.backend.services.AccountService;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountAlreadyExistsException;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
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
    public void testSetAccountToInactive() {
        account.setIsAccountActive(true);

        when(accountRepository.findById(account.getAccount_id())).thenReturn(Optional.of(account));
        accountService.setAccountToInactive(account.getAccount_id());

        assertFalse(account.getIsAccountActive());
        verify(accountRepository, times(1)).save(account);

    }

    @Test
    public void testSetAccountToInactiveAccountNotFound() {
        when(accountRepository.findById(account.getAccount_id())).thenReturn(Optional.empty());

        AccountNotFoundException exception = assertThrows(AccountNotFoundException.class, () -> accountService.setAccountToInactive(account.getAccount_id()));
        assertEquals("Account with id " + account.getAccount_id() + " not found", exception.getMessage());
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

}


