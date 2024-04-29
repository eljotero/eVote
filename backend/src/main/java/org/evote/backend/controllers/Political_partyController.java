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
@CrossOrigin(origins = "http://localhost:3000")
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
}