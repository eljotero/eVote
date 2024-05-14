package org.evote.backend.unit.dtos.political_party;

import org.evote.backend.votes.address.entity.Address;
import org.evote.backend.votes.political_party.dtos.political_party.PoliticalPartyDTO;
import org.evote.backend.votes.political_party.dtos.political_party.PoliticalPartyMapper;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PoliticalPartyMapperTests {

    @Test
    public void testToPolitical_partyDTO() {
        PoliticalParty politicalParty = new PoliticalParty();
        Address address = new Address();
        address.setAddress_id(1);
        politicalParty.setAddress(address);
        politicalParty.setPoliticalPartyId(1);
        politicalParty.setName("Test Party");

        PoliticalPartyDTO political_partyDTO = PoliticalPartyMapper.toPolitical_partyDTO(politicalParty);
        assertEquals(politicalParty.getPoliticalPartyId(), political_partyDTO.getPoliticalPartyId());
        assertEquals(politicalParty.getName(), political_partyDTO.getName());
        assertEquals(politicalParty.getAddress().getAddress_id(), political_partyDTO.getAddress_id());
    }
}