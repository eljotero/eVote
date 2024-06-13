package org.evote.backend.unit.services;

import org.evote.backend.users.account.dtos.AddressUpdateDTO;
import org.evote.backend.services.AddressService;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.evote.backend.users.address.entity.Address;
import org.evote.backend.users.address.exceptions.AddressNotFoundException;
import org.evote.backend.users.address.repository.UserAddressRepository;
import org.evote.backend.users.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AddressServiceTests {
    @Mock
    private UserAddressRepository userAddressRepository;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AddressService addressService;

    private int id;

    AddressUpdateDTO addressUpdateDTO;

    Account account;

    Address address;

    User user;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        addressService = new AddressService(userAddressRepository, accountRepository);
        id = 1;

        addressUpdateDTO = new AddressUpdateDTO();
        addressUpdateDTO.setZip_code("12345");
        addressUpdateDTO.setCity("City");
        addressUpdateDTO.setCountry("Country");
        addressUpdateDTO.setAddress_line("Address line");

        account = new Account();
        user = new User();
        address = new Address();
        account.setUser(user);
        user.setAddress(address);
    }

    @Test
    public void testUpdateAddress() {
        when(accountRepository.findById(id)).thenReturn(java.util.Optional.of(account));
        when(userAddressRepository.save(address)).thenReturn(address);
        String result = addressService.updateAddress(id, addressUpdateDTO);
        assertEquals("Address updated successfully", result);
    }

    @Test
    public void testUpdateAddressAccountNotFound() {
        when(accountRepository.findById(id)).thenReturn(java.util.Optional.empty());
        AccountNotFoundException exception = org.junit.jupiter.api.Assertions.assertThrows(AccountNotFoundException.class, () -> addressService.updateAddress(id, addressUpdateDTO));
        assertEquals("Account with id " + id + " not found", exception.getMessage());
    }

    @Test
    public void testUpdateAddressAddressNotFound() {
        when(accountRepository.findById(id)).thenReturn(java.util.Optional.of(account));
        user.setAddress(null);
        AddressNotFoundException exception = org.junit.jupiter.api.Assertions.assertThrows(AddressNotFoundException.class, () -> addressService.updateAddress(id, addressUpdateDTO));
        assertEquals("Address not found", exception.getMessage());
    }

    @Test
    public void testIsAddressDataComplete() {
        when(userAddressRepository.findById(id)).thenReturn(java.util.Optional.of(address));
        address.setZip_code("12345");
        address.setCity("City");
        address.setCountry("Country");
        address.setAddress_line("Address line");
        address.setVoivodeship("Voivodeship");
        boolean result = addressService.isAddressDataComplete(id);
        assertEquals(true, result);
    }

    @Test
    public void testIsAddressDataIncomplete() {
        when(userAddressRepository.findById(id)).thenReturn(java.util.Optional.of(address));
        address.setZip_code("12345");
        address.setCity("City");
        address.setCountry("Country");
        address.setAddress_line("Address line");
        address.setVoivodeship(null);
        boolean result = addressService.isAddressDataComplete(id);
        assertEquals(false, result);
    }

}
