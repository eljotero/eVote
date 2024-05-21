package org.evote.backend.unit.dtos.election;

import org.evote.backend.votes.election.dtos.ElectionDTO;
import org.evote.backend.votes.enums.ElectionType;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectionDTOTests {

    @Test
    public void testGettersAndSetters() {
        ElectionDTO electionDTO = new ElectionDTO();

        Integer election_id = 1;
        String election_name = "Test Election";
        Date startDate = new Date();
        Date endDate = new Date();
        ElectionType type = ElectionType.EuropeanParliament;
        Integer candidate_id = 1;

        electionDTO.setElection_id(election_id);
        electionDTO.setElection_name(election_name);
        electionDTO.setStartDate(startDate);
        electionDTO.setEndDate(endDate);
        electionDTO.setType(type);
        electionDTO.setCandidate_id(candidate_id);

        assertEquals(election_id, electionDTO.getElection_id());
        assertEquals(election_name, electionDTO.getElection_name());
        assertEquals(startDate, electionDTO.getStartDate());
        assertEquals(endDate, electionDTO.getEndDate());
        assertEquals(type, electionDTO.getType());
        assertEquals(candidate_id, electionDTO.getCandidate_id());
    }
}