package org.evote.backend.unit.dtos.account;

import org.evote.backend.users.account.dtos.AccountDTO;
import org.evote.backend.users.account.dtos.AccountUserDTO;
import org.evote.backend.users.enums.Role;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AccountDTOTests {

    @Test
    public void testAccountDTONoArgs() {
        AccountDTO accountDTO = new AccountDTO();
        assertNotNull(accountDTO);
    }

    @Test
    public void testAccountDTOAllArgs() {
        String email = "test@test.com";
        Role role = Role.USER;
        Boolean hasVoted = false;
        Boolean isAccountActive = false;
        AccountDTO accountDTO = new AccountDTO(1, email, role, hasVoted, isAccountActive);

        assertEquals(1, accountDTO.getId());
        assertEquals(email, accountDTO.getEmail());
        assertEquals(role, accountDTO.getRole());
        assertEquals(hasVoted, accountDTO.getHasVoted());
        assertEquals(isAccountActive, accountDTO.getIsAccountActive());
    }

    @Test
    public void testAccountDTOGettersAndSetter() {
        AccountDTO accountDTO = new AccountDTO();
        String email = "test@test.com";
        Role role = Role.USER;
        Boolean hasVoted = false;
        Boolean isAccountActive = false;

        accountDTO.setId(1);
        accountDTO.setEmail(email);
        accountDTO.setRole(role);
        accountDTO.setHasVoted(hasVoted);
        accountDTO.setIsAccountActive(isAccountActive);

        assertEquals(1, accountDTO.getId());
        assertEquals(email, accountDTO.getEmail());
        assertEquals(role, accountDTO.getRole());
        assertEquals(hasVoted, accountDTO.getHasVoted());
        assertEquals(isAccountActive, accountDTO.getIsAccountActive());

    }

    @Test
    public void testAccountUserDTOGettersAndSetters() {
        String email = "test@test.com";
        String name = "John";
        String surname = "Doe";
        Boolean sex = true;
        Date birthDate = new Date();
        String education = "M.Sc. Computer Science";
        String profession = "Software Engineer";
        String cityType = "Urban";
        String personalIdNumber = "1234567890";
        String zipCode = "00-001";
        String city = "Warsaw";
        String country = "Poland";
        String addressLine = "Sample Street 123";
        String voivodeship = "Mazowieckie";

        AccountUserDTO user = new AccountUserDTO();
        user.setEmail(email);
        user.setName(name);
        user.setSurname(surname);
        user.setSex(sex);
        user.setBirthDate(birthDate);
        user.setEducation(education);
        user.setProfession(profession);
        user.setCityType(cityType);
        user.setPersonalIdNumber(personalIdNumber);
        user.setZipCode(zipCode);
        user.setCity(city);
        user.setCountry(country);
        user.setAddressLine(addressLine);
        user.setVoivodeship(voivodeship);

        assertEquals(email, user.getEmail());
        assertEquals(name, user.getName());
        assertEquals(surname, user.getSurname());
        assertEquals(sex, user.getSex());
        assertEquals(birthDate, user.getBirthDate());
        assertEquals(education, user.getEducation());
        assertEquals(profession, user.getProfession());
        assertEquals(cityType, user.getCityType());
        assertEquals(personalIdNumber, user.getPersonalIdNumber());
        assertEquals(zipCode, user.getZipCode());
        assertEquals(city, user.getCity());
        assertEquals(country, user.getCountry());
        assertEquals(addressLine, user.getAddressLine());
        assertEquals(voivodeship, user.getVoivodeship());
    }

    @Test
    public void testAccountUserDTONoArgsConstructor() {
        AccountUserDTO user = new AccountUserDTO();

        assertNull(user.getEmail());
        assertNull(user.getName());
        assertNull(user.getSurname());
        assertNull(user.getSex());
        assertNull(user.getBirthDate());
        assertNull(user.getEducation());
        assertNull(user.getProfession());
        assertNull(user.getCityType());
        assertNull(user.getPersonalIdNumber());
        assertNull(user.getZipCode());
        assertNull(user.getCity());
        assertNull(user.getCountry());
        assertNull(user.getAddressLine());
        assertNull(user.getVoivodeship());
    }


}
