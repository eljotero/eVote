package org.evote.backend.services;

import org.evote.backend.votes.address.entity.Address;
import org.evote.backend.votes.address.repository.VotesAddressRepository;
import org.evote.backend.votes.political_party.dtos.PoliticalPartyCreateDTO;
import org.evote.backend.votes.political_party.dtos.PoliticalPartyMapper;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.evote.backend.votes.political_party.exception.PoliticalPartyAlreadyExistsException;
import org.evote.backend.votes.political_party.exception.PoliticalPartyNotFoundException;
import org.evote.backend.votes.political_party.repository.PoliticalPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PoliticalPartyService {

    @Autowired
    private PoliticalPartyRepository politicalPartyRepository;
    @Autowired
    private VotesAddressRepository votesAddressRepository;


    public List<PoliticalParty> getAllPoliticalParties() {
        return politicalPartyRepository.findAll();
    }

    @Transactional
    public PoliticalParty getPoliticalPartyById(Integer id) {
        return politicalPartyRepository.findById(id)
                .orElseThrow(() -> new PoliticalPartyNotFoundException("Political party with id " + id + " not found"));
    }

    public PoliticalParty getPoliticalPartyByName(String name) {
        return politicalPartyRepository.findByName(name);
    }

    @Transactional
    public PoliticalParty addPoliticalParty(PoliticalPartyCreateDTO politicalPartyCreateDTO) {
        if(politicalPartyRepository.findByName(politicalPartyCreateDTO.getName()) != null) {
            throw new PoliticalPartyAlreadyExistsException("Political party with name " + politicalPartyCreateDTO.getName() + " already exists");
        }

        Address address = votesAddressRepository.findById(politicalPartyCreateDTO.getAddress_id())
                .orElseThrow(() -> new PoliticalPartyNotFoundException("Address with id " + politicalPartyCreateDTO.getAddress_id() + " not found"));

        PoliticalParty politicalParty = PoliticalPartyMapper.toPoliticalParty(politicalPartyCreateDTO);
        politicalParty.setAddress(address);

        return politicalPartyRepository.save(politicalParty);
    }

    @Transactional
    public void deletePoliticalParty(Integer id) {
        PoliticalParty politicalParty = politicalPartyRepository.findById(Math.toIntExact(id))
                .orElseThrow(() ->  new PoliticalPartyNotFoundException("Political party with id " + id + " not found"));
        politicalPartyRepository.delete(politicalParty);
    }

    @Transactional
    public PoliticalParty updatePoliticalParty(Integer id, PoliticalPartyCreateDTO politicalPartyCreateDTO) {
        PoliticalParty politicalPartyToUpdate = politicalPartyRepository.findById(id)
                .orElseThrow(() -> new PoliticalPartyNotFoundException("Political party with id " + id + " not found"));

        Address address = votesAddressRepository.findById(politicalPartyCreateDTO.getAddress_id())
                .orElseThrow(() -> new PoliticalPartyNotFoundException("Address with id " + politicalPartyCreateDTO.getAddress_id() + " not found"));

        politicalPartyToUpdate.setName(politicalPartyCreateDTO.getName());
        politicalPartyToUpdate.setAddress(address);

        return politicalPartyRepository.save(politicalPartyToUpdate);
    }
}