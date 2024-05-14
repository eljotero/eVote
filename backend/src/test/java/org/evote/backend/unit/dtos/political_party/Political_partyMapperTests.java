package org.evote.backend.unit.dtos.political_party;

import org.evote.backend.votes.political_party.dtos.political_party.Political_partyDTO;
import org.evote.backend.votes.political_party.dtos.political_party.Political_partyMapper;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Political_partyMapperTests {

    @Test
    public void testToPolitical_partyDTO() {
        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setPoliticalPartyId(1);
        politicalParty.setName("Test Party");
        Political_partyDTO political_partyDTO = Political_partyMapper.toPolitical_partyDTO(politicalParty);
        assertEquals(politicalParty.getPoliticalPartyId(), political_partyDTO.getPoliticalPartyId());
        assertEquals(politicalParty.getName(), political_partyDTO.getName());
    }
}