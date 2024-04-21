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
        vote.setVote_id(id);
        assertEquals(id, vote.getVote_id());
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
        vote.setVoter_birthdate(voter_birthdate);
        assertEquals(voter_birthdate, vote.getVoter_birthdate());
    }

    @Test
    public void testVoteWithEducation() {
        Vote vote = new Vote();
        String voter_education = "Bachelor";

        assertNotNull(vote);
        vote.setVoter_education(voter_education);
        assertEquals(voter_education, vote.getVoter_education());
    }

    @Test
    public void testVoteWithCityType() {
        Vote vote = new Vote();
        CityType voter_city_type = CityType.BelowFiftyThousand;

        assertNotNull(vote);
        vote.setVoter_city_type(voter_city_type);
    }

    @Test
    public void testVoteWithVoteTime() {
        Vote vote = new Vote();
        Time vote_time = new Time(0, 0, 0);

        assertNotNull(vote);
        vote.setVote_time(vote_time);
        assertEquals(vote_time, vote.getVote_time());
    }

    @Test
    public void testVoteWithCountry() {
        Vote vote = new Vote();
        String voter_country = "Poland";

        assertNotNull(vote);
        vote.setVoter_country(voter_country);
        assertEquals(voter_country, vote.getVoter_country());
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
        vote1.setVoter_birthdate(birthDate);
        vote2.setVoter_birthdate(birthDate);
        assertEquals(vote1, vote2);
        cal.set(Calendar.YEAR, 1990);
        Date birthDate2 = cal.getTime();
        vote2.setVoter_birthdate(birthDate2);
        assertNotEquals(vote1, vote2);
        vote2.setVoter_birthdate(birthDate);
    }

    @Test
    public void testVoteEntityEqualsEducation() {
        Vote vote1 = new Vote();
        Vote vote2 = new Vote();

        vote1.setVoter_education("Bachelor");
        vote2.setVoter_education("Bachelor");
        assertEquals(vote1, vote2);
        vote2.setVoter_education("Master");
        assertNotEquals(vote1, vote2);
        vote2.setVoter_education("Bachelor");
    }

    @Test
    public void testVoteEntityEqualsCityType() {
        Vote vote1 = new Vote();
        Vote vote2 = new Vote();

        vote1.setVoter_city_type(CityType.BelowFiftyThousand);
        vote2.setVoter_city_type(CityType.BelowFiftyThousand);
        assertEquals(vote1, vote2);
        vote2.setVoter_city_type(CityType.Over500Thousand);
        assertNotEquals(vote1, vote2);
        vote2.setVoter_city_type(CityType.BelowFiftyThousand);
    }

    @Test
    public void testVoteEntityHashCodeVoteId() {
        Vote vote1 = new Vote();
        Vote vote2 = new Vote();

        vote1.setVote_id(1L);
        vote2.setVote_id(1L);
        assertEquals(vote1.hashCode(), vote2.hashCode());
        vote2.setVote_id(2L);
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
        vote1.setVoter_birthdate(birthDate);
        vote2.setVoter_birthdate(birthDate);
        assertEquals(vote1.hashCode(), vote2.hashCode());
        cal.set(Calendar.YEAR, 1990);
        Date birthDate2 = cal.getTime();
        vote2.setVoter_birthdate(birthDate2);
        assertNotEquals(vote1.hashCode(), vote2.hashCode());
    }

    @Test
    public void testVoteEntityHashCodeVoterEducation() {
        Vote vote1 = new Vote();
        Vote vote2 = new Vote();

        vote1.setVoter_education("Bachelor");
        vote2.setVoter_education("Bachelor");
        assertEquals(vote1.hashCode(), vote2.hashCode());
        vote2.setVoter_education("Master");
        assertNotEquals(vote1.hashCode(), vote2.hashCode());
    }

    @Test
    public void testVoteEntityHashCodeVoterCityType() {
        Vote vote1 = new Vote();
        Vote vote2 = new Vote();

        vote1.setVoter_city_type(CityType.BelowFiftyThousand);
        vote2.setVoter_city_type(CityType.BelowFiftyThousand);
        assertEquals(vote1.hashCode(), vote2.hashCode());
        vote2.setVoter_city_type(CityType.Over500Thousand);
        assertNotEquals(vote1.hashCode(), vote2.hashCode());
    }

    @Test
    public void testVoteEntityHashCodeVoteTime() {
        Vote vote1 = new Vote();
        Vote vote2 = new Vote();

        Time voteTime = new Time(0, 0, 0);
        vote1.setVote_time(voteTime);
        vote2.setVote_time(voteTime);
        assertEquals(vote1.hashCode(), vote2.hashCode());
        Time voteTime2 = new Time(1, 0, 0);
        vote2.setVote_time(voteTime2);
        assertNotEquals(vote1.hashCode(), vote2.hashCode());
    }

    @Test
    public void testVoteEntityHashCodeVoterCountry() {
        Vote vote1 = new Vote();
        Vote vote2 = new Vote();

        vote1.setVoter_country("Poland");
        vote2.setVoter_country("Poland");
        assertEquals(vote1.hashCode(), vote2.hashCode());
        vote2.setVoter_country("Germany");
        assertNotEquals(vote1.hashCode(), vote2.hashCode());
    }

    @Test
    public void testVoteEntityToString() {
        Vote vote = new Vote();
        String expectedString = "Vote(vote_id=null, candidate=null, voter_birthdate=null, voter_education=null, voter_city_type=null, vote_time=null, voter_country=null)";
        String actualString = vote.toString();
        assertEquals(expectedString, actualString);
    }


}
