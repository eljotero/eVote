package org.evote.backend.unit.dtos.election;

import org.evote.backend.votes.election.dtos.ElectionCreateDTO;
import org.evote.backend.votes.enums.ElectionType;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ElectionCreateDTOTests {
    @Test
    public void testGettersAndSetters() {
        ElectionCreateDTO electionCreateDTO = new ElectionCreateDTO();

        String electionName = "Test Election";
        Date startDate = new Date();
        Date endDate = new Date();
        ElectionType type = ElectionType.Presidential;

        electionCreateDTO.setElection_name(electionName);
        electionCreateDTO.setStartDate(startDate);
        electionCreateDTO.setEndDate(endDate);
        electionCreateDTO.setType(type);

        assertEquals(electionName, electionCreateDTO.getElection_name());
        assertEquals(startDate, electionCreateDTO.getStartDate());
        assertEquals(endDate, electionCreateDTO.getEndDate());
        assertEquals(type, electionCreateDTO.getType());
    }

    @Test
    public void testAllArgsConstructor() {
        String electionName = "Test Election";
        Date startDate = new Date();
        Date endDate = new Date();
        ElectionType type = ElectionType.Presidential;

        ElectionCreateDTO electionCreateDTO = new ElectionCreateDTO(electionName, startDate, endDate, type);

        assertEquals(electionName, electionCreateDTO.getElection_name());
        assertEquals(startDate, electionCreateDTO.getStartDate());
        assertEquals(endDate, electionCreateDTO.getEndDate());
        assertEquals(type, electionCreateDTO.getType());
    }

    @Test
    public void testNoArgsConstructor() {
        ElectionCreateDTO electionCreateDTO = new ElectionCreateDTO();

        assertNull(electionCreateDTO.getElection_name());
        assertNull(electionCreateDTO.getStartDate());
        assertNull(electionCreateDTO.getEndDate());
        assertNull(electionCreateDTO.getType());
    }
}
