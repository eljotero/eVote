package org.evote.backend.services;

import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.exceptions.UserNotDeletedException;
import org.evote.backend.users.user.exceptions.UserNotFoundException;
import org.evote.backend.users.user.exceptions.UserNotCreatedException;
import org.evote.backend.users.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(UUID uuid) {
        Optional<User> user = userRepository.findById(uuid);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("User with id " + uuid + " not found", HttpStatus.NOT_FOUND);
        }
    }

    public User addUser(User user) {
        if (userRepository.existsByPersonalIdNumber(user.getPersonalIdNumber())) {
            throw new UserNotCreatedException("This user already exists", HttpStatus.CONFLICT);
        }
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new UserNotCreatedException("User could not be created", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void deleteUserById(UUID uuid) {
        if (userRepository.existsById(uuid)) {
            try {
                userRepository.deleteById(uuid);
            } catch (Exception e) {
                throw new UserNotDeletedException("User with id " + uuid + " could not be deleted", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            throw new UserNotDeletedException("User with id " + uuid + " does not exist", HttpStatus.NOT_FOUND);
        }
    }

    public User authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User with email " + email + " not found", HttpStatus.NOT_FOUND);
        }
        if (!user.getPassword().equals(password)) {
            throw new UserNotFoundException("Wrong password", HttpStatus.UNAUTHORIZED);
        }
        return user;
    }

}
