package org.evote.backend.controllers;

import org.evote.backend.dtos.user.*;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDTO> userDTOs = users.stream().map(UserMapper::toUserDTO).collect(Collectors.toList());
        return ResponseEntity.ok(userDTOs);
    }

    @PostMapping("/add")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserCreateDTO userCreateDTO) {
        User user = userService.addUser(UserMapper.toUser(userCreateDTO));
        return new ResponseEntity<>(UserMapper.toUserDTO(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable UUID id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(UserMapper.toUserDTO(user));
    }

    // Return only JWT token
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDTO> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        User user = userService.authenticateUser(userLoginDTO.getEmail(), userLoginDTO.getPassword());
        return ResponseEntity.ok(UserMapper.toUserLoginResponseDTO(user));
    }

}



