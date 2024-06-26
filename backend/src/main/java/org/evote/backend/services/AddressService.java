package org.evote.backend.services;

import org.evote.backend.users.account.dtos.AddressUpdateDTO;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.evote.backend.users.address.entity.Address;
import org.evote.backend.users.address.exceptions.AddressNotFoundException;
import org.evote.backend.users.address.repository.UserAddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AddressService {

    private final UserAddressRepository userAddressRepository;

    private final AccountRepository accountRepository;


    public AddressService(UserAddressRepository userAddressRepository, AccountRepository accountRepository) {
        this.userAddressRepository = userAddressRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public String updateAddress(Integer id, AddressUpdateDTO addressUpdateDTO) {
        Account dbAccount = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account with id " + id + " not found"));
        Address userAddress = dbAccount.getUser().getAddress();
        if (userAddress == null) {
            throw new AddressNotFoundException("Address not found");
        }
        Optional.ofNullable(addressUpdateDTO.getZip_code()).ifPresent(userAddress::setZip_code);
        Optional.ofNullable(addressUpdateDTO.getCity()).ifPresent(userAddress::setCity);
        Optional.ofNullable(addressUpdateDTO.getCountry()).ifPresent(userAddress::setCountry);
        Optional.ofNullable(addressUpdateDTO.getAddress_line()).ifPresent(userAddress::setAddress_line);
        Optional.ofNullable(addressUpdateDTO.getVoivodeship()).ifPresent(userAddress::setVoivodeship);
        userAddressRepository.save(userAddress);
        return "Address updated successfully";
    }

    public Boolean isAddressDataComplete(Integer id) {
        Address userAddress = userAddressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("Address with id " + id + " not found"));
        return userAddress.getZip_code() != null && userAddress.getVoivodeship() != null && userAddress.getCity() != null && userAddress.getCountry() != null && userAddress.getAddress_line() != null;
    }
}
