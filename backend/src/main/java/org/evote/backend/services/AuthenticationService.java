package org.evote.backend.services;

import jakarta.transaction.Transactional;
import org.evote.backend.config.JwtService;
import org.evote.backend.users.account.dtos.AccountCreateDTO;
import org.evote.backend.users.account.dtos.AccountLoginDTO;
import org.evote.backend.users.account.dtos.AccountMapper;
import org.evote.backend.users.account.dtos.AuthenticationResponseDTO;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountAlreadyExistsException;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.exceptions.PasswordTooShortException;
import org.evote.backend.users.account.exceptions.UserAlreadyVotedException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.evote.backend.users.address.entity.Address;
import org.evote.backend.users.address.repository.UserAddressRepository;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.repository.UserRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final UserAddressRepository userAddressRepository;

    public AuthenticationService(AccountRepository accountRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager, UserRepository userRepository, UserAddressRepository userAddressRepository) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.userAddressRepository = userAddressRepository;
    }

    @Transactional
    public Account register(AccountCreateDTO accountCreateDTO) throws AccountAlreadyExistsException {
        if (accountCreateDTO.getPassword().length() < 8) {
            throw new PasswordTooShortException("Password must be at least 8 characters long");
        }
        if (accountRepository.findByEmail(accountCreateDTO.getEmail()) != null) {
            throw new AccountAlreadyExistsException("Account already exists");
        }
        accountCreateDTO.setPassword(passwordEncoder.encode(accountCreateDTO.getPassword()));
        User user = new User();
        Address address = new Address();
        Account account = AccountMapper.toAccount(accountCreateDTO);
        try {
            Address savedAddress = userAddressRepository.save(address);
            user.setAddress(savedAddress);
            User savedUser = userRepository.save(user);
            account.setUser(savedUser);
            return accountRepository.save(account);
        } catch (DataAccessException e) {
            throw new AccountAlreadyExistsException("Error while creating account");
        }
    }

    public AuthenticationResponseDTO login(AccountLoginDTO accountLoginDTO) {
        Account dbAccount = accountRepository.findByEmail(accountLoginDTO.getEmail());
        if (dbAccount == null) {
            throw new AccountNotFoundException("Account not found");
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(accountLoginDTO.getEmail(), accountLoginDTO.getPassword()));
        return new AuthenticationResponseDTO(jwtService.generateToken(dbAccount), dbAccount.getAccount_id());
    }

    public Boolean hasAccount(Integer ID) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountRepository.findByEmail(email);
        if (account == null) {
            return false;
        }
        return account.getAccount_id().equals(ID);
    }

}
