package org.evote.backend.unit.entities.votes;

import org.evote.backend.votes.election.entity.Election;
import org.evote.backend.votes.precinct.entity.Precinct;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CandidateEntityTests {

    @Test
    public void testCandidateEntity() {
        Candidate candidate = new Candidate();
        assertNotNull(candidate);
    }

    @Test
    public void testCandidateEntityWithId() {
        Candidate candidate = new Candidate();
        UUID uuid = UUID.randomUUID();

        assertNotNull(candidate);
        candidate.setCandidate_id(uuid);
        assertEquals(uuid, candidate.getCandidate_id());
    }

    @Test
    public void testCandidateEntityWithName() {
        Candidate candidate = new Candidate();
        String name = "John";

        assertNotNull(candidate);
        candidate.setName(name);
        assertEquals(name, candidate.getName());
    }

    @Test
    public void testCandidateEntityWithSurname() {
        Candidate candidate = new Candidate();
        String surname = "Doe";

        assertNotNull(candidate);
        candidate.setSurname(surname);
        assertEquals(surname, candidate.getSurname());
    }

    @Test
    public void testCandidateEntityWithBirthDate() {
        Candidate candidate = new Candidate();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date birthDate = cal.getTime();

        assertNotNull(candidate);
        candidate.setBirthDate(birthDate);
        assertEquals(birthDate, candidate.getBirthDate());
    }

    @Test
    public void testCandidateEntityWithEducation() {
        Candidate candidate = new Candidate();
        String education = "Bachelor's degree";

        assertNotNull(candidate);
        candidate.setEducation(education);
        assertEquals(education, candidate.getEducation());
    }

    @Test
    public void testCandidateEntityWithProfession() {
        Candidate candidate = new Candidate();
        String profession = "Software Engineer";

        assertNotNull(candidate);
        candidate.setProfession(profession);
        assertEquals(profession, candidate.getProfession());
    }

    @Test
    public void testCandidateEntityWithPoliticalParty() {
        Candidate candidate = new Candidate();
        PoliticalParty politicalParty = new PoliticalParty();

        assertNotNull(candidate);
        candidate.setPoliticalParty(politicalParty);
        assertEquals(politicalParty, candidate.getPoliticalParty());
    }

    @Test
    public void testCandidateEntityWithPrecinct() {
        Candidate candidate = new Candidate();
        Precinct precinct = new Precinct();

        assertNotNull(candidate);
        candidate.setPrecinct(precinct);
        assertEquals(precinct, candidate.getPrecinct());
    }

    @Test
    public void testCandidateEntityWithElection() {
        Candidate candidate = new Candidate();
        Election election = new Election();

        assertNotNull(candidate);
        candidate.setElection(election);
        assertEquals(election, candidate.getElection());
    }

    @Test
    public void testCandidateEntityHashCodeName() {
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();
        candidate1.setName("John");
        candidate2.setName("John");

        assertNotNull(candidate1);
        assertNotNull(candidate2);
        assertEquals(candidate1.hashCode(), candidate2.hashCode());
        candidate2.setName("Jane");
        assertNotEquals(candidate1.hashCode(), candidate2.hashCode());
    }

    @Test
    public void testCandidateEntityHashCodeSurname() {
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();

        candidate1.setSurname("Doe");
        candidate2.setSurname("Doe");
        assertEquals(candidate1.hashCode(), candidate2.hashCode());
        candidate2.setSurname("Smith");
        assertNotEquals(candidate1.hashCode(), candidate2.hashCode());
    }

    @Test
    public void testCandidateEntityHashCodeBirthDate() {
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date birthDate = cal.getTime();

        candidate1.setBirthDate(birthDate);
        candidate2.setBirthDate(birthDate);
        assertEquals(candidate1.hashCode(), candidate2.hashCode());
        cal.set(Calendar.YEAR, 1990);
        Date birthDate2 = cal.getTime();
        candidate2.setBirthDate(birthDate2);
        assertNotEquals(candidate1.hashCode(), candidate2.hashCode());
    }

    @Test
    public void testCandidateEntityHashCodeEducation() {
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();
        candidate1.setEducation("Bachelor's degree");
        candidate2.setEducation("Bachelor's degree");

        assertNotNull(candidate1);
        assertNotNull(candidate2);
        assertEquals(candidate1.hashCode(), candidate2.hashCode());
        candidate2.setEducation("Master's degree");
        assertNotEquals(candidate1.hashCode(), candidate2.hashCode());
    }

    @Test
    public void testCandidateEntityHashCodeProfession() {
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();
        candidate1.setProfession("Software Engineer");
        candidate2.setProfession("Software Engineer");

        assertNotNull(candidate1);
        assertNotNull(candidate2);
        assertEquals(candidate1.hashCode(), candidate2.hashCode());
        candidate2.setProfession("Data Scientist");
        assertNotEquals(candidate1.hashCode(), candidate2.hashCode());
    }

    @Test
    public void testCandidateEntityHashCodePoliticalParty() {
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();
        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setName("Republican");
        candidate1.setPoliticalParty(politicalParty);
        candidate2.setPoliticalParty(politicalParty);

        assertNotNull(candidate1);
        assertNotNull(candidate2);
        assertEquals(candidate1.hashCode(), candidate2.hashCode());
        PoliticalParty politicalParty2 = new PoliticalParty();
        politicalParty2.setName("Democrat");
        candidate2.setPoliticalParty(politicalParty2);
        assertNotEquals(candidate1.hashCode(), candidate2.hashCode());
    }

    @Test
    public void testCandidateEntityHashCodePrecinct() {
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();
        Precinct precinct = new Precinct();
        precinct.setPrecinct_id(1);
        candidate1.setPrecinct(precinct);
        candidate2.setPrecinct(precinct);

        assertNotNull(candidate1);
        assertNotNull(candidate2);
        assertEquals(candidate1.hashCode(), candidate2.hashCode());
        Precinct precinct2 = new Precinct();
        precinct.setPrecinct_id(2);
        candidate2.setPrecinct(precinct2);
        assertNotEquals(candidate1.hashCode(), candidate2.hashCode());
    }

    @Test
    public void testCandidateEntityHashCodeElection() {
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();
        Election election = new Election();
        election.setElection_id(1L);
        candidate1.setElection(election);
        candidate2.setElection(election);

        assertNotNull(candidate1);
        assertNotNull(candidate2);
        assertEquals(candidate1.hashCode(), candidate2.hashCode());
        Election election2 = new Election();
        election2.setElection_id(2L);
        candidate2.setElection(election2);
        assertNotEquals(candidate1.hashCode(), candidate2.hashCode());
    }

    @Test
    public void testCandidateEntityEqualsName() {
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();
        candidate1.setName("John");
        candidate2.setName("John");

        assertNotNull(candidate1);
        assertNotNull(candidate2);
        assertEquals(candidate1, candidate2);
        candidate2.setName("Jane");
        assertNotEquals(candidate1, candidate2);
    }

    @Test
    public void testCandidateEntityEqualsSurname() {
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();
        candidate1.setSurname("Doe");
        candidate2.setSurname("Doe");

        assertNotNull(candidate1);
        assertNotNull(candidate2);
        assertEquals(candidate1, candidate2);
        candidate2.setSurname("Smith");
        assertNotEquals(candidate1, candidate2);
    }

    @Test
    public void testCandidateEntityEqualsBirthDate() {
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date birthDate = cal.getTime();

        candidate1.setBirthDate(birthDate);
        candidate2.setBirthDate(birthDate);
        assertEquals(candidate1, candidate2);
        cal.set(Calendar.YEAR, 1990);
        Date birthDate2 = cal.getTime();
        candidate2.setBirthDate(birthDate2);
        assertNotEquals(candidate1, candidate2);
    }

    @Test
    public void testCandidateEntityEqualsEducation() {
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();
        candidate1.setEducation("Bachelor's degree");
        candidate2.setEducation("Bachelor's degree");

        assertNotNull(candidate1);
        assertNotNull(candidate2);
        assertEquals(candidate1, candidate2);
        candidate2.setEducation("Master's degree");
        assertNotEquals(candidate1, candidate2);
    }

    @Test
    public void testCandidateEntityEqualsProfession() {
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();
        candidate1.setProfession("Software Engineer");
        candidate2.setProfession("Software Engineer");

        assertNotNull(candidate1);
        assertNotNull(candidate2);
        assertEquals(candidate1, candidate2);
        candidate2.setProfession("Data Scientist");
        assertNotEquals(candidate1, candidate2);
    }

    @Test
    public void testCandidateEntityEqualsPoliticalParty() {
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();
        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setName("Republican");
        candidate1.setPoliticalParty(politicalParty);
        candidate2.setPoliticalParty(politicalParty);

        assertNotNull(candidate1);
        assertNotNull(candidate2);
        assertEquals(candidate1, candidate2);
        PoliticalParty politicalParty2 = new PoliticalParty();
        politicalParty2.setName("Democrat");
        candidate2.setPoliticalParty(politicalParty2);
        assertNotEquals(candidate1, candidate2);
    }

    @Test
    public void testCandidateEntityEqualsPrecinct() {
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();
        Precinct precinct = new Precinct();
        precinct.setPrecinct_id(1);
        candidate1.setPrecinct(precinct);
        candidate2.setPrecinct(precinct);

        assertNotNull(candidate1);
        assertNotNull(candidate2);
        assertEquals(candidate1, candidate2);
        Precinct precinct2 = new Precinct();
        precinct2.setPrecinct_id(2);
        candidate2.setPrecinct(precinct2);
        assertNotEquals(candidate1, candidate2);
    }

    @Test
    public void testCandidateEntityEqualsElection() {
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();
        Election election = new Election();
        election.setElection_id(1L);
        candidate1.setElection(election);
        candidate2.setElection(election);

        assertNotNull(candidate1);
        assertNotNull(candidate2);
        assertEquals(candidate1, candidate2);
        Election election2 = new Election();
        election2.setElection_id(2L);
        candidate2.setElection(election2);
        assertNotEquals(candidate1, candidate2);
    }

    @Test
    public void testCandidateEntityToString() {
        Candidate candidate = new Candidate();

        String expectedToString = "Candidate(candidate_id=null, name=null, surname=null, birthDate=null, education=null, profession=null, info=null, image=null, politicalParty=null, precinct=null, election=null)";

        assertNotNull(candidate);
        assertEquals(expectedToString, candidate.toString());
    }
}
