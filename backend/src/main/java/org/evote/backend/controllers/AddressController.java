package org.evote.backend.controllers;

import org.evote.backend.dtos.user.AddressUpdateDTO;
import org.evote.backend.services.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('Admin') or @authenticationService.hasAccount(#id)")
    public ResponseEntity<?> updateAddress(@PathVariable Integer id, @RequestBody AddressUpdateDTO addressUpdateDTO) {
        try {
            return ResponseEntity.ok(addressService.updateAddress(id, addressUpdateDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
