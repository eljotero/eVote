package org.evote.backend.controllers;

import org.evote.backend.services.ElectionService;
import org.evote.backend.votes.election.dtos.election.ElectionDTO;
import org.evote.backend.votes.election.dtos.election.ElectionMapper;
import org.evote.backend.votes.election.entity.Election;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/elections")
public class ElectionController {

    @Autowired
    private ElectionService electionService;

    @GetMapping("/all")
    public ResponseEntity<List<ElectionDTO>> getAllElections() {
        List<Election> elections = electionService.getAllElections();
        List<ElectionDTO> electionDTOs = elections.stream().map(ElectionMapper::toElectionDTO).collect(Collectors.toList());
        return ResponseEntity.ok(electionDTOs);
    }
    @GetMapping("/upcoming")
    public ResponseEntity<List<ElectionDTO>> getUpcomingElections() {
        List<Election> elections = electionService.getUpcomingElections();
        List<ElectionDTO> electionDTOs = elections.stream().map(ElectionMapper::toElectionDTO).collect(Collectors.toList());
        return ResponseEntity.ok(electionDTOs);
    }

}