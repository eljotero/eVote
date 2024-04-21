package org.evote.backend.unit.dtos.user;

import org.evote.backend.dtos.user.UserDTO;
import org.evote.backend.users.enums.CityType;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UserDTOTests {

    @Test
    public void testUserDTO() {
        UserDTO userDTO = new UserDTO();
        assertNotNull(userDTO);
    }

    @Test
    public void testUserDTOGettersAndSetter() {
        UserDTO userDTO = new UserDTO();
        UUID user_id = UUID.randomUUID();
        String name = "John";
        String surname = "Doe";
        String email = "test@test.com";
        Number personalIdNumber = 123456789;
        String education = "High School";
        String profession = "Engineer";
        Boolean sex = true;
        CityType cityType = CityType.Over500Thousand;

        userDTO.setUser_id(user_id);
        userDTO.setName(name);
        userDTO.setSurname(surname);
        userDTO.setEmail(email);
        userDTO.setPersonalIdNumber(personalIdNumber);
        userDTO.setEducation(education);
        userDTO.setProfession(profession);
        userDTO.setSex(sex);
        userDTO.setCityType(cityType);

        assertEquals(user_id, userDTO.getUser_id());
        assertEquals(name, userDTO.getName());
        assertEquals(surname, userDTO.getSurname());
        assertEquals(email, userDTO.getEmail());
        assertEquals(personalIdNumber, userDTO.getPersonalIdNumber());
        assertEquals(education, userDTO.getEducation());
        assertEquals(profession, userDTO.getProfession());
        assertEquals(sex, userDTO.getSex());
        assertEquals(cityType, userDTO.getCityType());
    }

    @Test
    public void testUserDTOEqualsWithUserId() {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();
        UUID user_id = UUID.randomUUID();
        userDTO1.setUser_id(user_id);
        userDTO2.setUser_id(user_id);

        assertEquals(userDTO1, userDTO2);
        UUID user_id2 = UUID.randomUUID();
        userDTO2.setUser_id(user_id2);
        assertNotEquals(userDTO1, userDTO2);
    }

    @Test
    public void testUserDTOEqualsWithName() {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();
        String name = "John";
        userDTO1.setName(name);
        userDTO2.setName(name);

        assertEquals(userDTO1, userDTO2);
        userDTO2.setName("Jane");
        assertNotEquals(userDTO1, userDTO2);
    }

    @Test
    public void testUserDTOEqualsWithSurname() {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();
        String surname = "Doe";
        userDTO1.setSurname(surname);
        userDTO2.setSurname(surname);

        assertEquals(userDTO1, userDTO2);
        userDTO2.setSurname("Smith");
        assertNotEquals(userDTO1, userDTO2);
    }

    @Test
    public void testUserDTOEqualsWithEmail() {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();
        String email = "test@test.com";
        userDTO1.setEmail(email);
        userDTO2.setEmail(email);

        assertEquals(userDTO1, userDTO2);
        userDTO2.setEmail("differenttest@test.com");
        assertNotEquals(userDTO1, userDTO2);
    }

    @Test
    public void testUserDTOEqualsWithPersonalIdNumber() {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();
        Number personalIdNumber = 123456789;
        userDTO1.setPersonalIdNumber(personalIdNumber);
        userDTO2.setPersonalIdNumber(personalIdNumber);

        assertEquals(userDTO1, userDTO2);
        userDTO2.setPersonalIdNumber(987654321);
        assertNotEquals(userDTO1, userDTO2);
    }

    @Test
    public void testUserDTOEqualsWithEducation() {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();
        String education = "High School";
        userDTO1.setEducation(education);
        userDTO2.setEducation(education);

        assertEquals(userDTO1, userDTO2);
        userDTO2.setEducation("University");
        assertNotEquals(userDTO1, userDTO2);
    }

    @Test
    public void testUserDTOEqualsWithProfession() {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();
        String profession = "Engineer";
        userDTO1.setProfession(profession);
        userDTO2.setProfession(profession);

        assertEquals(userDTO1, userDTO2);
        userDTO2.setProfession("Doctor");
        assertNotEquals(userDTO1, userDTO2);
    }

    @Test
    public void testUserDTOEqualsWithSex() {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();
        Boolean sex = true;
        userDTO1.setSex(sex);
        userDTO2.setSex(sex);

        assertEquals(userDTO1, userDTO2);
        userDTO2.setSex(false);
        assertNotEquals(userDTO1, userDTO2);
    }

    @Test
    public void testUserDTOEqualsWithCityType() {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();
        CityType cityType = CityType.Over500Thousand;
        userDTO1.setCityType(cityType);
        userDTO2.setCityType(cityType);

        assertEquals(userDTO1, userDTO2);
        userDTO2.setCityType(CityType.BelowFiftyThousand);
        assertNotEquals(userDTO1, userDTO2);
    }


    @Test
    public void testUserDTOHashCodeWithUserId() {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();
        UUID user_id = UUID.randomUUID();
        userDTO1.setUser_id(user_id);
        userDTO2.setUser_id(user_id);

        assertEquals(userDTO1.hashCode(), userDTO2.hashCode());
        UUID user_id2 = UUID.randomUUID();
        userDTO2.setUser_id(user_id2);
        assertNotEquals(userDTO1.hashCode(), userDTO2.hashCode());
    }

    @Test
    public void testUserDTOHashCodeWithName() {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();
        String name = "John";
        userDTO1.setName(name);
        userDTO2.setName(name);

        assertEquals(userDTO1.hashCode(), userDTO2.hashCode());
        userDTO2.setName("Jane");
        assertNotEquals(userDTO1.hashCode(), userDTO2.hashCode());
    }

    @Test
    public void testUserDTOHashCodeWithSurname() {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();
        String surname = "Doe";
        userDTO1.setSurname(surname);
        userDTO2.setSurname(surname);

        assertEquals(userDTO1.hashCode(), userDTO2.hashCode());
        userDTO2.setSurname("Smith");
        assertNotEquals(userDTO1.hashCode(), userDTO2.hashCode());
    }

    @Test
    public void testUserDTOHashCodeWithEmail() {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();
        String email = "test@test.com";
        userDTO1.setEmail(email);
        userDTO2.setEmail(email);

        assertEquals(userDTO1.hashCode(), userDTO2.hashCode());
        userDTO2.setEmail("differenttest@test.com");
        assertNotEquals(userDTO1.hashCode(), userDTO2.hashCode());
    }

    @Test
    public void testUserDTOHashCodeWithPersonalIdNumber() {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();
        Number personalIdNumber = 123456789;
        userDTO1.setPersonalIdNumber(personalIdNumber);
        userDTO2.setPersonalIdNumber(personalIdNumber);

        assertEquals(userDTO1.hashCode(), userDTO2.hashCode());
        userDTO2.setPersonalIdNumber(987654321);
        assertNotEquals(userDTO1.hashCode(), userDTO2.hashCode());
    }

    @Test
    public void testUserDTOHashCodeWithEducation() {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();
        String education = "High School";
        userDTO1.setEducation(education);
        userDTO2.setEducation(education);

        assertEquals(userDTO1.hashCode(), userDTO2.hashCode());
        userDTO2.setEducation("University");
        assertNotEquals(userDTO1.hashCode(), userDTO2.hashCode());
    }

    @Test
    public void testUserDTOHashCodeWithProfession() {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();
        String profession = "Engineer";
        userDTO1.setProfession(profession);
        userDTO2.setProfession(profession);

        assertEquals(userDTO1.hashCode(), userDTO2.hashCode());
        userDTO2.setProfession("Doctor");
        assertNotEquals(userDTO1.hashCode(), userDTO2.hashCode());
    }

    @Test
    public void testUserDTOHashCodeWithSex() {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();
        Boolean sex = true;
        userDTO1.setSex(sex);
        userDTO2.setSex(sex);

        assertEquals(userDTO1.hashCode(), userDTO2.hashCode());
        userDTO2.setSex(false);
        assertNotEquals(userDTO1.hashCode(), userDTO2.hashCode());
    }

    @Test
    public void testUserDTOHashCodeWithCityType() {
        UserDTO userDTO1 = new UserDTO();
        UserDTO userDTO2 = new UserDTO();
        CityType cityType = CityType.Over500Thousand;
        userDTO1.setCityType(cityType);
        userDTO2.setCityType(cityType);

        assertEquals(userDTO1.hashCode(), userDTO2.hashCode());
        userDTO2.setCityType(CityType.BelowFiftyThousand);
        assertNotEquals(userDTO1.hashCode(), userDTO2.hashCode());
    }

    @Test
    public void testUserDTOEqualsWithNull() {
        UserDTO userDTO = new UserDTO();
        assertNotEquals(userDTO, null);
    }

    @Test
    public void testUserDTOEqualsWithDifferentClass() {
        UserDTO userDTO = new UserDTO();
        assertNotEquals(userDTO, new Object());
    }

    @Test
    public void testUserDTOEqualsWithSameObjec() {
        UserDTO userDTO = new UserDTO();
        assertEquals(userDTO, userDTO);
    }


    @Test
    public void testUserDTOToString() {
        UserDTO userDTO = new UserDTO();
        String expected = "UserDTO(user_id=null, name=null, surname=null, email=null, personalIdNumber=null, birthDate=null, education=null, profession=null, sex=null, cityType=null)";

        assertEquals(expected, userDTO.toString());
    }


}
