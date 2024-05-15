package org.evote.backend.unit.dtos.candidate;

import org.evote.backend.votes.candidate.dtos.candidate.CandidateCreateDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CandidateDTOTests {

    private CandidateCreateDTO candidateDTO;

    @BeforeEach
    public void setup() {
        candidateDTO = new CandidateCreateDTO();
    }

    @Test
    public void testGettersAndSetters() {
        String name = "Test Name";
        String surname = "Test Surname";
        Date birthDate = new Date();
        String education = "Test Education";
        String profession = "Test Profession";
        Integer political_party_id = 1;
        Integer precinct_id = 1;
        Integer election_id = 1;

        candidateDTO.setName(name);
        candidateDTO.setSurname(surname);
        candidateDTO.setBirthDate(birthDate);
        candidateDTO.setEducation(education);
        candidateDTO.setProfession(profession);
        candidateDTO.setPolitical_party_id(political_party_id);
        candidateDTO.setPrecinct_id(precinct_id);
        candidateDTO.setElection_id(election_id);

        assertEquals(name, candidateDTO.getName());
        assertEquals(surname, candidateDTO.getSurname());
        assertEquals(birthDate, candidateDTO.getBirthDate());
        assertEquals(education, candidateDTO.getEducation());
        assertEquals(profession, candidateDTO.getProfession());
        assertEquals(political_party_id, candidateDTO.getPolitical_party_id());
        assertEquals(precinct_id, candidateDTO.getPrecinct_id());
        assertEquals(election_id, candidateDTO.getElection_id());
    }
}