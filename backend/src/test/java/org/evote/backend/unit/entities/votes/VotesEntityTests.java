package org.evote.backend.unit.entities.votes;

import org.evote.backend.votes.enums.CityType;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.evote.backend.votes.vote.entity.Vote;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class VotesEntityTests {

    @Test
    public void testVoteEntity() {
        Vote vote = new Vote();
        assertNotNull(vote);
    }

    @Test
    public void testVoteWithId() {
        Vote vote = new Vote();
        Long id = 1L;

        assertNotNull(vote);
        vote.setVoteId(id);
        assertEquals(id, vote.getVoteId());
    }

    @Test
    public void testVoteWithCandidate() {
        Vote vote = new Vote();
        Candidate candidate = new Candidate();

        assertNotNull(vote);
        vote.setCandidate(candidate);
        assertEquals(candidate, vote.getCandidate());
    }

    @Test
    public void testVoteWithBirthdate() {
        Vote vote = new Vote();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date voter_birthdate = cal.getTime();

        assertNotNull(vote);
        vote.setVoterBirthdate(voter_birthdate);
        assertEquals(voter_birthdate, vote.getVoterBirthdate());
    }

    @Test
    public void testVoteWithEducation() {
        Vote vote = new Vote();
        String voter_education = "Bachelor";

        assertNotNull(vote);
        vote.setVoterEducation(voter_education);
        assertEquals(voter_education, vote.getVoterEducation());
    }

    @Test
    public void testVoteWithCityType() {
        Vote vote = new Vote();
        CityType voter_city_type = CityType.BELOWFIFTYTHOUSAND;

        assertNotNull(vote);
        vote.setVoterCityType(voter_city_type);
    }

    @Test
    public void testVoteWithVoteTime() {
        Vote vote = new Vote();
        Time vote_time = new Time(0, 0, 0);

        assertNotNull(vote);
        vote.setVoteTime(vote_time);
        assertEquals(vote_time, vote.getVoteTime());
    }

    @Test
    public void testVoteWithCountry() {
        Vote vote = new Vote();
        String voter_country = "Poland";

        assertNotNull(vote);
        vote.setVoterCountry(voter_country);
        assertEquals(voter_country, vote.getVoterCountry());
    }

    @Test
    public void testVoteEntityEqualsSameObject() {
        Vote vote1 = new Vote();
        assertEquals(vote1, vote1);
    }

    @Test
    public void testVoteEntityEqualsNull() {
        Vote vote1 = new Vote();
        assertNotEquals(vote1, null);
    }

    @Test
    public void testVoteEntityEqualsDifferentType() {
        Vote vote1 = new Vote();
        Candidate candidate = new Candidate();
        assertNotEquals(vote1, candidate);
    }

    @Test
    public void testVoteEntityEqualsCandidate() {
        Vote vote1 = new Vote();
        Vote vote2 = new Vote();

        Candidate candidate = new Candidate();
        candidate.setName("John");
        vote1.setCandidate(candidate);
        vote2.setCandidate(candidate);
        assertEquals(vote1, vote2);
        Candidate candidate2 = new Candidate();
        candidate2.setName("Jane");
        vote2.setCandidate(candidate2);
        assertNotEquals(vote1, vote2);
        vote2.setCandidate(candidate);
    }

    @Test
    public void testVoteEntityEqualsBirthdate() {
        Vote vote1 = new Vote();
        Vote vote2 = new Vote();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date birthDate = cal.getTime();
        vote1.setVoterBirthdate(birthDate);
        vote2.setVoterBirthdate(birthDate);
        assertEquals(vote1, vote2);
        cal.set(Calendar.YEAR, 1990);
        Date birthDate2 = cal.getTime();
        vote2.setVoterBirthdate(birthDate2);
        assertNotEquals(vote1, vote2);
        vote2.setVoterBirthdate(birthDate);
    }

    @Test
    public void testVoteEntityEqualsEducation() {
        Vote vote1 = new Vote();
        Vote vote2 = new Vote();

        vote1.setVoterEducation("Bachelor");
        vote2.setVoterEducation("Bachelor");
        assertEquals(vote1, vote2);
        vote2.setVoterEducation("Master");
        assertNotEquals(vote1, vote2);
        vote2.setVoterEducation("Bachelor");
    }

    @Test
    public void testVoteEntityEqualsCityType() {
        Vote vote1 = new Vote();
        Vote vote2 = new Vote();

        vote1.setVoterCityType(CityType.BELOWFIFTYTHOUSAND);
        vote2.setVoterCityType(CityType.BELOWFIFTYTHOUSAND);
        assertEquals(vote1, vote2);
        vote2.setVoterCityType(CityType.OVER500THOUSAND);
        assertNotEquals(vote1, vote2);
        vote2.setVoterCityType(CityType.BELOWFIFTYTHOUSAND);
    }

    @Test
    public void testVoteEntityHashCodeVoteId() {
        Vote vote1 = new Vote();
        Vote vote2 = new Vote();

        vote1.setVoteId(1L);
        vote2.setVoteId(1L);
        assertEquals(vote1.hashCode(), vote2.hashCode());
        vote2.setVoteId(2L);
        assertNotEquals(vote1.hashCode(), vote2.hashCode());
    }

    @Test
    public void testVoteEntityHashCodeCandidate() {
        Vote vote1 = new Vote();
        Vote vote2 = new Vote();

        Candidate candidate = new Candidate();
        candidate.setName("John");
        vote1.setCandidate(candidate);
        vote2.setCandidate(candidate);
        assertEquals(vote1.hashCode(), vote2.hashCode());
        Candidate candidate2 = new Candidate();
        candidate2.setName("Jane");
        vote2.setCandidate(candidate2);
        assertNotEquals(vote1.hashCode(), vote2.hashCode());
    }

    @Test
    public void testVoteEntityHashCodeVoterBirthdate() {
        Vote vote1 = new Vote();
        Vote vote2 = new Vote();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date birthDate = cal.getTime();
        vote1.setVoterBirthdate(birthDate);
        vote2.setVoterBirthdate(birthDate);
        assertEquals(vote1.hashCode(), vote2.hashCode());
        cal.set(Calendar.YEAR, 1990);
        Date birthDate2 = cal.getTime();
        vote2.setVoterBirthdate(birthDate2);
        assertNotEquals(vote1.hashCode(), vote2.hashCode());
    }

    @Test
    public void testVoteEntityHashCodeVoterEducation() {
        Vote vote1 = new Vote();
        Vote vote2 = new Vote();

        vote1.setVoterEducation("Bachelor");
        vote2.setVoterEducation("Bachelor");
        assertEquals(vote1.hashCode(), vote2.hashCode());
        vote2.setVoterEducation("Master");
        assertNotEquals(vote1.hashCode(), vote2.hashCode());
    }

    @Test
    public void testVoteEntityHashCodeVoterCityType() {
        Vote vote1 = new Vote();
        Vote vote2 = new Vote();

        vote1.setVoterCityType(CityType.BELOWFIFTYTHOUSAND);
        vote2.setVoterCityType(CityType.BELOWFIFTYTHOUSAND);
        assertEquals(vote1.hashCode(), vote2.hashCode());
        vote2.setVoterCityType(CityType.OVER500THOUSAND);
        assertNotEquals(vote1.hashCode(), vote2.hashCode());
    }

    @Test
    public void testVoteEntityHashCodeVoteTime() {
        Vote vote1 = new Vote();
        Vote vote2 = new Vote();

        Time voteTime = new Time(0, 0, 0);
        vote1.setVoteTime(voteTime);
        vote2.setVoteTime(voteTime);
        assertEquals(vote1.hashCode(), vote2.hashCode());
        Time voteTime2 = new Time(1, 0, 0);
        vote2.setVoteTime(voteTime2);
        assertNotEquals(vote1.hashCode(), vote2.hashCode());
    }

    @Test
    public void testVoteEntityHashCodeVoterCountry() {
        Vote vote1 = new Vote();
        Vote vote2 = new Vote();

        vote1.setVoterCountry("Poland");
        vote2.setVoterCountry("Poland");
        assertEquals(vote1.hashCode(), vote2.hashCode());
        vote2.setVoterCountry("Germany");
        assertNotEquals(vote1.hashCode(), vote2.hashCode());
    }

//    @Test
//    public void testVoteEntityToString() {
//        Vote vote = new Vote();
//        String expectedString = "Vote(vote_id=null, candidate=null, voter_birthdate=null, voter_education=null, voter_city_type=null, vote_time=null, voter_country=null)";
//        String actualString = vote.toString();
//        assertEquals(expectedString, actualString);
//    }


}
