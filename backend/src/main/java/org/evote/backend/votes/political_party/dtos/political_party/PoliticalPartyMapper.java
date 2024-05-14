package org.evote.backend.votes.political_party.dtos.political_party;

import org.evote.backend.votes.political_party.entity.PoliticalParty;

public class PoliticalPartyMapper {

    public static PoliticalPartyDTO toPolitical_partyDTO(PoliticalParty politicalParty) {
        PoliticalPartyDTO political_partyDTO = new PoliticalPartyDTO();
        political_partyDTO.setPoliticalPartyId(politicalParty.getPoliticalPartyId());
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