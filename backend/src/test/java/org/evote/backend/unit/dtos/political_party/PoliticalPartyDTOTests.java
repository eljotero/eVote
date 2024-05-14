package org.evote.backend.unit.dtos.political_party;

import org.evote.backend.votes.political_party.dtos.political_party.PoliticalPartyDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PoliticalPartyDTOTests {

    @Test
    public void testGettersAndSetters() {
        PoliticalPartyDTO political_partyDTO = new PoliticalPartyDTO();
        String name = "Test Party";
        Integer address_id = 1;

        political_partyDTO.setName(name);
        political_partyDTO.setAddress_id(address_id);

        assertEquals(name, political_partyDTO.getName());
        assertEquals(address_id, political_partyDTO.getAddress_id());
    }
}