package org.evote.backend.unit.entities.votes;

import org.evote.backend.votes.address.entity.Address;
import org.evote.backend.votes.precinct.entity.Precinct;
import org.evote.backend.votes.enums.ElectionType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrecinctEntityTests {

    @Test
    public void testPrecinctEntity() {
        Precinct precinct = new Precinct();
        assertNotNull(precinct);
    }

    @Test
    public void testPrecinctEntityWithPrecinctId() {
        Precinct precinct = new Precinct();
        Integer id = 1;

        assertNotNull(precinct);
        precinct.setPrecinct_id(id);
        assertEquals(id, precinct.getPrecinct_id());
    }

    @Test
    public void testPrecinctEntityWithPrecinctAddress() {
        Precinct precinct = new Precinct();
        Address address = new Address();

        assertNotNull(precinct);
        precinct.setAddress(address);
        assertEquals(address, precinct.getAddress());
    }

    @Test
    public void testPrecinctEntityWithElection() {
        Precinct precinct = new Precinct();

        assertNotNull(precinct);
        precinct.setElectionType(ElectionType.Presidential);
        assertEquals(ElectionType.Presidential, precinct.getElectionType());
    }

    @Test
    public void testPrecinctEntityHashCodePrecinctId() {
        Precinct precinct = new Precinct();
        Precinct precinct2 = new Precinct();

        precinct.setPrecinct_id(1);
        precinct2.setPrecinct_id(1);
        assertEquals(precinct.hashCode(), precinct2.hashCode());
        precinct2.setPrecinct_id(2);
        assertNotEquals(precinct.hashCode(), precinct2.hashCode());
    }

    @Test
    public void testPrecinctEntityHashCodeAddress() {
        Precinct precinct = new Precinct();
        Precinct precinct2 = new Precinct();
        Address address = new Address();
        address.setAddress_id(1);

        precinct.setAddress(address);
        precinct2.setAddress(address);
        assertEquals(precinct.hashCode(), precinct2.hashCode());
        Address address2 = new Address();
        address2.setAddress_id(2);
        precinct2.setAddress(address2);
        assertNotEquals(precinct.hashCode(), precinct2.hashCode());
    }

    @Test
    public void testPrecinctEntityHashCodeElectionType() {
        Precinct precinct = new Precinct();
        Precinct precinct2 = new Precinct();

        precinct.setElectionType(ElectionType.Presidential);
        precinct2.setElectionType(ElectionType.Presidential);
        assertEquals(precinct.hashCode(), precinct2.hashCode());
        precinct2.setElectionType(ElectionType.LocalGovernment);
        assertNotEquals(precinct.hashCode(), precinct2.hashCode());
    }

    @Test
    public void testPrecinctEntityEqualsPrecinctId() {
        Precinct precinct = new Precinct();
        Precinct precinct2 = new Precinct();
        Integer id = 1;

        precinct.setPrecinct_id(id);
        precinct2.setPrecinct_id(id);
        assertEquals(precinct, precinct2);
        precinct2.setPrecinct_id(2);
        assertNotEquals(precinct, precinct2);
    }

    @Test
    public void testPrecinctEntityEqualsAddress() {
        Precinct precinct = new Precinct();
        Precinct precinct2 = new Precinct();
        Address address = new Address();
        address.setAddress_id(1);

        precinct.setAddress(address);
        precinct2.setAddress(address);
        assertEquals(precinct, precinct2);
        Address address2 = new Address();
        address2.setAddress_id(2);
        precinct2.setAddress(address2);
        assertNotEquals(precinct, precinct2);
    }

    @Test
    public void testPrecinctEntityEqualsElectionType() {
        Precinct precinct = new Precinct();
        Precinct precinct2 = new Precinct();

        precinct.setElectionType(ElectionType.Presidential);
        precinct2.setElectionType(ElectionType.Presidential);
        assertEquals(precinct, precinct2);
        precinct2.setElectionType(ElectionType.LocalGovernment);
        assertNotEquals(precinct, precinct2);
    }

    @Test
    public void testPrecinctEntityEqualsNull() {
        Precinct precinct = new Precinct();
        assertNotEquals(precinct, null);
    }

    @Test
    public void testPrecinctEntityEqualsDifferentClass() {
        Precinct precinct = new Precinct();
        assertNotEquals(precinct, new Object());
    }

    @Test
    public void testPrecinctEntityEqualsSameObject() {
        Precinct precinct = new Precinct();
        assertEquals(precinct, precinct);
    }


    @Test
    public void testPrecinctEntityToString() {
        Precinct precinct = new Precinct();
        assertNotNull(precinct.toString());
        assertEquals("Precinct(precinct_id=null, address=null, electionType=null)", precinct.toString());
    }

}
