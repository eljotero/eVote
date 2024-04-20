package org.evote.backend.services;

import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.exceptions.UserAuthenticationException;
import org.evote.backend.users.user.exceptions.UserNotFoundException;
import org.evote.backend.users.user.exceptions.UserAlreadyExistsException;
import org.evote.backend.users.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return userRepository.findById(uuid)
                .orElseThrow(() -> new UserNotFoundException("User with id " + uuid + " not found"));
    }

    public User addUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistsException("User with email " + user.getEmail() + " already exists");
        }
        return userRepository.save(user);
    }

    public void deleteUserById(UUID uuid) {
        userRepository.deleteById(uuid);
    }

    public User authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserAuthenticationException("User with email " + email + " not found");
        }
        if (!user.getPassword().equals(password)) {
            throw new UserAuthenticationException("Invalid password");
        }
        return user;
    }
}
