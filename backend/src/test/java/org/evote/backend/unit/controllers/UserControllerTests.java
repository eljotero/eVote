package org.evote.backend.unit.controllers;


import org.evote.backend.controllers.UserController;
import org.evote.backend.dtos.user.UserCreateDTO;
import org.evote.backend.dtos.user.UserDTO;
import org.evote.backend.dtos.user.UserLoginDTO;
import org.evote.backend.dtos.user.UserLoginResponseDTO;
import org.evote.backend.services.UserService;
import org.evote.backend.users.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;
    private User user;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setEmail("test@test.com");
        user.setPassword("password");
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = Arrays.asList(user);
        when(userService.getAllUsers()).thenReturn(users);

        ResponseEntity<List<UserDTO>> responseEntity = userController.getAllUsers();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(users.size(), responseEntity.getBody().size());
    }

    @Test
    public void testAddUser() {
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setEmail("test@test.com");
        userCreateDTO.setPassword("password");

        when(userService.addUser(user)).thenReturn(user);

        ResponseEntity<UserDTO> responseEntity = userController.addUser(userCreateDTO);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(user.getEmail(), responseEntity.getBody().getEmail());
    }

    @Test
    public void testDeleteUserById() {
        UUID userId = UUID.randomUUID();

        userController.deleteUserById(userId);

        ResponseEntity<Void> responseEntity = userController.deleteUserById(userId);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

    @Test
    public void testGetUserById() {
        UUID userId = UUID.randomUUID();

        when(userService.getUserById(userId)).thenReturn(user);

        ResponseEntity<UserDTO> responseEntity = userController.getUserById(userId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user.getEmail(), responseEntity.getBody().getEmail());
    }

    @Test
    public void testLoginUser() {
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setEmail("test@test.com");
        userLoginDTO.setPassword("password");

        when(userService.authenticateUser(userLoginDTO.getEmail(), userLoginDTO.getPassword())).thenReturn(user);

        ResponseEntity<UserLoginResponseDTO> responseEntity = userController.loginUser(userLoginDTO);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user.getEmail(), responseEntity.getBody().getEmail());
    }



}