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
        politicalParty.setId(1L);
        politicalParty.setName("Test Party");
        Political_partyDTO political_partyDTO = Political_partyMapper.toPolitical_partyDTO(politicalParty);
        assertEquals(politicalParty.getId(), political_partyDTO.getPolitical_party_id());
        assertEquals(politicalParty.getName(), political_partyDTO.getName());
    }
}