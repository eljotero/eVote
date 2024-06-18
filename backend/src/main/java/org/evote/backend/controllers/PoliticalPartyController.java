package org.evote.backend.controllers;

import org.evote.backend.services.PoliticalPartyService;
import org.evote.backend.votes.political_party.dtos.PoliticalPartyCreateDTO;
import org.evote.backend.votes.political_party.dtos.PoliticalPartyDTO;
import org.evote.backend.votes.political_party.dtos.PoliticalPartyMapper;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/political_parties")
public class PoliticalPartyController {

    @Autowired
    private PoliticalPartyService politicalPartyService;

    @GetMapping("/all")
    public ResponseEntity<List<PoliticalPartyDTO>> getAllPoliticalParties() {
        List<PoliticalParty> politicalParties = politicalPartyService.getAllPoliticalParties();
        List<PoliticalPartyDTO> political_partyDTOS = politicalParties.stream().map(PoliticalPartyMapper::toPolitical_partyDTO).collect(Collectors.toList());
        return ResponseEntity.ok(political_partyDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PoliticalPartyDTO> getPoliticalPartyById(@PathVariable Integer id) {
        PoliticalParty politicalParty = politicalPartyService.getPoliticalPartyById(id);
        PoliticalPartyDTO political_partyDTO = PoliticalPartyMapper.toPolitical_partyDTO(politicalParty);
        return ResponseEntity.ok(political_partyDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<PoliticalPartyDTO> addPoliticalParty(@RequestBody PoliticalPartyCreateDTO politicalPartyCreateDTO) {
        PoliticalParty politicalParty = politicalPartyService.addPoliticalParty(politicalPartyCreateDTO);
        return ResponseEntity.ok(PoliticalPartyMapper.toPolitical_partyDTO(politicalParty));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePoliticalParty(@PathVariable Integer id) {
        politicalPartyService.deletePoliticalParty(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PoliticalPartyDTO> updatePoliticalParty(@PathVariable Integer id, @RequestBody PoliticalPartyCreateDTO politicalPartyCreateDTO) {
        PoliticalParty politicalParty = politicalPartyService.updatePoliticalParty(id, politicalPartyCreateDTO);
        return ResponseEntity.ok(PoliticalPartyMapper.toPolitical_partyDTO(politicalParty));
    }




}