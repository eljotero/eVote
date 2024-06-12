package org.evote.backend.unit.controllers;


import org.evote.backend.controllers.AccountController;
import org.evote.backend.users.account.dtos.AccountDTO;
import org.evote.backend.services.AccountService;
import org.evote.backend.users.account.dtos.AccountMapper;
import org.evote.backend.users.account.dtos.AccountUserDTO;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.address.entity.Address;
import org.evote.backend.users.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class AccountControllerTests {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    private Account account;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        accountController = new AccountController(accountService);
        account = new Account();
        account.setEmail("test@test.com");
        account.setPassword("password");
        User user = new User();
        user.setName("John");
        user.setSurname("Doe");
        Address address = new Address();
        user.setAddress(address);
        account.setUser(user);
    }

    @Test
    public void testGetAllAccount() {
        List<Account> accounts = Arrays.asList(account);
        when(accountService.getAllAccounts()).thenReturn(accounts);

        ResponseEntity<List<AccountDTO>> responseEntity = accountController.getAllAccounts();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(accounts.size(), responseEntity.getBody().size());
    }


    @Test
    public void testSetAccountToInactiveAccountById() {
        Integer accountId = 1;

        accountController.setAccountToInactive(accountId);

        ResponseEntity<Void> responseEntity = accountController.setAccountToInactive(accountId);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

    @Test
    public void testGetAccountById() {
        Integer accountId = 1;

        when(accountService.getAccountById(accountId)).thenReturn(account);
        AccountUserDTO expectedAccountUserDTO = AccountMapper.toAccountUserDTO(account);
        assertEquals(expectedAccountUserDTO.getEmail(), accountController.getAccountById(accountId).getBody().getEmail());
        assertEquals(expectedAccountUserDTO.getName(), accountController.getAccountById(accountId).getBody().getName());
        assertEquals(expectedAccountUserDTO.getSurname(), accountController.getAccountById(accountId).getBody().getSurname());
        assertEquals(expectedAccountUserDTO.getSex(), accountController.getAccountById(accountId).getBody().getSex());
        assertEquals(expectedAccountUserDTO.getBirthDate(), accountController.getAccountById(accountId).getBody().getBirthDate());
        assertEquals(expectedAccountUserDTO.getEducation(), accountController.getAccountById(accountId).getBody().getEducation());
        assertEquals(expectedAccountUserDTO.getProfession(), accountController.getAccountById(accountId).getBody().getProfession());
    }

}