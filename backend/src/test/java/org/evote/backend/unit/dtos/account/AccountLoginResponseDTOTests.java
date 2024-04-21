package org.evote.backend.unit.dtos.account;

import org.evote.backend.dtos.user.AccountLoginResponseDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountLoginResponseDTOTests {

    @Test
    public void testNoArgsConstructor() {
        AccountLoginResponseDTO accountLoginResponseDTO = new AccountLoginResponseDTO ();
        assertNotNull(accountLoginResponseDTO);
    }

    @Test
    public void testAllArgsConstructor() {
        AccountLoginResponseDTO accountLoginResponseDTO = new AccountLoginResponseDTO ("test@test.com" , "token");
        assertEquals("test@test.com", accountLoginResponseDTO.getEmail());
        assertEquals("token", accountLoginResponseDTO.getToken());
    }

    @Test
    public void testGetterAndSetter() {
        AccountLoginResponseDTO accountLoginResponseDTO = new AccountLoginResponseDTO();
        accountLoginResponseDTO.setEmail("test@test.com");
        accountLoginResponseDTO.setToken("token");

        assertEquals("test@test.com", accountLoginResponseDTO.getEmail());
        assertEquals("token", accountLoginResponseDTO.getToken());
    }
}
