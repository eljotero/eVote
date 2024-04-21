package org.evote.backend.unit.dtos.user;

import org.evote.backend.dtos.user.UserLoginDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserLoginDTOTests {

    @Test
    public void testUserAuthenticateDTO() {
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        assertNotNull(userLoginDTO);
    }

    @Test
    public void testUserAuthenticateDTOWithEmail() {
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        String email = "test@Test.com";
        String password = "password";

        userLoginDTO.setEmail(email);
        userLoginDTO.setPassword(password);
        assertEquals(email, userLoginDTO.getEmail());
        assertEquals(password, userLoginDTO.getPassword());
    }

    @Test
    public void testUserAuthenticateDTOEqualsWithEmail() {
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        UserLoginDTO userLoginDTO2 = new UserLoginDTO();
        String email = "test@test.com";

        userLoginDTO.setEmail(email);
        userLoginDTO2.setEmail(email);
        assertEquals(userLoginDTO, userLoginDTO2);
        userLoginDTO2.setEmail("differenttest@test.com");
        assertNotEquals(userLoginDTO, userLoginDTO2);
    }

    @Test
    public void testUserAuthenticateDTOEqualsWithPassword() {
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        UserLoginDTO userLoginDTO2 = new UserLoginDTO();
        String password = "password";

        userLoginDTO.setPassword(password);
        userLoginDTO2.setPassword(password);
        assertEquals(userLoginDTO, userLoginDTO2);
        userLoginDTO2.setPassword("differentpassword");
        assertNotEquals(userLoginDTO, userLoginDTO2);
    }

    @Test
    public void testUserAuthenticateDTOHashCodeWithEmail() {
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        UserLoginDTO userLoginDTO2 = new UserLoginDTO();
        String email = "test@test.com";

        userLoginDTO.setEmail(email);
        userLoginDTO2.setEmail(email);
        assertEquals(userLoginDTO.hashCode(), userLoginDTO2.hashCode());
        userLoginDTO2.setEmail("differenttest@test.com");
        assertNotEquals(userLoginDTO.hashCode(), userLoginDTO2.hashCode());
    }

    @Test
    public void testUserAuthenticateDTOHashCodeWithPassword() {
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        UserLoginDTO userLoginDTO2 = new UserLoginDTO();
        String password = "password";

        userLoginDTO.setPassword(password);
        userLoginDTO2.setPassword(password);
        assertEquals(userLoginDTO.hashCode(), userLoginDTO2.hashCode());
        userLoginDTO2.setPassword("differentpassword");
        assertNotEquals(userLoginDTO.hashCode(), userLoginDTO2.hashCode());
    }

    @Test
    public void testUserAuthenticateDTOEqualsWithNull() {
        UserLoginDTO userLoginDTO = new UserLoginDTO();

        assertNotEquals(userLoginDTO, null);
    }

    @Test
    public void testUserAuthenticateDTOEqualsWithDifferentClass() {
        UserLoginDTO userLoginDTO = new UserLoginDTO();

        assertNotEquals(userLoginDTO, new Object());
    }

    @Test
    public void testUserAuthenticateDTOEqualsWithSameObject() {
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        assertEquals(userLoginDTO, userLoginDTO);
    }

    @Test
    public void testUserAuthenticateDTOToString() {
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        String expected = "UserLoginDTO(email=null, password=null)";

        assertEquals(expected, userLoginDTO.toString());
    }

}
