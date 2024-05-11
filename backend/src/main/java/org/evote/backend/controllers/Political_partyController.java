package org.evote.backend.controllers;

import org.evote.backend.services.PoliticalPartyService;
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

    @GetMapping("/name/{id}")
    public ResponseEntity<String> getPoliticalPartyNameById(@PathVariable Long id) {
        String politicalPartyName = politicalPartyService.getPoliticalPartyNameById(id);
        return ResponseEntity.ok(politicalPartyName);
    }

    @PostMapping("/add")
    public ResponseEntity<Political_partyDTO> addPoliticalParty(@RequestBody Political_partyDTO political_partyDTO) {
        PoliticalParty politicalParty = politicalPartyService.addPoliticalParty(Political_partyMapper.toPoliticalParty(political_partyDTO));
        return ResponseEntity.ok(Political_partyMapper.toPolitical_partyDTO(politicalParty));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePoliticalParty(@PathVariable Long id) {
        politicalPartyService.deletePoliticalParty(id);
        return ResponseEntity.noContent().build();
    }
}