package org.evote.backend.unit.services;

import org.evote.backend.services.AddressService;
import org.evote.backend.services.PrecinctService;
import org.evote.backend.services.UserService;
import org.evote.backend.users.account.dtos.AddressUpdateDTO;
import org.evote.backend.users.account.dtos.UserUpdateDTO;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.account.repository.AccountRepository;
import org.evote.backend.users.address.entity.Address;
import org.evote.backend.users.enums.CityType;
import org.evote.backend.users.enums.Education;
import org.evote.backend.users.enums.ElectionType;
import org.evote.backend.users.precinct.entity.Precinct;
import org.evote.backend.users.precinct.repository.UsersPrecinctRepository;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.exceptions.UserNotFoundException;
import org.evote.backend.users.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceTests {
    @Mock
    private UserRepository usersRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private AddressService addressService;
    @Mock
    private PrecinctService precinctService;
    @Mock
    private UsersPrecinctRepository usersPrecinctRepository;

    @InjectMocks
    private UserService userService;

    private int id;

    private User user;

    private User user2;

    private UserUpdateDTO userUpdateDTO;

    private Account account;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(usersRepository, passwordEncoder, accountRepository, addressService, precinctService, usersPrecinctRepository);
        id = 1;

        userUpdateDTO = new UserUpdateDTO();
        userUpdateDTO.setName("John");
        userUpdateDTO.setSurname("Doe");
        userUpdateDTO.setPersonalIdNumber(123456789);
        userUpdateDTO.setSex(false);
        userUpdateDTO.setBirthDate(new Date());
        userUpdateDTO.setEducation("PRIMARY");
        userUpdateDTO.setCityType("Over500Thousand");
        userUpdateDTO.setProfession("Developer");
        userUpdateDTO.setVoivodeship("Voivodeship");
        userUpdateDTO.setCity("City");

        account = new Account();
        account.setAccount_id(id);

        user = new User();
        user.setUser_id(UUID.randomUUID());
        user.setName("John");
        user.setSurname("Doe");
        user.setSex(false);
        user.setPersonalIdNumber("123456789");
        user.setBirthDate(new Date());
        user.setEducation(Education.PRIMARY);
        user.setCityType(CityType.BELOWFIFTYTHOUSAND);
        user.setProfession("Developer");
        user.setAccount(account);
        user.setAddress(new Address());

        account.setUser(user);

        user2 = new User();
        user2.setUser_id(UUID.randomUUID());
    }

    @Test
    public void testUpdateUser() {
        Precinct precinct = new Precinct();
        List<Precinct> precincts = new ArrayList<>();
        List<User> users = new ArrayList<>();
        users.add(user);
        precinct.setUsers(users);
        precincts.add(precinct);
        user.setPrecincts(precincts);
        when(precinctService.findPrecinctCity(any(String.class), any(ElectionType.class)))
                .thenReturn(Optional.of(precinct));
        when(precinctService.findPrecinctEuro(any(String.class), any(ElectionType.class)))
                .thenReturn(Optional.of(precinct));
        when(accountRepository.findById(id)).thenReturn(java.util.Optional.of(account));
        when(passwordEncoder.encode(String.valueOf(userUpdateDTO.getPersonalIdNumber()))).thenReturn("encodedPersonalIdNumber");
        when(usersRepository.save(user)).thenReturn(user);
        when(accountRepository.save(account)).thenReturn(account);
        when(addressService.updateAddress(any(Integer.class), any(AddressUpdateDTO.class))).thenReturn("Address updated successfully");
        String result = userService.updateUser(id, userUpdateDTO);
        assertEquals("User updated successfully", result);
    }

    @Test
    public void testUpdateUserAccountNotFound() {
        when(accountRepository.findById(id)).thenReturn(java.util.Optional.empty());
        AccountNotFoundException exception = org.junit.jupiter.api.Assertions.assertThrows(AccountNotFoundException.class, () -> userService.updateUser(id, userUpdateDTO));
        assertEquals("Account not found", exception.getMessage());
    }

    @Test
    public void testUpdateUserUserNotFound() {
        account.setUser(null);
        when(accountRepository.findById(id)).thenReturn(java.util.Optional.of(account));
        UserNotFoundException exception = org.junit.jupiter.api.Assertions.assertThrows(UserNotFoundException.class, () -> userService.updateUser(id, userUpdateDTO));
        assertEquals("User not found", exception.getMessage());
    }

    @Test
    public void testIsUserDataValid() {
        when(usersRepository.findById(user.getUser_id())).thenReturn(java.util.Optional.of(user));
        Boolean result = userService.isUserDataComplete(user.getUser_id());
        assertEquals(true, result);
    }

    @Test
    public void testIfUserDataValidUserNotFound() {
        when(usersRepository.findById(user2.getUser_id())).thenReturn(java.util.Optional.empty());
        UserNotFoundException exception = org.junit.jupiter.api.Assertions.assertThrows(UserNotFoundException.class, () -> userService.isUserDataComplete(user2.getUser_id()));
        assertEquals("User not found", exception.getMessage());
    }

    @Test
    public void testIsUserDataInvalid() {
        when(usersRepository.findById(user2.getUser_id())).thenReturn(java.util.Optional.of(user2));
        Boolean result = userService.isUserDataComplete(user2.getUser_id());
        assertEquals(false, result);
    }

}
