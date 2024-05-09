package org.evote.backend.unit.controllers;


import org.evote.backend.controllers.AccountController;
import org.evote.backend.dtos.user.AccountDTO;
import org.evote.backend.services.AccountService;
import org.evote.backend.users.account.entity.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTests {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;
    private Account account;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        account = new Account();
        account.setEmail("test@test.com");
        account.setPassword("password");
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

//    @Test
//    public void testGetAccountById() {
//        Integer accountId = 1;
//
//        when(accountService.getAccountById(accountId)).thenReturn(account);
//
//        ResponseEntity<AccountDTO> responseEntity = accountController.getAccountById(accountId);
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals(account.getEmail(), responseEntity.getBody().getEmail());
//    }

}