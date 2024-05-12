package org.evote.backend.controllers;

import org.evote.backend.dtos.user.AccountDTO;
import org.evote.backend.dtos.user.AccountMapper;
import org.evote.backend.dtos.user.AccountUserDTO;
import org.evote.backend.services.AccountService;
import org.evote.backend.users.account.entity.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/account")
public class AccountController {


    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        List<Account> account = accountService.getAllAccounts();
        List<AccountDTO> accountDTOs = account.stream().map(AccountMapper::toAccountDTO).collect(Collectors.toList());
        return ResponseEntity.ok(accountDTOs);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> setAccountToInactive(@PathVariable Integer id) {
        accountService.setAccountToInactive(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('Admin') or @authenticationService.hasAccount(#id)")
    public ResponseEntity<AccountUserDTO> getAccountById(@PathVariable Integer id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(AccountMapper.toAccountUserDTO(account));
    }

}



