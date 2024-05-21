package org.evote.backend.unit.services;

import org.evote.backend.services.ElectionService;
import org.evote.backend.votes.election.dtos.ElectionCreateDTO;
import org.evote.backend.votes.election.entity.Election;
import org.evote.backend.votes.election.exception.ElectionAlreadyExistsException;
import org.evote.backend.votes.election.exception.ElectionNotFoundException;
import org.evote.backend.votes.election.repository.ElectionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ElectionServiceTests {

    @InjectMocks
    private ElectionService electionService;

    @Mock
    private ElectionRepository electionRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllElections() {
        Election election1 = new Election();
        Election election2 = new Election();
        List<Election> elections = Arrays.asList(election1, election2);

        when(electionRepository.findAll()).thenReturn(elections);

        List<Election> result = electionService.getAllElections();

        assertEquals(elections, result);
    }

    @Test
    public void testGetElectionById() {
        Integer id = 1;
        Election election = new Election();
        election.setElectionId(id);

        when(electionRepository.findById(Math.toIntExact(id))).thenReturn(Optional.of(election));

        Election result = electionService.getElectionById(id);

        assertEquals(election, result);
    }

    @Test
    public void testAddElection() {
        ElectionCreateDTO electionCreateDTO = new ElectionCreateDTO();
        electionCreateDTO.setElection_name("Election 1");

        Election election = new Election();
        election.setElectionName("Election 1");

        when(electionRepository.findByElectionNameAndStartDate(electionCreateDTO.getElection_name(), electionCreateDTO.getStartDate())).thenReturn(null);
        when(electionRepository.save(any(Election.class))).thenReturn(election);

        Election result = electionService.addElection(electionCreateDTO);

        assertEquals(election, result);
    }

    @Test
    public void testDeleteElection() {
        Integer id = 1;
        Election election = new Election();
        election.setElectionId(id);

        when(electionRepository.findById(Math.toIntExact(id))).thenReturn(Optional.of(election));

        electionService.deleteElection(id);

        verify(electionRepository, times(1)).delete(election);
    }

    @Test
    public void testAddElectionAlreadyExists() {
        ElectionCreateDTO electionCreateDTO = new ElectionCreateDTO();
        electionCreateDTO.setElection_name("Election 1");

        Election election = new Election();
        election.setElectionName("Election 1");

        when(electionRepository.findByElectionNameAndStartDate(electionCreateDTO.getElection_name(), electionCreateDTO.getStartDate())).thenReturn(election);

        assertThrows(ElectionAlreadyExistsException.class, () -> electionService.addElection(electionCreateDTO));
    }

    @Test
    public void testGetElectionByIdNotFound() {
        Integer id = 1;

        when(electionRepository.findById(Math.toIntExact(id))).thenReturn(Optional.empty());

        assertThrows(ElectionNotFoundException.class, () -> electionService.getElectionById(id));
    }

    @Test
    public void testDeleteElectionNotFound() {
        Integer id = 1;

        when(electionRepository.findById(Math.toIntExact(id))).thenReturn(Optional.empty());

        assertThrows(ElectionNotFoundException.class, () -> electionService.deleteElection(id));
    }
}