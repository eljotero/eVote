package org.evote.backend.unit.entities.users.user;

import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.address.entity.Address;
import org.evote.backend.users.enums.CityType;
import org.evote.backend.users.enums.Education;
import org.evote.backend.users.precinct.entity.Precinct;
import org.evote.backend.users.user.entity.User;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UserEntityTests {

    @Test
    public void testUserEntity() {
        User user = new User();
        assertNotNull(user);
    }

    @Test
    public void testUserEntityWithId() {
        User user = new User();
        UUID uuid = UUID.randomUUID();

        assertNotNull(user);
        user.setUser_id(uuid);
        assertEquals(uuid, user.getUser_id());
    }

    @Test
    public void testUserEntityWithName() {
        User user = new User();
        String name = "John";

        assertNotNull(user);
        user.setName("John");
        assertEquals(name, user.getName());
    }

    @Test
    public void testUserEntityWithSurname() {
        User user = new User();
        String surname = "Doe";

        assertNotNull(user);
        user.setSurname("Doe");
        assertEquals(surname, user.getSurname());
    }

    @Test
    public void testUserEntityWithPersonalIdNumber() {
        User user = new User();
        String personalIdNumber = String.valueOf(123456789);

        assertNotNull(user);
        user.setPersonalIdNumber(String.valueOf(123456789));
        assertEquals(personalIdNumber, user.getPersonalIdNumber());
    }

    @Test
    public void testUserEntityWithCode() {
        User user = new User();
        String code = "90-644";

        assertNotNull(user);
        user.setCode(code);
        assertEquals(code, user.getCode());
    }

    @Test
    public void testUserEntityWithBirthDate() {
        User user = new User();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date birthDate = cal.getTime();


        assertNotNull(user);
        user.setBirthDate(birthDate);
        assertEquals(birthDate, user.getBirthDate());
    }

    @Test
    public void testUserEntityWithEducation() {
        User user = new User();
        String education = "PRIMARY";

        assertNotNull(user);
        user.setEducation(Education.valueOf(education));
        assertEquals(Education.PRIMARY, user.getEducation());
    }

    @Test
    public void testUserEntityWithProfession() {
        User user = new User();
        String profession = "Software Engineer";

        assertNotNull(user);
        user.setProfession(profession);
        assertEquals(profession, user.getProfession());
    }

    @Test
    public void testUserEntityWithSex() {
        User user = new User();
        Boolean sex = true;

        assertNotNull(user);
        user.setSex(sex);
        assertEquals(sex, user.getSex());
    }

    @Test
    public void testUserEntityWithCityType() {
        User user = new User();
        CityType cityType = CityType.BELOWFIFTYTHOUSAND;

        assertNotNull(user);
        user.setCityType(cityType);
        assertEquals(cityType, user.getCityType());
    }

    @Test
    public void testUserEntityWithPrecincts() {
        User user = new User();
        Precinct precinct = new Precinct();
        precinct.setPrecinct_id(1);

        assertNotNull(user);
        user.setPrecincts(List.of(precinct));
        assertEquals(1, user.getPrecincts().size());
        assertEquals(precinct, user.getPrecincts().get(0));
    }

    @Test
    public void testUserEntityWithAddress() {
        User user = new User();
        Address address = new Address();
        address.setAddress_id(1);

        assertNotNull(user);
        user.setAddress(address);
        assertEquals(address, user.getAddress());
    }

    @Test
    public void testUserEntityHashCodeName() {
        User user1 = new User();
        User user2 = new User();
        assertEquals(user1.hashCode(), user2.hashCode());

        user1.setName("John");
        user2.setName("John");
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testUserEntityHashCodeSurname() {
        User user1 = new User();
        User user2 = new User();
        user1.setSurname("Doe");
        user2.setSurname("Doe");
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testUserEntityHashCodePersonalIdNumber() {
        User user1 = new User();
        User user2 = new User();

        user1.setPersonalIdNumber(String.valueOf(123456789));
        user2.setPersonalIdNumber(String.valueOf(123456789));
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testUserEntityHashCodeCode() {
        User user1 = new User();
        User user2 = new User();

        user1.setCode("90-644");
        user2.setCode("90-644");
        assertEquals(user1.hashCode(), user2.hashCode());
    }


    @Test
    public void testUserEntityHashCodeBirthDate() {
        User user1 = new User();
        User user2 = new User();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date birthDate = cal.getTime();
        user1.setBirthDate(birthDate);
        user2.setBirthDate(birthDate);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testUserEntityHashCodeEducation() {
        User user1 = new User();
        User user2 = new User();

        user1.setEducation(Education.valueOf("PRIMARY"));
        user2.setEducation(Education.valueOf("PRIMARY"));
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testUserEntityHashCodeProfession() {
        User user1 = new User();
        User user2 = new User();

        user1.setProfession("Software Engineer");
        user2.setProfession("Software Engineer");
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testUserEntityHashCodeSex() {
        User user1 = new User();
        User user2 = new User();

        user1.setSex(true);
        user2.setSex(true);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testUserEntityHashCodeCityType() {
        User user1 = new User();
        User user2 = new User();

        user1.setCityType(CityType.BELOWFIFTYTHOUSAND);
        user2.setCityType(CityType.BELOWFIFTYTHOUSAND);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testUserEntityHashCodePrecinct() {
        User user1 = new User();
        User user2 = new User();

        Precinct precinct = new Precinct();
        precinct.setPrecinct_id(1);
        user1.setPrecincts(List.of(precinct));
        user2.setPrecincts(List.of(precinct));
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testUserEntityHashCodeAddress() {
        User user1 = new User();
        User user2 = new User();

        Address address = new Address();
        address.setAddress_id(1);
        user1.setAddress(address);
        user2.setAddress(address);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testUserEntityEqualsName() {
        User user1 = new User();
        User user2 = new User();

        user1.setName("John");
        user2.setName("John");
        assertEquals(user1, user2);
        user2.setName("Jane");
        assertNotEquals(user1, user2);
        user2.setName("John");
    }

    @Test
    public void testUserEntityEqualsSurname() {
        User user1 = new User();
        User user2 = new User();
        user1.setSurname("Doe");
        user2.setSurname("Doe");
        assertEquals(user1, user2);
        user2.setSurname("Smith");
        assertNotEquals(user1, user2);
        user2.setSurname("Doe");
    }


    @Test
    public void testUserEntityEqualsPersonalIdNumber() {
        User user1 = new User();
        User user2 = new User();
        user1.setPersonalIdNumber(String.valueOf(123456789));
        user2.setPersonalIdNumber(String.valueOf(123456789));
        assertEquals(user1, user2);
        user2.setPersonalIdNumber(String.valueOf(987654321));
        assertNotEquals(user1, user2);
        user2.setPersonalIdNumber(String.valueOf(123456789));
    }

    @Test
    public void testUserEntityEqualsCode() {
        User user1 = new User();
        User user2 = new User();

        user1.setCode("90-644");
        user2.setCode("90-644");
        assertEquals(user1, user2);
        user2.setCode("90-645");
        assertNotEquals(user1, user2);
        user2.setCode("90-644");
    }

    @Test
    public void testUserEntityEqualsBirthDate() {
        User user1 = new User();
        User user2 = new User();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date birthDate = cal.getTime();
        user1.setBirthDate(birthDate);
        user2.setBirthDate(birthDate);
        assertEquals(user1, user2);
        cal.set(Calendar.YEAR, 1990);
        Date birthDate2 = cal.getTime();
        user2.setBirthDate(birthDate2);
        assertNotEquals(user1, user2);
        user2.setBirthDate(birthDate);
    }

    @Test
    public void testUserEntityEqualsEducation() {
        User user1 = new User();
        User user2 = new User();

        user1.setEducation(Education.valueOf("PRIMARY"));
        user2.setEducation(Education.valueOf("PRIMARY"));
        assertEquals(user1, user2);
        user2.setEducation(Education.valueOf("VOCATIONAL"));
        assertNotEquals(user1, user2);
        user2.setEducation(Education.valueOf("PRIMARY"));
    }

    @Test
    public void testUserEntityEqualsProfession() {
        User user1 = new User();
        User user2 = new User();

        user1.setProfession("Software Engineer");
        user2.setProfession("Software Engineer");
        assertEquals(user1, user2);
        user2.setProfession("Doctor");
        assertNotEquals(user1, user2);
        user2.setProfession("Software Engineer");
    }

    @Test
    public void testUserEntityEqualsSex() {
        User user1 = new User();
        User user2 = new User();

        user1.setSex(true);
        user2.setSex(true);
        assertEquals(user1, user2);
        user2.setSex(false);
        assertNotEquals(user1, user2);
        user2.setSex(true);
    }

    @Test
    public void testUserEntityEqualsCityType() {
        User user1 = new User();
        User user2 = new User();

        user1.setCityType(CityType.BELOWFIFTYTHOUSAND);
        user2.setCityType(CityType.BELOWFIFTYTHOUSAND);
        assertEquals(user1, user2);
        user2.setCityType(CityType.OVER500THOUSAND);
        assertNotEquals(user1, user2);
        user2.setCityType(CityType.BELOWFIFTYTHOUSAND);
    }

    @Test
    public void testUserEntityEqualsPrecinct() {
        User user1 = new User();
        User user2 = new User();

        Precinct precinct = new Precinct();
        precinct.setPrecinct_id(1);
        user1.setPrecincts(List.of(precinct));
        user2.setPrecincts(List.of(precinct));
        assertEquals(user1, user2);
        Precinct precinct2 = new Precinct();
        precinct2.setPrecinct_id(2);
        user2.setPrecincts(List.of(precinct2));
        assertNotEquals(user1, user2);
        user2.setPrecincts(List.of(precinct));
    }

    @Test
    public void testUserEntityEqualsAddress() {
        User user1 = new User();
        User user2 = new User();

        Address address = new Address();
        address.setAddress_id(1);
        user1.setAddress(address);
        user2.setAddress(address);
        assertEquals(user1, user2);
        Address address2 = new Address();
        address2.setAddress_id(2);
        user2.setAddress(address2);
        assertNotEquals(user1, user2);
        user2.setAddress(address);

    }

    @Test
    public void testUserEntityEqualsSameObject() {
        User user1 = new User();
        assertEquals(user1, user1);
    }

    @Test
    public void testUserEntityEqualsNull() {
        User user1 = new User();
        assertNotEquals(user1, null);
    }

    @Test
    public void testUserEntityEqualsDifferentType() {
        User user1 = new User();
        assertNotEquals(user1, new Object());
    }

    @Test
    public void testUserEntityToString() {
        User user = new User();
        Account account = new Account();
        String expectedString = "User(user_id=null, name=null, surname=null, sex=null, personalIdNumber=null, code=null, birthDate=null, education=null, cityType=null, profession=null, precincts=null, address=null, account=null)";
        String actualString = user.toString();
        assertEquals(expectedString, user.toString());
    }

}
