package org.evote.backend.votes.political_party.dtos.political_party;

import org.evote.backend.votes.political_party.entity.PoliticalParty;

public class Political_partyMapper {

    public static Political_partyDTO toPolitical_partyDTO(PoliticalParty politicalParty) {
        Political_partyDTO political_partyDTO = new Political_partyDTO();
        political_partyDTO.setPolitical_party_id(politicalParty.getId());
        political_partyDTO.setName(politicalParty.getName());
       // political_partyDTO.setAddress_id(politicalParty.getAddress().getId());

        return political_partyDTO;
    }

    public static PoliticalParty toPoliticalParty(Political_partyDTO politicalPartyDTO) {
        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setId(politicalPartyDTO.getPolitical_party_id());
        politicalParty.setName(politicalPartyDTO.getName());
        //politicalParty.setAddress_id(politicalPartyDTO.getAddress_id());

        return politicalParty;
    }
}