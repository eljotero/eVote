package org.evote.backend.controllers;

import org.evote.backend.services.PoliticalPartyService;
import org.evote.backend.votes.political_party.dtos.political_party.PoliticalPartyCreateDTO;
import org.evote.backend.votes.political_party.dtos.political_party.Political_partyDTO;
import org.evote.backend.votes.political_party.dtos.political_party.Political_partyMapper;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/political_parties")
public class Political_partyController {

    @Autowired
    private PoliticalPartyService politicalPartyService;

    @GetMapping("/all")
    public ResponseEntity<List<Political_partyDTO>> getAllPoliticalParties() {
        List<PoliticalParty> politicalParties = politicalPartyService.getAllPoliticalParties();
        List<Political_partyDTO> political_partyDTOs = politicalParties.stream().map(Political_partyMapper::toPolitical_partyDTO).collect(Collectors.toList());
        return ResponseEntity.ok(political_partyDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Political_partyDTO> getPoliticalPartyById(@PathVariable Integer id) {
        PoliticalParty politicalParty = politicalPartyService.getPoliticalPartyById(id);
        Political_partyDTO political_partyDTO = Political_partyMapper.toPolitical_partyDTO(politicalParty);
        return ResponseEntity.ok(political_partyDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<Political_partyDTO> addPoliticalParty(@RequestBody PoliticalPartyCreateDTO politicalPartyCreateDTO) {
        PoliticalParty politicalParty = politicalPartyService.addPoliticalParty(politicalPartyCreateDTO);
        return ResponseEntity.ok(Political_partyMapper.toPolitical_partyDTO(politicalParty));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePoliticalParty(@PathVariable Integer id) {
        politicalPartyService.deletePoliticalParty(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Political_partyDTO> updatePoliticalParty(@PathVariable Integer id, @RequestBody PoliticalPartyCreateDTO politicalPartyCreateDTO) {
        PoliticalParty politicalParty = politicalPartyService.updatePoliticalParty(id, politicalPartyCreateDTO);
        return ResponseEntity.ok(Political_partyMapper.toPolitical_partyDTO(politicalParty));
    }
}