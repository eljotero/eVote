
package org.evote.backend.unit.services;

import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.exceptions.UserAlreadyExistsException;
import org.evote.backend.users.user.exceptions.UserAuthenticationException;
import org.evote.backend.users.user.exceptions.UserNotFoundException;
import org.evote.backend.users.user.repository.UserRepository;
import org.evote.backend.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setEmail("test@test.com");
        user.setPassword("password");
    }

    @Test
    public void testAddUser() {
        when(userRepository.findByEmail(user.getEmail())).thenReturn(null);
        when(userRepository.save(user)).thenReturn(user);

        User createdUser = userService.addUser(user);

        assertNotNull(createdUser);
        assertEquals(user.getEmail(), createdUser.getEmail());
        verify(userRepository, times(1)).findByEmail(user.getEmail());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testAddUserAlreadyExists() {
        when(userRepository.findByEmail(user.getEmail())).thenReturn(user);

        UserAlreadyExistsException exception = assertThrows(UserAlreadyExistsException.class, () -> userService.addUser(user));
        assertEquals("User with email " + user.getEmail() + " already exists", exception.getMessage());
        verify(userRepository, times(1)).findByEmail(user.getEmail());
    }

    @Test
    public void testGetUserById() {
        when(userRepository.findById(user.getUser_id())).thenReturn(Optional.of(user));

        User foundUser = userService.getUserById(user.getUser_id());

        assertNotNull(foundUser);
        assertEquals(user.getUser_id(), foundUser.getUser_id());
        verify(userRepository, times(1)).findById(user.getUser_id());
    }

    @Test
    public void testGetUserByIdNotFound() {
        when(userRepository.findById(user.getUser_id())).thenReturn(Optional.empty());

        UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> userService.getUserById(user.getUser_id()));
        assertEquals("User with id " + user.getUser_id() + " not found", exception.getMessage());
        verify(userRepository, times(1)).findById(user.getUser_id());
    }

    @Test
    public void testDeleteUserById() {
        userService.deleteUserById(user.getUser_id());
        verify(userRepository, times(1)).deleteById(user.getUser_id());
    }

    @Test
    public void testAuthenticateUser() {
        when(userRepository.findByEmail(user.getEmail())).thenReturn(user);

        User authenticatedUser = userService.authenticateUser(user.getEmail(), user.getPassword());

        assertNotNull(authenticatedUser);
        assertEquals(user.getEmail(), authenticatedUser.getEmail());
        verify(userRepository, times(1)).findByEmail(user.getEmail());
    }

    @Test
    public void testAuthenticateUserNotFound() {
        when(userRepository.findByEmail(user.getEmail())).thenReturn(null);

        UserAuthenticationException exception = assertThrows(UserAuthenticationException.class, () -> userService.authenticateUser(user.getEmail(), user.getPassword()));
        assertEquals("User with email " + user.getEmail() + " not found", exception.getMessage());
        verify(userRepository, times(1)).findByEmail(user.getEmail());
    }

    @Test
    public void testAuthenticateUserInvalidPassword() {
        when(userRepository.findByEmail(user.getEmail())).thenReturn(user);

        UserAuthenticationException exception = assertThrows(UserAuthenticationException.class, () -> userService.authenticateUser(user.getEmail(), "invalid_password"));
        assertEquals("Invalid password", exception.getMessage());
        verify(userRepository, times(1)).findByEmail(user.getEmail());
    }

    @Test
    public void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(List.of(user));
        List<User> expectedUsers = List.of(user);
        List<User> actualUsers = userService.getAllUsers();

        assertNotNull(actualUsers);
        assertEquals(expectedUsers.size(), actualUsers.size());
        assertTrue(actualUsers.containsAll(expectedUsers));
        verify(userRepository, times(1)).findAll();
    }

}


