package org.evote.backend.unit.dtos.candidate;

import org.evote.backend.votes.candidate.dtos.CandidateCreateDTO;
import org.evote.backend.votes.election.dtos.ElectionCreateDTO;
import org.evote.backend.votes.enums.ElectionType;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CandidateCreateDTOTests {
    private String name = "John";
    private String surname = "Doe";
    private Date birthDate = new Date();
    private String education = "Ph.D. in Political Science";
    private String profession = "Politician";
    private Integer politicalPartyId = 1;
    private  Integer precinctId = 101;
    private Integer electionId = 2024;
    private String info = "Experienced in local governance.";
    private String image = "john_doe.jpg";

    @Test
    public void testGettersAndSetters() {
        CandidateCreateDTO candidate = new CandidateCreateDTO();
        candidate.setName(name);
        candidate.setSurname(surname);
        candidate.setBirthDate(birthDate);
        candidate.setEducation(education);
        candidate.setProfession(profession);
        candidate.setPolitical_party_id(politicalPartyId);
        candidate.setPrecinct_id(precinctId);
        candidate.setElection_id(electionId);
        candidate.setInfo(info);
        candidate.setImage(image);

        assertEquals(name, candidate.getName());
        assertEquals(surname, candidate.getSurname());
        assertEquals(birthDate, candidate.getBirthDate());
        assertEquals(education, candidate.getEducation());
        assertEquals(profession, candidate.getProfession());
        assertEquals(politicalPartyId, candidate.getPolitical_party_id());
        assertEquals(precinctId, candidate.getPrecinct_id());
        assertEquals(electionId, candidate.getElection_id());
        assertEquals(info, candidate.getInfo());
        assertEquals(image, candidate.getImage());
    }

    @Test
    public void testAllArgsConstructor() {
        CandidateCreateDTO candidate = new CandidateCreateDTO(name, surname, birthDate, education, profession,
                politicalPartyId, precinctId, electionId, info, image);

        assertEquals(name, candidate.getName());
        assertEquals(surname, candidate.getSurname());
        assertEquals(birthDate, candidate.getBirthDate());
        assertEquals(education, candidate.getEducation());
        assertEquals(profession, candidate.getProfession());
        assertEquals(politicalPartyId, candidate.getPolitical_party_id());
        assertEquals(precinctId, candidate.getPrecinct_id());
        assertEquals(electionId, candidate.getElection_id());
        assertEquals(info, candidate.getInfo());
        assertEquals(image, candidate.getImage());
    }

    @Test
    public void testNoArgsConstructor() {
        CandidateCreateDTO candidate = new CandidateCreateDTO();
        assertNull(candidate.getName());
        assertNull(candidate.getSurname());
        assertNull(candidate.getBirthDate());
        assertNull(candidate.getEducation());
        assertNull(candidate.getProfession());
        assertNull(candidate.getPolitical_party_id());
        assertNull(candidate.getPrecinct_id());
        assertNull(candidate.getElection_id());
        assertNull(candidate.getInfo());
        assertNull(candidate.getImage());
    }
}
