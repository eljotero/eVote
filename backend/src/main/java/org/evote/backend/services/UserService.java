package org.evote.backend.services;

import org.evote.backend.users.account.dtos.UserUpdateDTO;
import org.evote.backend.users.account.dtos.AddressUpdateDTO;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.evote.backend.users.enums.CityType;
import org.evote.backend.users.enums.Education;
import org.evote.backend.users.enums.ElectionType;
import org.evote.backend.users.precinct.entity.Precinct;
import org.evote.backend.users.precinct.repository.UsersPrecinctRepository;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.exceptions.UserAlreadyAssignedException;
import org.evote.backend.users.user.exceptions.UserNotFoundException;
import org.evote.backend.users.user.repository.UserRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    private final AccountRepository accountRepository;

    private final AddressService addressService;

    private final PrecinctService precinctService;

    private final UsersPrecinctRepository usersPrecinctRepository;


    public UserService(UserRepository usersRepository, PasswordEncoder passwordEncoder, AccountRepository accountRepository, AddressService addressService, PrecinctService precinctService, UsersPrecinctRepository usersPrecinctRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.accountRepository = accountRepository;
        this.addressService = addressService;
        this.precinctService = precinctService;
        this.usersPrecinctRepository = usersPrecinctRepository;
    }
    @Async
    @Transactional
    public String updateUser(Integer id, UserUpdateDTO userUpdateDTO) {
        Account accountToUpdate;
        if (accountRepository.findById(id).isEmpty()) {
            throw new AccountNotFoundException("Account not found");
        } else {
            accountToUpdate = accountRepository.findById(id).get();
        }

        User userToUpdate = accountToUpdate.getUser();
        if (userToUpdate == null) {
            throw new UserNotFoundException("User not found");
        }
        Optional.ofNullable(userUpdateDTO.getName()).ifPresent(userToUpdate::setName);
        Optional.ofNullable(userUpdateDTO.getSurname()).ifPresent(userToUpdate::setSurname);
        Optional.ofNullable(userUpdateDTO.getPersonalIdNumber())
                .map(Object::toString)
                .map(passwordEncoder::encode)
                .ifPresent(userToUpdate::setPersonalIdNumber);
        Optional.ofNullable(userUpdateDTO.getSex()).ifPresent(userToUpdate::setSex);
        Optional.ofNullable(userUpdateDTO.getBirthDate()).ifPresent(userToUpdate::setBirthDate);
        Optional.ofNullable(userUpdateDTO.getEducation())
                .map(String::toUpperCase)
                .map(Education::valueOf)
                .ifPresent(userToUpdate::setEducation);
        Optional.ofNullable(userUpdateDTO.getCityType())
                .map(String::toUpperCase)
                .map(CityType::valueOf)
                .ifPresent(userToUpdate::setCityType);
        Optional.ofNullable(userUpdateDTO.getProfession()).ifPresent(userToUpdate::setProfession);
        List<Precinct> precinctList = userToUpdate.getPrecincts();
        for (ElectionType electionType : ElectionType.values()) {
            if (electionType == ElectionType.Presidential || electionType == ElectionType.LocalGovernment || electionType == ElectionType.EuropeanParliament) {
                continue;
            }
            Optional<Precinct> precinct = Optional.empty();
            if (electionType == ElectionType.Senate || electionType == ElectionType.Parliamentary) {
                precinct = precinctService.findPrecinctCity(userUpdateDTO.getCity(), electionType);
            }

            if (precinct.isPresent()) {
                Precinct existingPrecinct = precinct.get();
                if (usersPrecinctRepository.findByUserIdAndPrecinctId(userToUpdate.getUser_id(), existingPrecinct.getPrecinct_id()).isEmpty()) {
                    precinctList.add(existingPrecinct);
                    existingPrecinct.getUsers().add(userToUpdate);
                    usersPrecinctRepository.save(existingPrecinct);
                } else {
                    throw new UserAlreadyAssignedException("User already assigned to this precinct");
                }
            }
        }
        Account account = userToUpdate.getAccount();
        AddressUpdateDTO addressUpdateDTO = new AddressUpdateDTO();
        addressUpdateDTO.setUser_id(userToUpdate.getUser_id());
        addressUpdateDTO.setVoivodeship(userUpdateDTO.getVoivodeship());
        addressUpdateDTO.setZip_code(userUpdateDTO.getZip_code());
        addressUpdateDTO.setCity(userUpdateDTO.getCity());
        addressUpdateDTO.setCountry(userUpdateDTO.getCountry());
        addressUpdateDTO.setAddress_line(userUpdateDTO.getAddress_line());
        addressService.updateAddress(account.getAccount_id(), addressUpdateDTO);
        usersRepository.save(userToUpdate);
        accountRepository.save(accountToUpdate);
        return "User updated successfully";
    }

    public Boolean isUserDataComplete(UUID id) {
        User user = usersRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        return user.getName() != null && user.getSurname() != null && user.getPersonalIdNumber() != null && user.getSex() != null && user.getBirthDate() != null && user.getEducation() != null && user.getCityType() != null && user.getProfession() != null && user.getAddress() != null;
    }
}
