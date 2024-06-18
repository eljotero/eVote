package org.evote.backend.unit.dtos.political_party;

import org.evote.backend.votes.political_party.dtos.PoliticalPartyCreateDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PoliticalPartyCreateDTOTests {
    @Test
    public void testGetterAndSetter() {
        String name = "Fajna partia";
        Integer addressId = 123;

        PoliticalPartyCreateDTO party = new PoliticalPartyCreateDTO();
        party.setName(name);
        party.setAddress_id(addressId);

        assertEquals(name, party.getName());
        assertEquals(addressId, party.getAddress_id());
    }

    @Test
    public void testAllArgsConstructor() {
        String name = "Niefajna partia";
        Integer addressId = 456;

        PoliticalPartyCreateDTO party = new PoliticalPartyCreateDTO(name, addressId);

        assertEquals(name, party.getName());
        assertEquals(addressId, party.getAddress_id());
    }

    @Test
    public void testNoArgsConstructor() {
        PoliticalPartyCreateDTO party = new PoliticalPartyCreateDTO();

        assertNull(party.getName());
        assertNull(party.getAddress_id());
    }
}
