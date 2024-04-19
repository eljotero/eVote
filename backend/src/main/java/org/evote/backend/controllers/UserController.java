package org.evote.backend.controllers;

import org.evote.backend.dtos.user.UserDTO;
import org.evote.backend.dtos.user.UserMapper;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.services.UserService;
import org.evote.backend.users.user.exceptions.UserNotFoundException;
import org.evote.backend.users.user.exceptions.UserNotCreatedException;
import org.evote.backend.users.user.exceptions.UserNotDeletedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users.stream().map(UserMapper::toUserDTO).collect(Collectors.toList());
    }

    @PostMapping("/add")
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        User user = userService.addUser(UserMapper.toUser(userDTO));
        return UserMapper.toUserDTO(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable UUID id) {
        userService.deleteUserById(id);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable UUID id) {
        User user = userService.getUserById(id);
        return UserMapper.toUserDTO(user);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(UserNotCreatedException.class)
    public ResponseEntity<String> handleUserNotCreatedException(UserNotCreatedException ex) {
        if ("CREATE_ERROR".equals(ex.getErrorCode())) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        } else if ("DUPLICATE".equals(ex.getErrorCode())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @ExceptionHandler(UserNotDeletedException.class)
    public ResponseEntity<String> handleUserNotDeletedException(UserNotDeletedException ex) {
        if ("DELETE_ERROR".equals(ex.getErrorCode())) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        } else if ("NOT_FOUND".equals(ex.getErrorCode())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}



