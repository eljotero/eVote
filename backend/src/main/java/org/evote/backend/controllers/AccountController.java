package org.evote.backend.controllers;

import org.evote.backend.dtos.user.*;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/all")
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        List<Account> account = accountService.getAllAccounts();
        List<AccountDTO> accountDTOs = account.stream().map(AccountMapper::toAccountDTO).collect(Collectors.toList());
        return ResponseEntity.ok(accountDTOs);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> setAccountToInactive(@PathVariable Integer id) {
        accountService.setAccountToInactive(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Integer id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(AccountMapper.toAccountDTO(account));
    }

}



