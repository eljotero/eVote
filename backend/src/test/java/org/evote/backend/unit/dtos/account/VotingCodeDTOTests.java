package org.evote.backend.unit.dtos.account;

import org.evote.backend.users.account.dtos.VotingCodeDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VotingCodeDTOTests {
    @Test
    public void testNoArgsConstructor() {
        VotingCodeDTO votingCodeDTO = new VotingCodeDTO();
        assertNull(votingCodeDTO.getCode());
    }

    @Test
    public void testAllArgsConstructor() {
        String code = "123456";
        VotingCodeDTO votingCodeDTO = new VotingCodeDTO(code);
        assertEquals(code, votingCodeDTO.getCode());
    }

    @Test
    public void testSetterAndGetter() {
        String code = "123456";
        VotingCodeDTO votingCodeDTO = new VotingCodeDTO();
        votingCodeDTO.setCode(code);
        assertEquals(code, votingCodeDTO.getCode());
    }
}
