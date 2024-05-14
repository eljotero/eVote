package org.evote.backend.services;

import org.evote.backend.votes.political_party.dtos.political_party.Political_partyDTO;
import org.evote.backend.votes.political_party.dtos.political_party.Political_partyMapper;
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

    public PoliticalParty getPoliticalPartyById(Integer id) {
        return politicalPartyRepository.findById(id)
                .orElseThrow(() -> new PoliticalPartyNotFoundException("Political party with id " + id + " not found"));
    }

    public PoliticalParty addPoliticalParty(PoliticalParty politicalParty) {
        if(politicalPartyRepository.findNameByName(politicalParty.getName()) != null) {
            throw new PoliticalPartyAlreadyExistsException("Political party with name " + politicalParty.getName() + " already exists");
        }
        return politicalPartyRepository.save(politicalParty);
    }

    public void deletePoliticalParty(Integer id) {
        PoliticalParty politicalParty = politicalPartyRepository.findById(Math.toIntExact(id))
                .orElseThrow(() ->  new PoliticalPartyNotFoundException("Political party with id " + id + " not found"));
        politicalPartyRepository.delete(politicalParty);
    }

    public PoliticalParty updatePoliticalParty(Integer id, PoliticalParty politicalParty) {
        PoliticalParty politicalPartyToUpdate = politicalPartyRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new PoliticalPartyNotFoundException("Political party with id " + id + " not found"));
        politicalPartyToUpdate.setName(politicalParty.getName());
        return politicalPartyRepository.save(politicalPartyToUpdate);
    }
}