package org.evote.backend.unit.entities.votes;

import org.evote.backend.votes.address.entity.Address;
import org.evote.backend.votes.precinct.entity.Precinct;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressEntityTests {

    @Test
    public void testAddressEntity() {
        Address address = new Address();
        assertNotNull(address);
    }

    @Test
    public void testAddressEntityWithAddressId() {
        Address address = new Address();
        Integer id = 1;

        assertNotNull(address);
        address.setAddress_id(id);
        assertEquals(id, address.getAddress_id());
    }

    @Test
    public void testAddressEntityWithZipCode() {
        Address address = new Address();
        String zipCode = "12345";

        assertNotNull(address);
        address.setZip_code(zipCode);
        assertEquals(zipCode, address.getZip_code());
    }

    @Test
    public void testAddressEntityWithCity() {
        Address address = new Address();
        String city = "City";

        assertNotNull(address);
        address.setCity(city);
        assertEquals(city, address.getCity());
    }

    @Test
    public void testAddressEntityWithCountry() {
        Address address = new Address();
        String country = "Country";

        assertNotNull(address);
        address.setCountry(country);
        assertEquals(country, address.getCountry());
    }

    @Test
    public void testAddressEntityWithAddressLine() {
        Address address = new Address();
        String addressLine = "Address Line";

        assertNotNull(address);
        address.setAddress_line(addressLine);
        assertEquals(addressLine, address.getAddress_line());
    }

    @Test
    public void testAddressEntityWithPrecinct() {
        Address address = new Address();
        Precinct precinct = new Precinct();

        assertNotNull(address);
        address.setPrecinct(precinct);
        assertEquals(precinct, address.getPrecinct());
    }

    @Test
    public void testAddressEntityWithPoliticalParty() {
        Address address = new Address();
        PoliticalParty politicalParty = new PoliticalParty();

        assertNotNull(address);
        address.setPoliticalParty(politicalParty);
        assertEquals(politicalParty, address.getPoliticalParty());
    }

    @Test
    public void testAddressEntityHashCodeAddressId() {
        Address address = new Address();
        Address address2 = new Address();
        Integer id = 1;

        address.setAddress_id(id);
        address2.setAddress_id(id);
        assertEquals(address.hashCode(), address2.hashCode());
        address2.setAddress_id(2);
        assertNotEquals(address.hashCode(), address2.hashCode());
    }

    @Test
    public void testAddressEntityHashCodeZipCode() {
        Address address = new Address();
        Address address2 = new Address();
        String zipCode = "12345";

        address.setZip_code(zipCode);
        address2.setZip_code(zipCode);
        assertEquals(address.hashCode(), address2.hashCode());
        address2.setZip_code("54321");
        assertNotEquals(address.hashCode(), address2.hashCode());
    }

    @Test
    public void testAddressEntityHashCodeCity() {
        Address address = new Address();
        Address address2 = new Address();
        String city = "City";

        address.setCity(city);
        address2.setCity(city);
        assertEquals(address.hashCode(), address2.hashCode());
        address2.setCity("City2");
        assertNotEquals(address.hashCode(), address2.hashCode());
    }

    @Test
    public void testAddressEntityHashCodeCountry() {
        Address address = new Address();
        Address address2 = new Address();
        String country = "Country";

        address.setCountry(country);
        address2.setCountry(country);
        assertEquals(address.hashCode(), address2.hashCode());
        address2.setCountry("Country2");
        assertNotEquals(address.hashCode(), address2.hashCode());
    }

    @Test
    public void testAddressEntityHashCodeAddressLine() {
        Address address = new Address();
        Address address2 = new Address();
        String addressLine = "Address Line";

        address.setAddress_line(addressLine);
        address2.setAddress_line(addressLine);
        assertEquals(address.hashCode(), address2.hashCode());
        address2.setAddress_line("Address Line 2");
        assertNotEquals(address.hashCode(), address2.hashCode());
    }

    @Test
    public void testAddressEntityHashCodePrecinct() {
        Address address = new Address();
        Address address2 = new Address();
        Precinct precinct = new Precinct();
        precinct.setPrecinct_id(1);

        address.setPrecinct(precinct);
        address2.setPrecinct(precinct);
        assertEquals(address.hashCode(), address2.hashCode());
        Precinct precinct2 = new Precinct();
        precinct2.setPrecinct_id(2);
        address2.setPrecinct(precinct2);
        assertNotEquals(address.hashCode(), address2.hashCode());
    }

    @Test
    public void testAddressEntityHashCodePoliticalParty() {
        Address address = new Address();
        Address address2 = new Address();
        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setName("Political Party");

        address.setPoliticalParty(politicalParty);
        address2.setPoliticalParty(politicalParty);
        assertEquals(address.hashCode(), address2.hashCode());
        PoliticalParty politicalParty2 = new PoliticalParty();
        politicalParty2.setName("Political Party 2");
        address2.setPoliticalParty(politicalParty2);
        assertNotEquals(address.hashCode(), address2.hashCode());
    }

    @Test
    public void testAddressEntityEqualsAddressId() {
        Address address = new Address();
        Address address2 = new Address();
        Integer id = 1;

        address.setAddress_id(id);
        address2.setAddress_id(id);
        assertEquals(address, address2);
        address2.setAddress_id(2);
        assertNotEquals(address, address2);
    }

    @Test
    public void testAddressEntityEqualsZipCode() {
        Address address = new Address();
        Address address2 = new Address();
        String zipCode = "12345";

        address.setZip_code(zipCode);
        address2.setZip_code(zipCode);
        assertEquals(address, address2);
        address2.setZip_code("54321");
        assertNotEquals(address, address2);
    }

    @Test
    public void testAddressEntityEqualsCity() {
        Address address = new Address();
        Address address2 = new Address();
        String city = "City";

        address.setCity(city);
        address2.setCity(city);
        assertEquals(address, address2);
        address2.setCity("City2");
        assertNotEquals(address, address2);
    }

    @Test
    public void testAddressEntityEqualsCountry() {
        Address address = new Address();
        Address address2 = new Address();
        String country = "Country";

        address.setCountry(country);
        address2.setCountry(country);
        assertEquals(address, address2);
        address2.setCountry("Country2");
        assertNotEquals(address, address2);
    }

    @Test
    public void testAddressEntityEqualsAddressLine() {
        Address address = new Address();
        Address address2 = new Address();
        String addressLine = "Address Line";

        address.setAddress_line(addressLine);
        address2.setAddress_line(addressLine);
        assertEquals(address, address2);
        address2.setAddress_line("Address Line 2");
        assertNotEquals(address, address2);
    }

    @Test
    public void testAddressEntityEqualsPrecinct() {
        Address address = new Address();
        Address address2 = new Address();
        Precinct precinct = new Precinct();
        precinct.setPrecinct_id(1);

        address.setPrecinct(precinct);
        address2.setPrecinct(precinct);
        assertEquals(address, address2);
        Precinct precinct2 = new Precinct();
        precinct2.setPrecinct_id(2);
        address2.setPrecinct(precinct2);
        assertNotEquals(address, address2);
    }

    @Test
    public void testAddressEntityEqualsPoliticalParty() {
        Address address = new Address();
        Address address2 = new Address();
        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setName("Political Party");

        address.setPoliticalParty(politicalParty);
        address2.setPoliticalParty(politicalParty);
        assertEquals(address, address2);
        PoliticalParty politicalParty2 = new PoliticalParty();
        politicalParty2.setName("Political Party 2");
        address2.setPoliticalParty(politicalParty2);
        assertNotEquals(address, address2);
    }

    @Test
    public void testAddressEntityEqualsNull() {
        Address address = new Address();
        assertNotEquals(address, null);
    }

    @Test
    public void testAddressEntityEqualsDifferentClass() {
        Address address = new Address();
        assertNotEquals(address, new Object());
    }

    @Test
    public void testAddressEntityEqualsSameObject() {
        Address address = new Address();
        assertEquals(address, address);
    }

    @Test
    public void testAddressEntityToString() {
        Address address = new Address();
        assertNotNull(address);
        assertEquals("Address(address_id=null, zip_code=null, city=null, country=null, address_line=null, precinct=null, politicalParty=null)", address.toString());
    }

}
