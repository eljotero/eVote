package org.evote.backend.unit.entities.votes;

import org.evote.backend.votes.candidate.entity.Candidate;
import org.evote.backend.votes.enums.ElectionType;
import org.evote.backend.votes.election.entity.Election;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ElectionEntityTests {

    @Test
    public void testElectionEntity() {
        Election election = new Election();
        assertNotNull(election);
    }

    @Test
    public void testElectionEntityWithId() {
        Election election = new Election();
        Integer id = 1;

        assertNotNull(election);
        election.setElectionId(id);
        assertEquals(id, election.getElectionId());
    }

    @Test
    public void testElectionEntityWithName() {
        Election election = new Election();
        String name = "Presidential Election 2024";

        assertNotNull(election);
        election.setElectionName(name);
        assertEquals(name, election.getElectionName());
    }

    @Test
    public void testElectionEntityWithStartDate() {
        Election election = new Election();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = cal.getTime();

        assertNotNull(election);
        election.setStartDate(startDate);
        assertEquals(startDate, election.getStartDate());
    }

    @Test
    public void testElectionEntityWithEndDate() {
        Election election = new Election();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date endDate = cal.getTime();

        assertNotNull(election);
        election.setEndDate(endDate);
        assertEquals(endDate, election.getEndDate());
    }

    @Test
    public void testElectionEntityWithType() {
        Election election = new Election();
        ElectionType type = ElectionType.Presidential;

        assertNotNull(election);
        election.setType(type);
        assertEquals(type, election.getType());
    }

    @Test
    public void testElectionEntityWithCandidate() {
        Election election = new Election();
        Candidate candidate = new Candidate();

        assertNotNull(election);
        election.setCandidate(candidate);
        assertEquals(candidate, election.getCandidate());
    }

    @Test
    public void testElectionEntityEqualsSameObject() {
        Election election1 = new Election();
        assertEquals(election1, election1);
    }

    @Test
    public void testElectionEntityEqualsNull() {
        Election election1 = new Election();
        assertNotEquals(election1, null);
    }

    @Test
    public void testElectionEntityEqualsDifferentType() {
        Election election1 = new Election();
        Candidate candidate = new Candidate();
        assertNotEquals(election1, candidate);
    }

    @Test
    public void testElectionEntityEqualsId() {
        Election election1 = new Election();
        Election election2 = new Election();

        Integer id = 1;
        election1.setElectionId(id);
        election2.setElectionId(id);
        assertEquals(election1, election2);
        election2.setElectionId(2);
        assertNotEquals(election1, election2);
        election2.setElectionId(id);
    }

    @Test
    public void testElectionEntityEqualsName() {
        Election election1 = new Election();
        Election election2 = new Election();

        String name = "Presidential Election 2024";
        election1.setElectionName(name);
        election2.setElectionName(name);
        assertEquals(election1, election2);
        election2.setElectionName("Local Election 2024");
        assertNotEquals(election1, election2);
        election2.setElectionName(name);
    }

    @Test
    public void testElectionEntityEqualsStartDate() {
        Election election1 = new Election();
        Election election2 = new Election();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = cal.getTime();
        election1.setStartDate(startDate);
        election2.setStartDate(startDate);
        assertEquals(election1, election2);
        cal.set(Calendar.YEAR, 1990);
        Date startDate2 = cal.getTime();
        election2.setStartDate(startDate2);
        assertNotEquals(election1, election2);
        election2.setStartDate(startDate);
    }

    @Test
    public void testElectionEntityEqualsEndDate() {
        Election election1 = new Election();
        Election election2 = new Election();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date endDate = cal.getTime();
        election1.setEndDate(endDate);
        election2.setEndDate(endDate);
        assertEquals(election1, election2);
        cal.set(Calendar.YEAR, 1990);
        Date endDate2 = cal.getTime();
        election2.setEndDate(endDate2);
        assertNotEquals(election1, election2);
        election2.setEndDate(endDate);
    }

    @Test
    public void testElectionEntityEqualsType() {
        Election election1 = new Election();
        Election election2 = new Election();

        ElectionType type = ElectionType.Presidential;
        election1.setType(type);
        election2.setType(type);
        assertEquals(election1, election2);
        election2.setType(ElectionType.LocalGovernment);
        assertNotEquals(election1, election2);
        election2.setType(type);
    }

    @Test
    public void testElectionEntityEqualsCandidate() {
        Election election1 = new Election();
        Election election2 = new Election();

        Candidate candidate = new Candidate();
        candidate.setName("John Doe");
        election1.setCandidate(candidate);
        election2.setCandidate(candidate);
        assertEquals(election1, election2);

        Candidate candidate2 = new Candidate();
        candidate2.setName("Jane Doe");
        election2.setCandidate(candidate2);
        assertNotEquals(election1, election2);
    }

    @Test
    public void testElectionEntityHashCodeElectionId() {
        Election election1 = new Election();
        Election election2 = new Election();

        election1.setElectionId(1);
        election2.setElectionId(1);
        assertEquals(election1.hashCode(), election2.hashCode());
        election2.setElectionId(2);
        assertNotEquals(election1.hashCode(), election2.hashCode());
    }

    @Test
    public void testElectionEntityHashCodeElectionName() {
        Election election = new Election();
        Election election2 = new Election();

        election.setElectionName("Presidential Election 2024");
        election2.setElectionName("Presidential Election 2024");
        assertEquals(election.hashCode(), election2.hashCode());
        election2.setElectionName("Local Election 2024");
        assertNotEquals(election.hashCode(), election2.hashCode());
    }

    @Test
    public void testElectionEntityHashCodeStartDate() {
        Election election = new Election();
        Election election2 = new Election();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = cal.getTime();
        election.setStartDate(startDate);
        election2.setStartDate(startDate);
        assertEquals(election.hashCode(), election2.hashCode());
        cal.set(Calendar.YEAR, 1990);
        Date startDate2 = cal.getTime();
        election2.setStartDate(startDate2);
        assertNotEquals(election.hashCode(), election2.hashCode());
    }

    @Test
    public void testElectionEntityHashCodeEndDate() {
        Election election = new Election();
        Election election2 = new Election();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date endDate = cal.getTime();
        election.setEndDate(endDate);
        election2.setEndDate(endDate);
        assertEquals(election.hashCode(), election2.hashCode());
        cal.set(Calendar.YEAR, 1990);
        Date endDate2 = cal.getTime();
        election2.setEndDate(endDate2);
        assertNotEquals(election.hashCode(), election2.hashCode());
    }

    @Test
    public void testElectionEntityHashCodeType() {
        Election election = new Election();
        Election election2 = new Election();

        ElectionType type = ElectionType.Presidential;
        election.setType(type);
        election2.setType(type);
        assertEquals(election.hashCode(), election2.hashCode());
        election2.setType(ElectionType.LocalGovernment);
        assertNotEquals(election.hashCode(), election2.hashCode());
    }

    @Test
    public void testElectionEntityHashCodeCandidate() {
        Election election = new Election();
        Election election2 = new Election();

        Candidate candidate = new Candidate();
        candidate.setName("John Doe");
        election.setCandidate(candidate);
        election2.setCandidate(candidate);
        assertEquals(election.hashCode(), election2.hashCode());

        Candidate candidate2 = new Candidate();
        candidate2.setName("Jane Doe");
        election2.setCandidate(candidate2);
        assertNotEquals(election.hashCode(), election2.hashCode());
    }

    @Test
    public void testElectionEntityHashCodeElectionType() {
        Election election = new Election();
        Election election2 = new Election();

        ElectionType type = ElectionType.Presidential;
        election.setType(type);
        election2.setType(type);
        assertEquals(election.hashCode(), election2.hashCode());
        election2.setType(ElectionType.LocalGovernment);
        assertNotEquals(election.hashCode(), election2.hashCode());
    }


    @Test
    public void testElectionEntityToString() {
        Election election = new Election();
        String expectedString = "Election(election_id=null, election_name=null, startDate=null, endDate=null, type=null, candidate=null)";
        assertEquals(expectedString, election.toString());
    }

}
