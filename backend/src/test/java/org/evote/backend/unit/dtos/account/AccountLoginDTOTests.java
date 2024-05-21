package org.evote.backend.unit.dtos.account;

import org.evote.backend.users.account.dtos.AccountLoginDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountLoginDTOTests {

    @Test
    public void testNoArgsConstructor() {
        AccountLoginDTO accountLoginDTO = new AccountLoginDTO();
        assertNotNull(accountLoginDTO);
    }

    @Test
    public void testAllArgsConstructor() {
        AccountLoginDTO accountLoginDTO = new AccountLoginDTO("test@test.com", "password");
        assertEquals("test@test.com", accountLoginDTO.getEmail());
        assertEquals("password", accountLoginDTO.getPassword());
    }


    @Test
    public void testGetterAndSetter() {
        AccountLoginDTO accountLoginDTO = new AccountLoginDTO();
        accountLoginDTO.setEmail("test@test.com");
        accountLoginDTO.setPassword("password");

        assertEquals("test@test.com", accountLoginDTO.getEmail());
        assertEquals("password", accountLoginDTO.getPassword());
    }
}
