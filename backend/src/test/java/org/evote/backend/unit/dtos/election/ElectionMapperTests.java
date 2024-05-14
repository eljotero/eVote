package org.evote.backend.unit.dtos.election;

import org.evote.backend.votes.election.dtos.election.ElectionDTO;
import org.evote.backend.votes.election.dtos.election.ElectionMapper;
import org.evote.backend.votes.election.entity.Election;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectionMapperTests {

    @Test
    public void testToElectionDTO() {
        Election election = new Election();
        election.setElectionId(1L);
        election.setElectionName("Test Election");
        election.setStartDate(new Date());
        election.setEndDate(new Date());
        ElectionDTO electionDTO = ElectionMapper.toElectionDTO(election);
        assertEquals(election.getElectionId().intValue(), electionDTO.getElection_id());
        assertEquals(election.getElectionName(), electionDTO.getElection_name());
        assertEquals(election.getStartDate(), electionDTO.getStartDate());
        assertEquals(election.getEndDate(), electionDTO.getEndDate());
    }
}