package org.evote.backend.unit.controllers;

import org.evote.backend.controllers.UserController;
import org.evote.backend.dtos.user.UserUpdateDTO;
import org.evote.backend.services.UserService;
import org.evote.backend.users.account.entity.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserControllerTests {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private UserUpdateDTO userUpdateDTO;

    private int id;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userController = new UserController(userService);

        id = 1;

        userUpdateDTO = new UserUpdateDTO();
        userUpdateDTO = new UserUpdateDTO();
        userUpdateDTO.setName("John");
        userUpdateDTO.setSurname("Doe");
        userUpdateDTO.setPersonalIdNumber(123456789);
        userUpdateDTO.setSex(false);
        userUpdateDTO.setBirthDate(new Date());
        userUpdateDTO.setEducation("PRIMARY");
        userUpdateDTO.setCityType("Over500Thousand");
        userUpdateDTO.setProfession("Developer");
    }

    @Test
    public void testUpdateUser() {
        Account account = new Account();
        when(userService.updateUser(id, userUpdateDTO)).thenReturn("Account updated successfully");
        assertEquals("Account updated successfully", userController.updateAccount(id, userUpdateDTO).getBody());
    }

    @Test
    public void testUpdateUserBadRequest() {
        when(userService.updateUser(id, userUpdateDTO)).thenThrow(new RuntimeException("Bad request"));
        assertEquals("Bad request", userController.updateAccount(id, userUpdateDTO).getBody());
    }
}
