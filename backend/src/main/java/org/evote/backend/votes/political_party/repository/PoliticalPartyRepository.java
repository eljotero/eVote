package org.evote.backend.votes.political_party.repository;

import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface PoliticalPartyRepository extends JpaRepository<PoliticalParty, Integer> {
    PoliticalParty findByName(String name);
    PoliticalParty findByPoliticalPartyId(Integer politicalPartyId);
}
