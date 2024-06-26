package org.evote.backend.unit.controllers;

import org.evote.backend.controllers.ElectionController;
import org.evote.backend.services.ElectionService;
import org.evote.backend.votes.election.dtos.ElectionCreateDTO;
import org.evote.backend.votes.election.dtos.ElectionDTO;
import org.evote.backend.votes.election.entity.Election;
import org.evote.backend.votes.enums.ElectionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ElectionControllerTests {

    @Mock
    private ElectionService electionService;

    @InjectMocks
    private ElectionController electionController;

    private List<Election> elections;

    @BeforeEach
    public void setup() {
        Election election1 = new Election();
        Election election2 = new Election();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2025);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = cal.getTime();

        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date endDate = cal.getTime();

        election1.setElectionId(1);
        election1.setElectionName("Election 1");
        election1.setStartDate(startDate);
        election1.setEndDate(endDate);
        election1.setType(ElectionType.Presidential);

        elections = Arrays.asList(election1, election2);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllElections() {

        when(electionService.getAllElections()).thenReturn(elections);

        ResponseEntity<List<ElectionDTO>> response = electionController.getAllElections();

        Assertions.assertEquals(response.getStatusCode().value(), 200);
        Assertions.assertEquals(Objects.requireNonNull(response.getBody()).size(), 2);
    }

    @Test
    public void testGetUpcomingElections() {
        when(electionService.getUpcomingElections()).thenReturn(Arrays.asList(elections.get(0)));

        ResponseEntity<List<ElectionDTO>> response = electionController.getUpcomingElections();

        Assertions.assertEquals(response.getStatusCode().value(), 200);
        Assertions.assertEquals(Objects.requireNonNull(response.getBody()).size(), 1);
    }

    @Test
    public void testDeleteElection() {
        doNothing().when(electionService).deleteElection(anyInt());

        ResponseEntity<Void> response = electionController.deleteElection(1);

        assert response != null;
        assert response.getStatusCodeValue() == 200;

        verify(electionService, times(1)).deleteElection(1);
    }


    @Test
    public void testAddElection() {
        ElectionCreateDTO electionCreateDTO = new ElectionCreateDTO();
        electionCreateDTO.setElection_name("Election 1");
        electionCreateDTO.setStartDate(new Date());
        electionCreateDTO.setEndDate(new Date());
        electionCreateDTO.setType(ElectionType.Presidential);

        when(electionService.addElection(electionCreateDTO)).thenReturn(elections.get(0));

        ResponseEntity<ElectionDTO> response = electionController.addElection(electionCreateDTO);

        Assertions.assertEquals(response.getStatusCode().value(), 200);
        Assertions.assertEquals(Objects.requireNonNull(response.getBody()).getElection_name(), "Election 1");
    }

}