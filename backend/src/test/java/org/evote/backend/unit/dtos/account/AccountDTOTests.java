package org.evote.backend.unit.dtos.account;

import org.evote.backend.dtos.user.AccountDTO;
import org.evote.backend.users.enums.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

}
