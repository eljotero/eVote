package org.evote.backend.unit.dtos.political_party;

import org.evote.backend.votes.political_party.dtos.political_party.Political_partyDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Political_partyDTOTests {

    @Test
    public void testGettersAndSetters() {
        Political_partyDTO political_partyDTO = new Political_partyDTO();
        String name = "Test Party";
        Integer address_id = 1;

        political_partyDTO.setName(name);
        political_partyDTO.setAddress_id(address_id);

        assertEquals(name, political_partyDTO.getName());
        assertEquals(address_id, political_partyDTO.getAddress_id());
    }
}