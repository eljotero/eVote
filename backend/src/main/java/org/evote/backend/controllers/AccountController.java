package org.evote.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.evote.backend.services.AccountService;
import org.evote.backend.users.account.dtos.AccountDTO;
import org.evote.backend.users.account.dtos.AccountMapper;
import org.evote.backend.users.account.dtos.AccountUserDTO;
import org.evote.backend.users.account.entity.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;


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
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ADMIN') or @authenticationService.hasAccount(#id)")
    @GetMapping("/{id}")
    public ResponseEntity<AccountUserDTO> getAccountById(@PathVariable Integer id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(AccountMapper.toAccountUserDTO(account));
    }

}



