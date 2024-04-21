package org.evote.backend.unit.entities.users.precinct;

import org.evote.backend.users.address.entity.Address;
import org.evote.backend.users.precinct.entity.Precinct;
import org.evote.backend.users.enums.ElectionType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrecinctEntityTests {

    @Test
    public void testPrecinctEntity() {
        Precinct precinct = new Precinct();
        assertNotNull(precinct);
    }

    @Test
    public void testPrecinctEntityWithId() {
        Precinct precinct = new Precinct();
        Integer id = 1;

        assertNotNull(precinct);
        precinct.setPrecinct_id(id);
        assertEquals(id, precinct.getPrecinct_id());
    }

    @Test
    public void testPrecinctEntityWithName() {
        Precinct precinct = new Precinct();
        Address address = new Address();

        assertNotNull(precinct);
        precinct.setAddress(address);
        assertEquals(address, precinct.getAddress());
    }

    @Test
    public void testPrecinctEntityWithElectionType() {
        Precinct precinct = new Precinct();
        ElectionType electionType = ElectionType.Presidential;

        assertNotNull(precinct);
        precinct.setElectionType(electionType);
        assertEquals(electionType, precinct.getElectionType());
    }

    @Test
    public void testPrecinctEntityEqualsSameObject() {
        Precinct precinct1 = new Precinct();
        assertEquals(precinct1, precinct1);
    }

    @Test
    public void testPrecinctEntityEqualsNull() {
        Precinct precinct1 = new Precinct();
        assertNotEquals(precinct1, null);
    }

    @Test
    public void testPrecinctEntityEqualsDifferentType() {
        Precinct precinct1 = new Precinct();
        assertNotEquals(precinct1, new Object());
    }

    @Test
    public void testPrecinctEntityEqualsId() {
        Precinct precinct1 = new Precinct();
        Precinct precinct2 = new Precinct();

        precinct1.setPrecinct_id(1);
        precinct2.setPrecinct_id(1);
        assertEquals(precinct1, precinct2);
        precinct2.setPrecinct_id(2);
        assertNotEquals(precinct1, precinct2);
        precinct2.setPrecinct_id(1);
    }

    @Test
    public void testPrecinctEntityEqualsAddress() {
        Precinct precinct1 = new Precinct();
        Precinct precinct2 = new Precinct();

        Address address = new Address();
        address.setAddress_id(1);
        precinct1.setAddress(address);
        precinct2.setAddress(address);
        assertEquals(precinct1, precinct2);
        Address address2 = new Address();
        address2.setAddress_id(2);
        precinct2.setAddress(address2);
        assertNotEquals(precinct1, precinct2);
        precinct2.setAddress(address);
    }

    @Test
    public void testPrecinctEntityEqualsElectionType() {
        Precinct precinct1 = new Precinct();
        Precinct precinct2 = new Precinct();

        precinct1.setElectionType(ElectionType.Presidential);
        precinct2.setElectionType(ElectionType.Presidential);
        assertEquals(precinct1, precinct2);
        precinct2.setElectionType(ElectionType.Parliamentary);
        assertNotEquals(precinct1, precinct2);
        precinct2.setElectionType(ElectionType.Presidential);
    }

    @Test
    public void testPrecinctEntityHashCodePrecinctId() {
        Precinct precinct1 = new Precinct();
        Precinct precinct2 = new Precinct();

        precinct1.setPrecinct_id(1);
        precinct2.setPrecinct_id(1);
        assertEquals(precinct1.hashCode(), precinct2.hashCode());
        precinct2.setPrecinct_id(2);
        assertNotEquals(precinct1.hashCode(), precinct2.hashCode());
        precinct2.setPrecinct_id(1);
    }

    @Test
    public void testPrecinctEntityHashCodeAddress() {
        Precinct precinct1 = new Precinct();
        Precinct precinct2 = new Precinct();

        Address address = new Address();
        address.setAddress_id(1);
        precinct1.setAddress(address);
        precinct2.setAddress(address);
        assertEquals(precinct1.hashCode(), precinct2.hashCode());
        Address address2 = new Address();
        address2.setAddress_id(2);
        precinct2.setAddress(address2);
        assertNotEquals(precinct1.hashCode(), precinct2.hashCode());
        precinct2.setAddress(address);
    }

    @Test
    public void testPrecinctEntityHashCodeElectionType() {
        Precinct precinct1 = new Precinct();
        Precinct precinct2 = new Precinct();

        precinct1.setElectionType(ElectionType.Presidential);
        precinct2.setElectionType(ElectionType.Presidential);
        assertEquals(precinct1.hashCode(), precinct2.hashCode());
        precinct2.setElectionType(ElectionType.Parliamentary);
        assertNotEquals(precinct1.hashCode(), precinct2.hashCode());
        precinct2.setElectionType(ElectionType.Presidential);
    }


    @Test
    public void testPrecinctEntityToString() {
        Precinct precinct = new Precinct();
        String expectedString = "Precinct(precinct_id=null, address=null, electionType=null)";
        String actualString = precinct.toString();
        assertEquals(expectedString, actualString);
    }


}
