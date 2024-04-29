package org.evote.backend.unit.dtos.candidate;

import org.evote.backend.votes.candidate.dtos.candidate.CandidateDTO;
import org.evote.backend.votes.candidate.dtos.candidate.CandidateMapper;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CandidateMapperTests {

    @Test
    public void testToCandidateDTO() {
        Candidate candidate = new Candidate();
        candidate.setCandidate_id(UUID.randomUUID());
        candidate.setName("Test Name");
        candidate.setSurname("Test Surname");
        candidate.setBirthDate(new Date());
        candidate.setEducation("Test Education");
        candidate.setProfession("Test Profession");

        CandidateDTO candidateDTO = CandidateMapper.toCandidateDTO(candidate);

        assertEquals(candidate.getCandidate_id(), candidateDTO.getCandidate_id());
        assertEquals(candidate.getName(), candidateDTO.getName());
        assertEquals(candidate.getSurname(), candidateDTO.getSurname());
        assertEquals(candidate.getBirthDate(), candidateDTO.getBirthDate());
        assertEquals(candidate.getEducation(), candidateDTO.getEducation());
        assertEquals(candidate.getProfession(), candidateDTO.getProfession());
    }
}