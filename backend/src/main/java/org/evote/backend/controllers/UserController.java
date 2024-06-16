package org.evote.backend.controllers;

import org.evote.backend.services.UserService;
import org.evote.backend.users.account.dtos.UserUpdateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('Admin') or @authenticationService.hasAccount(#id)")
    public ResponseEntity<?> updateAccount(@PathVariable Integer id, @RequestBody UserUpdateDTO userUpdateDTO) {
        String response = userService.updateUser(id, userUpdateDTO);
        return ResponseEntity.ok(response);
    }
}