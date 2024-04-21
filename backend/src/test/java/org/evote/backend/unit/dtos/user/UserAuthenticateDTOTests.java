package org.evote.backend.unit.dtos.user;

import org.evote.backend.dtos.user.UserAuthenticateDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserAuthenticateDTOTests {

    @Test
    public void testUserAuthenticateDTO() {
        UserAuthenticateDTO userAuthenticateDTO = new UserAuthenticateDTO();
        assertNotNull(userAuthenticateDTO);
    }

    @Test
    public void testUserAuthenticateDTOWithEmail() {
        UserAuthenticateDTO userAuthenticateDTO = new UserAuthenticateDTO();
        String email = "test@Test.com";
        String password = "password";

        userAuthenticateDTO.setEmail(email);
        userAuthenticateDTO.setPassword(password);
        assertEquals(email, userAuthenticateDTO.getEmail());
        assertEquals(password, userAuthenticateDTO.getPassword());
    }

    @Test
    public void testUserAuthenticateDTOEqualsWithEmail() {
        UserAuthenticateDTO userAuthenticateDTO = new UserAuthenticateDTO();
        UserAuthenticateDTO userAuthenticateDTO2 = new UserAuthenticateDTO();
        String email = "test@test.com";

        userAuthenticateDTO.setEmail(email);
        userAuthenticateDTO2.setEmail(email);
        assertEquals(userAuthenticateDTO, userAuthenticateDTO2);
        userAuthenticateDTO2.setEmail("differenttest@test.com");
        assertNotEquals(userAuthenticateDTO, userAuthenticateDTO2);
    }

    @Test
    public void testUserAuthenticateDTOEqualsWithPassword() {
        UserAuthenticateDTO userAuthenticateDTO = new UserAuthenticateDTO();
        UserAuthenticateDTO userAuthenticateDTO2 = new UserAuthenticateDTO();
        String password = "password";

        userAuthenticateDTO.setPassword(password);
        userAuthenticateDTO2.setPassword(password);
        assertEquals(userAuthenticateDTO, userAuthenticateDTO2);
        userAuthenticateDTO2.setPassword("differentpassword");
        assertNotEquals(userAuthenticateDTO, userAuthenticateDTO2);
    }

    @Test
    public void testUserAuthenticateDTOHashCodeWithEmail() {
        UserAuthenticateDTO userAuthenticateDTO = new UserAuthenticateDTO();
        UserAuthenticateDTO userAuthenticateDTO2 = new UserAuthenticateDTO();
        String email = "test@test.com";

        userAuthenticateDTO.setEmail(email);
        userAuthenticateDTO2.setEmail(email);
        assertEquals(userAuthenticateDTO.hashCode(), userAuthenticateDTO2.hashCode());
        userAuthenticateDTO2.setEmail("differenttest@test.com");
        assertNotEquals(userAuthenticateDTO.hashCode(), userAuthenticateDTO2.hashCode());
    }

    @Test
    public void testUserAuthenticateDTOHashCodeWithPassword() {
        UserAuthenticateDTO userAuthenticateDTO = new UserAuthenticateDTO();
        UserAuthenticateDTO userAuthenticateDTO2 = new UserAuthenticateDTO();
        String password = "password";

        userAuthenticateDTO.setPassword(password);
        userAuthenticateDTO2.setPassword(password);
        assertEquals(userAuthenticateDTO.hashCode(), userAuthenticateDTO2.hashCode());
        userAuthenticateDTO2.setPassword("differentpassword");
        assertNotEquals(userAuthenticateDTO.hashCode(), userAuthenticateDTO2.hashCode());
    }

    @Test
    public void testUserAuthenticateDTOEqualsWithNull() {
        UserAuthenticateDTO userAuthenticateDTO = new UserAuthenticateDTO();

        assertNotEquals(userAuthenticateDTO, null);
    }

    @Test
    public void testUserAuthenticateDTOEqualsWithDifferentClass() {
        UserAuthenticateDTO userAuthenticateDTO = new UserAuthenticateDTO();

        assertNotEquals(userAuthenticateDTO, new Object());
    }

    @Test
    public void testUserAuthenticateDTOEqualsWithSameObject() {
        UserAuthenticateDTO userAuthenticateDTO = new UserAuthenticateDTO();
        assertEquals(userAuthenticateDTO, userAuthenticateDTO);
    }

    @Test
    public void testUserAuthenticateDTOToString() {
        UserAuthenticateDTO userAuthenticateDTO = new UserAuthenticateDTO();
        String expected = "UserAuthenticateDTO(email=null, password=null)";

        assertEquals(expected, userAuthenticateDTO.toString());
    }

}
