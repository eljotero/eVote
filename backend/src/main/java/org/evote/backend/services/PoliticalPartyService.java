package org.evote.backend.services;

import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.evote.backend.votes.political_party.repository.PoliticalPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliticalPartyService {

    private final PoliticalPartyRepository politicalPartyRepository;

    @Autowired
    public PoliticalPartyService(PoliticalPartyRepository politicalPartyRepository) {
        this.politicalPartyRepository = politicalPartyRepository;
    }

    public List<PoliticalParty> getAllPoliticalParties() {
        return politicalPartyRepository.findAll();
    }

    public String getPoliticalPartyNameById(Long id) {
        return politicalPartyRepository.findNameById(Math.toIntExact(id));
    }
}