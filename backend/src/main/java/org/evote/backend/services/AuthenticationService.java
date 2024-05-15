package org.evote.backend.services;

import org.evote.backend.config.JwtService;
import org.evote.backend.users.account.dtos.AccountCreateDTO;
import org.evote.backend.users.account.dtos.AccountLoginDTO;
import org.evote.backend.users.account.dtos.AccountMapper;
import org.evote.backend.users.account.dtos.AuthenticationResponseDTO;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountAlreadyExistsException;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.exceptions.PasswordTooShortException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(AccountRepository accountRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public Account register(AccountCreateDTO accountCreateDTO) throws AccountAlreadyExistsException {
        if (accountCreateDTO.getPassword().length() < 8) {
            throw new PasswordTooShortException("Password must be at least 8 characters long");
        }
        accountCreateDTO.setPassword(passwordEncoder.encode(accountCreateDTO.getPassword()));
        if (accountRepository.findByEmail(accountCreateDTO.getEmail()) != null) {
            throw new AccountAlreadyExistsException("Account already exists");
        }
        return accountRepository.save(AccountMapper.toAccount(accountCreateDTO));
    }

    public AuthenticationResponseDTO login(AccountLoginDTO accountLoginDTO) {
        Account dbAccount = accountRepository.findByEmail(accountLoginDTO.getEmail());
        if (dbAccount == null) {
            throw new AccountNotFoundException("Account not found");
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(accountLoginDTO.getEmail(), accountLoginDTO.getPassword()));
        return new AuthenticationResponseDTO(jwtService.generateToken(dbAccount));
    }
}
