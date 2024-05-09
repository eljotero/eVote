package org.evote.backend.unit.controllers;

import org.evote.backend.controllers.AddressController;
import org.evote.backend.dtos.user.AddressUpdateDTO;
import org.evote.backend.services.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AddressControllerTests {
    @Mock
    private AddressService addressService;

    @InjectMocks
    private AddressController addressController;

    AddressUpdateDTO addressUpdateDTO;

    private int id;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        addressController = new AddressController(addressService);

        id = 1;

        addressUpdateDTO = new AddressUpdateDTO();
        addressUpdateDTO.setZip_code("12345");
        addressUpdateDTO.setCity("City");
        addressUpdateDTO.setCountry("Country");
        addressUpdateDTO.setAddress_line("Address line");
    }

    @Test
    public void testUpdateAddress() {
        when(addressService.updateAddress(id, addressUpdateDTO)).thenReturn("Address updated successfully");
        assertEquals("Address updated successfully", addressController.updateAddress(id, addressUpdateDTO).getBody());
    }

    @Test
    public void testUpdateAddressBadRequest() {
        when(addressService.updateAddress(id, addressUpdateDTO)).thenThrow(new RuntimeException("Bad request"));
        assertEquals("Bad request", addressController.updateAddress(id, addressUpdateDTO).getBody());
    }
}
