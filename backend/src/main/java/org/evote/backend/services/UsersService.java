package org.evote.backend.services;

import jakarta.transaction.Transactional;
import org.evote.backend.dtos.user.UserUpdateDTO;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.evote.backend.users.enums.CityType;
import org.evote.backend.users.enums.Education;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.exceptions.UserNotFoundException;
import org.evote.backend.users.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    private final UserRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    private final AccountRepository accountRepository;

    public UsersService(UserRepository usersRepository, PasswordEncoder passwordEncoder, AccountRepository accountRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public String updateUser(Integer id, UserUpdateDTO userUpdateDTO) {
        Optional<Account> dbAccount = accountRepository.findById(id);
        if (dbAccount.isEmpty()) {
            throw new AccountNotFoundException("Account not found");
        }
        Account accountToUpdate = dbAccount.get();
        User userToUpdate = accountToUpdate.getUser();
        if (userToUpdate == null) {
            throw new UserNotFoundException("User not found");
        }
        try {
            this.updateUser2(userToUpdate, userUpdateDTO);
        } catch (Exception e) {
            throw new RuntimeException("Error while updating user");
        }
        try {
            accountRepository.save(accountToUpdate);
        } catch (Exception e) {
            throw new AccountNotFoundException("Account with id " + id + " not found");
        }
        return "Account updated successfully";
    }

    @Transactional
    public void updateUser2(User user, UserUpdateDTO userUpdateDTO) {
        Optional.ofNullable(userUpdateDTO.getName()).ifPresent(user::setName);
        Optional.ofNullable(userUpdateDTO.getSurname()).ifPresent(user::setSurname);
        Optional.ofNullable(userUpdateDTO.getPersonalIdNumber())
                .map(Object::toString)
                .map(passwordEncoder::encode)
                .ifPresent(user::setPersonalIdNumber);
        Optional.ofNullable(userUpdateDTO.getSex()).ifPresent(user::setSex);
        Optional.ofNullable(userUpdateDTO.getBirthDate()).ifPresent(user::setBirthDate);
        Optional.ofNullable(userUpdateDTO.getEducation())
                .map(String::toUpperCase)
                .map(Education::valueOf)
                .ifPresent(user::setEducation);
        Optional.ofNullable(userUpdateDTO.getCityType())
                .map(String::toUpperCase)
                .map(CityType::valueOf)
                .ifPresent(user::setCityType);
        Optional.ofNullable(userUpdateDTO.getProfession()).ifPresent(user::setProfession);
        try {
            usersRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error while updating user");
        }
    }
}
