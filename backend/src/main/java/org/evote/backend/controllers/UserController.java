package org.evote.backend.controllers;

import org.evote.backend.dtos.user.UserUpdateDTO;
import org.evote.backend.services.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('Admin') or @authenticationService.hasAccount(#id)")
    public ResponseEntity<?> updateAccount(@PathVariable Integer id, @RequestBody UserUpdateDTO userUpdateDTO) {
        try {
            return ResponseEntity.ok(usersService.updateUser(id, userUpdateDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
