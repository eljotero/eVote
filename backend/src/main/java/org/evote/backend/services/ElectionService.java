package org.evote.backend.services;

import org.evote.backend.votes.election.dtos.ElectionCreateDTO;
import org.evote.backend.votes.election.dtos.ElectionMapper;
import org.evote.backend.votes.election.entity.Election;
import org.evote.backend.votes.election.exception.ElectionAlreadyExistsException;
import org.evote.backend.votes.election.exception.ElectionNotFoundException;
import org.evote.backend.votes.election.repository.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ElectionService {
    @Autowired
    private ElectionRepository electionRepository;

    public List<Election> getAllElections() {
        return electionRepository.findAll();
    }

    @Transactional
    public List<Election> getUpcomingElections() {
        List<Election> elections = electionRepository.findAll();
        LocalDate today = LocalDate.now();
        elections = elections.stream()
                .filter(election -> !election.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isBefore(today))
                .collect(Collectors.toList());

        if (!elections.isEmpty()) {
            LocalDate closestDate = elections.stream()
                    .map(election -> election.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                    .min(LocalDate::compareTo)
                    .orElse(today);

            elections = elections.stream()
                    .filter(election -> election.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().equals(closestDate))
                    .collect(Collectors.toList());
        }

        return elections;
    }

    public Election getElectionById(Integer id) {
        return electionRepository.findById(id)
                .orElseThrow(() -> new ElectionNotFoundException("Election with id " + id + " not found"));
    }

    @Transactional
    public Election addElection(ElectionCreateDTO electionCreateDTO) {
        if (electionRepository.findByElectionNameAndStartDate(electionCreateDTO.getElection_name(), electionCreateDTO.getStartDate()) != null) {
            throw new ElectionAlreadyExistsException("Election with name " + electionCreateDTO.getElection_name() + " and start date " + electionCreateDTO.getStartDate() + " already exists");
        }
        Election election = ElectionMapper.toElection(electionCreateDTO);
        return electionRepository.save(election);
    }

    // Change to truncate
    @Transactional
    public void deleteElection(Integer id) {
        Election election = electionRepository.findById(id)
                .orElseThrow(() -> new ElectionNotFoundException("Election with id " + id + " not found"));
        electionRepository.delete(election);
    }
}