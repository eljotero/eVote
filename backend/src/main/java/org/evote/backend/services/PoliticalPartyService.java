package org.evote.backend.services;

import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.evote.backend.votes.political_party.exception.PoliticalPartyAlreadyExistsException;
import org.evote.backend.votes.political_party.exception.PoliticalPartyNotFoundException;
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

    public PoliticalParty getPoliticalPartyById(Long id) {
        return politicalPartyRepository.findById(Math.toIntExact(id)).
                orElseThrow(() -> new PoliticalPartyNotFoundException("Political party with id " + id + " not found"));
    }

    public PoliticalParty addPoliticalParty(PoliticalParty politicalParty) {
        if(politicalPartyRepository.findById(Math.toIntExact(politicalParty.getPolitical_party_id())).isPresent()) {
            throw new PoliticalPartyAlreadyExistsException("Political party with id " + politicalParty.getPolitical_party_id() + " already exists");
        }
        return politicalPartyRepository.save(politicalParty);
    }

    public void deletePoliticalParty(Long id) {
        PoliticalParty politicalParty = politicalPartyRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new PoliticalPartyNotFoundException("Political party with id " + id + " not found"));
        politicalPartyRepository.delete(politicalParty);
    }

    public PoliticalParty updatePoliticalParty(Long id, PoliticalParty politicalParty) {
        PoliticalParty politicalPartyToUpdate = politicalPartyRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new PoliticalPartyNotFoundException("Political party with id " + id + " not found"));
        politicalPartyToUpdate.setName(politicalParty.getName());
        return politicalPartyRepository.save(politicalPartyToUpdate);
    }
}