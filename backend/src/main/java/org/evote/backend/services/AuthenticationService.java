package org.evote.backend.services;

import jakarta.transaction.Transactional;
import org.evote.backend.config.JwtService;
import org.evote.backend.dtos.user.AuthenticationResponseDTO;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountAlreadyExistsException;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.exceptions.PasswordTooShortException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.repository.UserRepository;
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
    private final UserRepository userRepository;

    public AuthenticationService(AccountRepository accountRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    @Transactional
    public String register(Account account) throws AccountAlreadyExistsException {
        if (account.getPassword().length() < 8) {
            throw new PasswordTooShortException("Password must be at least 8 characters long");
        }
        if (accountRepository.findByEmail(account.getEmail()) != null) {
            throw new AccountAlreadyExistsException("Account already exists");
        }
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        User user = new User();
        try {
            User savedUser = userRepository.save(user);
            account.setUser(savedUser);
            accountRepository.save(account);
        } catch (DataAccessException e) {
            throw new AccountAlreadyExistsException("Error while creating account");
        }
        return "Account created successfully";
    }

    public AuthenticationResponseDTO login(Account account) {
        Account dbAccount = accountRepository.findByEmail(account.getUsername());
        if (dbAccount == null) {
            throw new AccountNotFoundException("Account not found");
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
        return new AuthenticationResponseDTO(jwtService.generateToken(dbAccount));
    }
}
