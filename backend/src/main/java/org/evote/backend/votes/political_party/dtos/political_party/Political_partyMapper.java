package org.evote.backend.votes.political_party.dtos.political_party;

import org.evote.backend.votes.political_party.entity.PoliticalParty;

public class Political_partyMapper {

    public static Political_partyDTO toPolitical_partyDTO(PoliticalParty politicalParty) {
        Political_partyDTO political_partyDTO = new Political_partyDTO();
        political_partyDTO.setId(politicalParty.getPoliticalPartyId());
        political_partyDTO.setName(politicalParty.getName());
        political_partyDTO.setAddress_id(politicalParty.getAddress().getAddress_id());

        return political_partyDTO;
    }

    public static PoliticalParty toPoliticalParty(PoliticalPartyCreateDTO politicalPartyCreateDTO) {
        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setName(politicalPartyCreateDTO.getName());

        return politicalParty;
    }
}