package org.evote.backend.unit.dtos.user;

import org.evote.backend.dtos.user.UserCreateDTO;
import org.evote.backend.users.enums.CityType;
import org.evote.backend.users.precinct.entity.Precinct;
import org.evote.backend.users.address.entity.Address;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserCreateDTOTests {

    @Test
    public void testUserCreateDTO() {
        UserCreateDTO UserCreateDTO = new UserCreateDTO();
        assertNotNull(UserCreateDTO);
    }

    @Test
    public void testUserCreateDTOGettersAndSetter() {
        UserCreateDTO UserCreateDTO = new UserCreateDTO();
        String name = "John";
        String surname = "Doe";
        String email = "test@test.com";
        String password = "password";
        Number personalIdNumber = 123456789;
        String code = "123456";
        Boolean hasVoted = false;
        Date birthDate = new Date("01/01/2000");
        String education = "High School";
        String profession = "Engineer";
        Boolean sex = true;
        Precinct precinct = new Precinct();
        precinct.setPrecinct_id(1);
        List<Precinct> precincts = List.of(precinct);
        Address address = new Address();
        address.setAddress_id(1);
        CityType cityType = CityType.Over500Thousand;

        UserCreateDTO.setName(name);
        UserCreateDTO.setSurname(surname);
        UserCreateDTO.setEmail(email);
        UserCreateDTO.setPassword(password);
        UserCreateDTO.setPersonalIdNumber(personalIdNumber);
        UserCreateDTO.setCode(code);
        UserCreateDTO.setHasVoted(hasVoted);
        UserCreateDTO.setBirthDate(birthDate);
        UserCreateDTO.setEducation(education);
        UserCreateDTO.setProfession(profession);
        UserCreateDTO.setSex(sex);
        UserCreateDTO.setPrecincts(precincts);
        UserCreateDTO.setAddress(address);
        UserCreateDTO.setCityType(cityType);

        assertEquals(name, UserCreateDTO.getName());
        assertEquals(surname, UserCreateDTO.getSurname());
        assertEquals(email, UserCreateDTO.getEmail());
        assertEquals(password, UserCreateDTO.getPassword());
        assertEquals(personalIdNumber, UserCreateDTO.getPersonalIdNumber());
        assertEquals(code, UserCreateDTO.getCode());
        assertEquals(hasVoted, UserCreateDTO.getHasVoted());
        assertEquals(birthDate, UserCreateDTO.getBirthDate());
        assertEquals(education, UserCreateDTO.getEducation());
        assertEquals(profession, UserCreateDTO.getProfession());
        assertEquals(sex, UserCreateDTO.getSex());
        assertEquals(precincts, UserCreateDTO.getPrecincts());
        assertEquals(address, UserCreateDTO.getAddress());
        assertEquals(cityType, UserCreateDTO.getCityType());
    }


    @Test
    public void testUserCreateDTOEqualsWithName() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        String name = "John";
        UserCreateDTO1.setName(name);
        UserCreateDTO2.setName(name);

        assertEquals(UserCreateDTO1, UserCreateDTO2);
        UserCreateDTO2.setName("Jane");
        assertNotEquals(UserCreateDTO1, UserCreateDTO2);
    }

    @Test
    public void testUserCreateDTOEqualsWithSurname() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        String surname = "Doe";
        UserCreateDTO1.setSurname(surname);
        UserCreateDTO2.setSurname(surname);

        assertEquals(UserCreateDTO1, UserCreateDTO2);
        UserCreateDTO2.setSurname("Smith");
        assertNotEquals(UserCreateDTO1, UserCreateDTO2);
    }

    @Test
    public void testUserCreateDTOEqualsWithEmail() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        String email = "test@test.com";
        UserCreateDTO1.setEmail(email);
        UserCreateDTO2.setEmail(email);

        assertEquals(UserCreateDTO1, UserCreateDTO2);
        UserCreateDTO2.setEmail("differenttest@test.com");
        assertNotEquals(UserCreateDTO1, UserCreateDTO2);
    }

    @Test
    public void testUserCreateDTOEqualsWithPassword() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        String password = "password";
        UserCreateDTO1.setPassword(password);
        UserCreateDTO2.setPassword(password);

        assertEquals(UserCreateDTO1, UserCreateDTO2);
        UserCreateDTO2.setPassword("differentpassword");
        assertNotEquals(UserCreateDTO1, UserCreateDTO2);
    }

    @Test
    public void testUserCreateDTOEqualsWithPersonalIdNumber() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        Number personalIdNumber = 123456789;
        UserCreateDTO1.setPersonalIdNumber(personalIdNumber);
        UserCreateDTO2.setPersonalIdNumber(personalIdNumber);

        assertEquals(UserCreateDTO1, UserCreateDTO2);
        UserCreateDTO2.setPersonalIdNumber(987654321);
        assertNotEquals(UserCreateDTO1, UserCreateDTO2);
    }

    @Test
    public void testUserCreateDTOEqualsWithCode() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        String code = "123456";
        UserCreateDTO1.setCode(code);
        UserCreateDTO2.setCode(code);

        assertEquals(UserCreateDTO1, UserCreateDTO2);
        UserCreateDTO2.setCode("654321");
        assertNotEquals(UserCreateDTO1, UserCreateDTO2);
    }

    @Test
    public void testUserCreateDTOEqualsWithHasVoted() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        Boolean hasVoted = false;
        UserCreateDTO1.setHasVoted(hasVoted);
        UserCreateDTO2.setHasVoted(hasVoted);

        assertEquals(UserCreateDTO1, UserCreateDTO2);
        UserCreateDTO2.setHasVoted(true);
        assertNotEquals(UserCreateDTO1, UserCreateDTO2);
    }

    @Test
    public void testUserCreateDTOEqualsWithBirthDate() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        Date birthDate = new Date("01/01/2000");
        UserCreateDTO1.setBirthDate(birthDate);
        UserCreateDTO2.setBirthDate(birthDate);

        assertEquals(UserCreateDTO1, UserCreateDTO2);
        UserCreateDTO2.setBirthDate(new Date("01/01/2001"));
        assertNotEquals(UserCreateDTO1, UserCreateDTO2);
    }

    @Test
    public void testUserCreateDTOEqualsWithEducation() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        String education = "High School";
        UserCreateDTO1.setEducation(education);
        UserCreateDTO2.setEducation(education);

        assertEquals(UserCreateDTO1, UserCreateDTO2);
        UserCreateDTO2.setEducation("University");
        assertNotEquals(UserCreateDTO1, UserCreateDTO2);
    }

    @Test
    public void testUserCreateDTOEqualsWithProfession() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        String profession = "Engineer";
        UserCreateDTO1.setProfession(profession);
        UserCreateDTO2.setProfession(profession);

        assertEquals(UserCreateDTO1, UserCreateDTO2);
        UserCreateDTO2.setProfession("Doctor");
        assertNotEquals(UserCreateDTO1, UserCreateDTO2);
    }

    @Test
    public void testUserCreateDTOEqualsWithSex() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        Boolean sex = true;
        UserCreateDTO1.setSex(sex);
        UserCreateDTO2.setSex(sex);

        assertEquals(UserCreateDTO1, UserCreateDTO2);
        UserCreateDTO2.setSex(false);
        assertNotEquals(UserCreateDTO1, UserCreateDTO2);
    }

    @Test
    public void testUserCreateDTOEqualsWithPrecincts() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        Precinct precinct = new Precinct();
        precinct.setPrecinct_id(1);
        List<Precinct> precincts = List.of(precinct);
        UserCreateDTO1.setPrecincts(precincts);
        UserCreateDTO2.setPrecincts(precincts);

        assertEquals(UserCreateDTO1, UserCreateDTO2);
        Precinct precinct2 = new Precinct();
        precinct2.setPrecinct_id(2);
        UserCreateDTO2.setPrecincts(List.of(precinct2));
        assertNotEquals(UserCreateDTO1, UserCreateDTO2);
    }

    @Test
    public void testUserCreateDTOEqualsWithAddress() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        Address address = new Address();
        address.setAddress_id(1);
        UserCreateDTO1.setAddress(address);
        UserCreateDTO2.setAddress(address);

        assertEquals(UserCreateDTO1, UserCreateDTO2);
        Address address2 = new Address();
        address2.setAddress_id(2);
        UserCreateDTO2.setAddress(address2);
        assertNotEquals(UserCreateDTO1, UserCreateDTO2);
    }

    @Test
    public void testUserCreateDTOEqualsWithCityType() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        CityType cityType = CityType.Over500Thousand;
        UserCreateDTO1.setCityType(cityType);
        UserCreateDTO2.setCityType(cityType);

        assertEquals(UserCreateDTO1, UserCreateDTO2);
        UserCreateDTO2.setCityType(CityType.BelowFiftyThousand);
        assertNotEquals(UserCreateDTO1, UserCreateDTO2);
    }

    @Test
    public void testUserCreateDTOHashCodeWithName() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        String name = "John";
        UserCreateDTO1.setName(name);
        UserCreateDTO2.setName(name);

        assertEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
        UserCreateDTO2.setName("Jane");
        assertNotEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
    }

    @Test
    public void testUserCreateDTOHashCodeWithSurname() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        String surname = "Doe";
        UserCreateDTO1.setSurname(surname);
        UserCreateDTO2.setSurname(surname);

        assertEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
        UserCreateDTO2.setSurname("Smith");
        assertNotEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
    }

    @Test
    public void testUserCreateDTOHashCodeWithEmail() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        String email = "test@test.com";
        UserCreateDTO1.setEmail(email);
        UserCreateDTO2.setEmail(email);

        assertEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
        UserCreateDTO2.setEmail("differenttest@test.com");
        assertNotEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
    }

    @Test
    public void testUserCreateDTOHashCodeWithPersonalIdNumber() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        Number personalIdNumber = 123456789;
        UserCreateDTO1.setPersonalIdNumber(personalIdNumber);
        UserCreateDTO2.setPersonalIdNumber(personalIdNumber);

        assertEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
        UserCreateDTO2.setPersonalIdNumber(987654321);
        assertNotEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
    }

    @Test
    public void testUserCreateDTOHashCodeWithCode() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        String code = "123456";
        UserCreateDTO1.setCode(code);
        UserCreateDTO2.setCode(code);

        assertEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
        UserCreateDTO2.setCode("654321");
        assertNotEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
    }

    @Test
    public void testUserCreateDTOHashCodeWithHasVoted() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        Boolean hasVoted = false;
        UserCreateDTO1.setHasVoted(hasVoted);
        UserCreateDTO2.setHasVoted(hasVoted);

        assertEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
        UserCreateDTO2.setHasVoted(true);
        assertNotEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
    }

    @Test
    public void testUserCreateDTOHashCodeWithBirthDate() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        Date birthDate = new Date("01/01/2000");
        UserCreateDTO1.setBirthDate(birthDate);
        UserCreateDTO2.setBirthDate(birthDate);

        assertEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
        UserCreateDTO2.setBirthDate(new Date("01/01/2001"));
        assertNotEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
    }

    @Test
    public void testUserCreateDTOHashCodeWithEducation() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        String education = "High School";
        UserCreateDTO1.setEducation(education);
        UserCreateDTO2.setEducation(education);

        assertEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
        UserCreateDTO2.setEducation("University");
        assertNotEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
    }

    @Test
    public void testUserCreateDTOHashCodeWithProfession() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        String profession = "Engineer";
        UserCreateDTO1.setProfession(profession);
        UserCreateDTO2.setProfession(profession);

        assertEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
        UserCreateDTO2.setProfession("Doctor");
        assertNotEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
    }

    @Test
    public void testUserCreateDTOHashCodeWithSex() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        Boolean sex = true;
        UserCreateDTO1.setSex(sex);
        UserCreateDTO2.setSex(sex);

        assertEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
        UserCreateDTO2.setSex(false);
        assertNotEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
    }

    @Test
    public void testUserCreateDTOHashCodeWithPrecincts() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        Precinct precinct = new Precinct();
        precinct.setPrecinct_id(1);
        List<Precinct> precincts = List.of(precinct);
        UserCreateDTO1.setPrecincts(precincts);
        UserCreateDTO2.setPrecincts(precincts);

        assertEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
        Precinct precinct2 = new Precinct();
        precinct2.setPrecinct_id(2);
        UserCreateDTO2.setPrecincts(List.of(precinct2));
        assertNotEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
    }

    @Test
    public void testUserCreateDTOHashCodeWithAddress() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        Address address = new Address();
        address.setAddress_id(1);
        UserCreateDTO1.setAddress(address);
        UserCreateDTO2.setAddress(address);

        assertEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
        Address address2 = new Address();
        address2.setAddress_id(2);
        UserCreateDTO2.setAddress(address2);
        assertNotEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
    }

    @Test
    public void testUserCreateDTOHashCodeWithCityType() {
        UserCreateDTO UserCreateDTO1 = new UserCreateDTO();
        UserCreateDTO UserCreateDTO2 = new UserCreateDTO();
        CityType cityType = CityType.Over500Thousand;
        UserCreateDTO1.setCityType(cityType);
        UserCreateDTO2.setCityType(cityType);

        assertEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
        UserCreateDTO2.setCityType(CityType.BelowFiftyThousand);
        assertNotEquals(UserCreateDTO1.hashCode(), UserCreateDTO2.hashCode());
    }

    @Test
    public void testUserCreateDTOEqualsWithNull() {
        UserCreateDTO UserCreateDTO = new UserCreateDTO();
        assertNotEquals(UserCreateDTO, null);
    }

    @Test
    public void testUserCreateDTOEqualsWithDifferentClass() {
        UserCreateDTO UserCreateDTO = new UserCreateDTO();
        assertNotEquals(UserCreateDTO, new Object());
    }

    @Test
    public void testUserCreateDTOEqualsWithSameObjec() {
        UserCreateDTO UserCreateDTO = new UserCreateDTO();
        assertEquals(UserCreateDTO, UserCreateDTO);
    }


    @Test
    public void testUserCreateDTOToString() {
        UserCreateDTO UserCreateDTO = new UserCreateDTO();
        String expected = "UserCreateDTO(name=null, surname=null, email=null, password=null, personalIdNumber=null, code=null, hasVoted=null, birthDate=null, education=null, profession=null, sex=null, precincts=null, address=null, cityType=null)";

        assertEquals(expected, UserCreateDTO.toString());
    }


}
