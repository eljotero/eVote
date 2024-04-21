package org.evote.backend.unit.dtos.account;

import org.evote.backend.dtos.user.AccountCreateDTO;
import org.evote.backend.users.enums.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountCreateDTOTests {

    @Test
    public void testAccountCreateDTONoArgs() {
        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
        assertNotNull(accountCreateDTO);
    }

    @Test
    public void testAccountCreateDTOAllArgs() {
        String email = "test@test.com";
        String password = "password";
        AccountCreateDTO accountCreateDTO = new AccountCreateDTO(email, password, Role.USER, false, false);

        assertEquals(email, accountCreateDTO.getEmail());
        assertEquals(password, accountCreateDTO.getPassword());
        assertEquals(Role.USER, accountCreateDTO.getRole());
        assertEquals(false, accountCreateDTO.getHasVoted());
        assertEquals(false, accountCreateDTO.getIsAccountActive());
    }

    @Test
    public void testAccountCreateDTOGettersAndSetter() {
        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
        String email = "test@test.com";
        String password = "password";
        accountCreateDTO.setEmail(email);
        accountCreateDTO.setPassword(password);

        assertEquals(email, accountCreateDTO.getEmail());
        assertEquals(password, accountCreateDTO.getPassword());
    }




}
