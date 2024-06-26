package org.evote.backend.unit.entities.votes;

import org.evote.backend.votes.address.entity.Address;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PoliticalPartyEntityTests {

    @Test
    public void testPoliticalPartyEntity() {
        PoliticalParty politicalParty = new PoliticalParty();
        assertNotNull(politicalParty);
    }

    @Test
    public void testPoliticalPartyEntityWithId() {
        PoliticalParty politicalParty = new PoliticalParty();
        Integer id = 1;

        assertNotNull(politicalParty);
        politicalParty.setPoliticalPartyId(id);
        assertEquals(id, politicalParty.getPoliticalPartyId());
    }

    @Test
    public void testPoliticalPartyEntityWithName() {
        PoliticalParty politicalParty = new PoliticalParty();
        String name = "Democratic Party";

        assertNotNull(politicalParty);
        politicalParty.setName(name);
        assertEquals(name, politicalParty.getName());
    }

    @Test
    public void testPoliticalPartyEntityWithAddress() {
        PoliticalParty politicalParty = new PoliticalParty();
        Address address = new Address();

        assertNotNull(politicalParty);
        politicalParty.setAddress(address);
        assertEquals(address, politicalParty.getAddress());
    }

    @Test
    public void testPoliticalPartyEntityWithCandidates() {
        PoliticalParty politicalParty = new PoliticalParty();
        Candidate candidate = new Candidate();

        assertNotNull(politicalParty);
        politicalParty.setCandidates(List.of(candidate));
        assertEquals(List.of(candidate), politicalParty.getCandidates());
    }

    @Test
    public void testPoliticalPartyEntityEqualsSameObject() {
        PoliticalParty politicalParty1 = new PoliticalParty();
        assertEquals(politicalParty1, politicalParty1);
    }

    @Test
    public void testPoliticalPartyEntityEqualsNull() {
        PoliticalParty politicalParty1 = new PoliticalParty();
        assertNotEquals(politicalParty1, null);
    }

    @Test
    public void testPoliticalPartyEntityEqualsDifferentType() {
        PoliticalParty politicalParty1 = new PoliticalParty();
        Address address = new Address();
        assertNotEquals(politicalParty1, address);
    }

    @Test
    public void testPoliticalPartyEntityEqualsAddress() {
        PoliticalParty politicalParty1 = new PoliticalParty();
        PoliticalParty politicalParty2 = new PoliticalParty();

        Address address = new Address();
        address.setAddress_id(1);
        politicalParty1.setAddress(address);
        politicalParty2.setAddress(address);
        assertEquals(politicalParty1, politicalParty2);
        Address address2 = new Address();
        address2.setAddress_id(2);
        politicalParty2.setAddress(address2);
        assertNotEquals(politicalParty1, politicalParty2);
    }

    @Test
    public void testPoliticalPartyEntityEqualsCandidates() {
        PoliticalParty politicalParty1 = new PoliticalParty();
        PoliticalParty politicalParty2 = new PoliticalParty();

        Candidate candidate = new Candidate();
        candidate.setName("John Doe");
        politicalParty1.setCandidates(List.of(candidate));
        politicalParty2.setCandidates(List.of(candidate));
        assertEquals(politicalParty1, politicalParty2);
        Candidate candidate2 = new Candidate();
        candidate2.setName("Jane Doe");
        politicalParty2.setCandidates(List.of(candidate2));
        assertNotEquals(politicalParty1, politicalParty2);
    }

    @Test
    public void testPoliticalPartyEntityHashCodePoliticalPartyId() {
        PoliticalParty politicalParty1 = new PoliticalParty();
        PoliticalParty politicalParty2 = new PoliticalParty();

        politicalParty1.setPoliticalPartyId(1);
        politicalParty2.setPoliticalPartyId(1);
        assertEquals(politicalParty1.hashCode(), politicalParty2.hashCode());
        politicalParty2.setPoliticalPartyId(2);
        assertNotEquals(politicalParty1.hashCode(), politicalParty2.hashCode());
    }

    @Test
    public void testPoliticalPartyEntityHashCodeName() {
        PoliticalParty politicalParty1 = new PoliticalParty();
        PoliticalParty politicalParty2 = new PoliticalParty();

        politicalParty1.setName("Democratic Party");
        politicalParty2.setName("Democratic Party");
        assertEquals(politicalParty1.hashCode(), politicalParty2.hashCode());
        politicalParty2.setName("Republican Party");
        assertNotEquals(politicalParty1.hashCode(), politicalParty2.hashCode());
    }


    @Test
    public void testPoliticalPartyEntityHashCodeAddress() {
        PoliticalParty politicalParty1 = new PoliticalParty();
        PoliticalParty politicalParty2 = new PoliticalParty();

        Address address = new Address();
        address.setAddress_id(1);
        politicalParty1.setAddress(address);
        politicalParty2.setAddress(address);
        assertEquals(politicalParty1.hashCode(), politicalParty2.hashCode());
        Address address2 = new Address();
        address2.setAddress_id(2);
        politicalParty2.setAddress(address2);
        assertNotEquals(politicalParty1.hashCode(), politicalParty2.hashCode());

    }

    @Test
    public void testPoliticalPartyEntityHashCodeCandidates() {
        PoliticalParty politicalParty1 = new PoliticalParty();
        PoliticalParty politicalParty2 = new PoliticalParty();

        Candidate candidate = new Candidate();
        candidate.setName("John Doe");
        politicalParty1.setCandidates(List.of(candidate));
        politicalParty2.setCandidates(List.of(candidate));
        assertEquals(politicalParty1.hashCode(), politicalParty2.hashCode());
        Candidate candidate2 = new Candidate();
        candidate2.setName("Jane Doe");
        politicalParty2.setCandidates(List.of(candidate2));
        assertNotEquals(politicalParty1.hashCode(), politicalParty2.hashCode());
    }

    @Test
    public void testPoliticalPartyEntityHashCodeNull() {
        PoliticalParty politicalParty1 = new PoliticalParty();
        PoliticalParty politicalParty2 = new PoliticalParty();

        assertEquals(politicalParty1.hashCode(), politicalParty2.hashCode());
    }


    @Test
    public void testPoliticalPartyEntityToString() {
        PoliticalParty politicalParty = new PoliticalParty();
        String expectedString = "PoliticalParty(politicalPartyId=null, name=null, address=null, candidates=null)";
        String actualString = politicalParty.toString();
        assertEquals(expectedString, actualString);
    }
}
