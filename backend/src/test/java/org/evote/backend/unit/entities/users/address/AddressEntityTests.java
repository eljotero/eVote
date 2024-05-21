package org.evote.backend.unit.entities.users.address;

import org.evote.backend.users.address.entity.Address;
import org.evote.backend.users.precinct.entity.Precinct;
import org.evote.backend.users.user.entity.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressEntityTests {

    @Test
    public void testAddressEntity() {
        Address address = new Address();
        assertNotNull(address);
    }

    @Test
    public void testAddressEntityWithId() {
        Address address = new Address();
        Integer id = 1;

        assertNotNull(address);
        address.setAddress_id(id);
        assertEquals(id, address.getAddress_id());
    }

    @Test
    public void testAddressEntityWithZipCode() {
        Address address = new Address();
        String zipCode = "12-345";

        assertNotNull(address);
        address.setZip_code(zipCode);
        assertEquals(zipCode, address.getZip_code());
    }

    @Test
    public void testAddressEntityWithCity() {
        Address address = new Address();
        String city = "Lodz";

        assertNotNull(address);
        address.setCity(city);
        assertEquals(city, address.getCity());
    }

    @Test
    public void testAddressEntityWithCountry() {
        Address address = new Address();
        String country = "Poland";

        assertNotNull(address);
        address.setCountry(country);
        assertEquals(country, address.getCountry());
    }

    @Test
    public void testAddressEntityWithAddressLine() {
        Address address = new Address();
        String addressLine = "Piotrkowska";

        assertNotNull(address);
        address.setAddress_line(addressLine);
        assertEquals(addressLine, address.getAddress_line());
    }

    @Test
    public void testAddressEntityWithUsers() {
        Address address = new Address();
        User user = new User();

        assertNotNull(address);
        address.setUsers(List.of(user));
        assertEquals(List.of(user), address.getUsers());
        assertEquals(user, address.getUsers().get(0));
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
    public void testAddressEntityEquals() {
        Address address1 = new Address();
        Address address2 = new Address();

        assertNotNull(address1);
        assertNotNull(address2);
        assertEquals(address1, address2);
    }

    @Test
    public void testAddressEntityEqualsWithNull() {
        Address address = new Address();
        assertNotNull(address);
        assertNotEquals(address, null);
    }

    @Test
    public void testAddressEntityEqualsWithDifferentClass() {
        Address address = new Address();
        assertNotNull(address);
        assertNotEquals(address, new Object());
    }

    @Test
    public void testAddressEntityEqualsWithId() {
        Address address1 = new Address();
        Address address2 = new Address();
        Integer id = 1;

        assertNotNull(address1);
        assertNotNull(address2);
        address1.setAddress_id(id);
        address2.setAddress_id(id);
        assertEquals(address1, address2);
        address2.setAddress_id(2);
        assertNotEquals(address1, address2);
    }

    @Test
    public void testAddressEntityEqualsWithZipCode() {
        Address address1 = new Address();
        Address address2 = new Address();
        String zipCode = "12-345";

        assertNotNull(address1);
        assertNotNull(address2);
        address1.setZip_code(zipCode);
        address2.setZip_code(zipCode);
        assertEquals(address1, address2);
        address2.setZip_code("54-321");
        assertNotEquals(address1, address2);
    }

    @Test
    public void testAddressEntityEqualsWithCity() {
        Address address1 = new Address();
        Address address2 = new Address();
        String city = "Lodz";

        assertNotNull(address1);
        assertNotNull(address2);
        address1.setCity(city);
        address2.setCity(city);
        assertEquals(address1, address2);
        address2.setCity("Warsaw");
        assertNotEquals(address1, address2);
    }

    @Test
    public void testAddressEntityEqualsWithCountry() {
        Address address1 = new Address();
        Address address2 = new Address();
        String country = "Poland";

        assertNotNull(address1);
        assertNotNull(address2);
        address1.setCountry(country);
        address2.setCountry(country);
        assertEquals(address1, address2);
        address2.setCountry("Germany");
        assertNotEquals(address1, address2);
    }

    @Test
    public void testAddressEntityEqualsWithAddressLine() {
        Address address1 = new Address();
        Address address2 = new Address();
        String addressLine = "Piotrkowska";

        assertNotNull(address1);
        assertNotNull(address2);
        address1.setAddress_line(addressLine);
        address2.setAddress_line(addressLine);
        assertEquals(address1, address2);
        address2.setAddress_line("Kościuszki");
        assertNotEquals(address1, address2);
    }

    @Test
    public void testAddressEntityEqualsWithUsers() {
        Address address1 = new Address();
        Address address2 = new Address();
        User user = new User();

        assertNotNull(address1);
        assertNotNull(address2);
        address1.setUsers(List.of(user));
        address2.setUsers(List.of(user));
        assertEquals(address1, address2);
        address2.setUsers(List.of());
        assertNotEquals(address1, address2);
    }

    @Test
    public void testAddressEntityEqualsWithPrecinct() {
        Address address1 = new Address();
        Address address2 = new Address();
        Precinct precinct = new Precinct();
        precinct.setPrecinct_id(1);

        assertNotNull(address1);
        assertNotNull(address2);
        address1.setPrecinct(precinct);
        address2.setPrecinct(precinct);
        assertEquals(address1, address2);
        Precinct precinct2 = new Precinct();
        precinct2.setPrecinct_id(2);
        address2.setPrecinct(precinct2);
        assertNotEquals(address1, address2);
    }

    @Test
    public void testAddressEntityHashCode() {
        Address address1 = new Address();
        Address address2 = new Address();

        assertNotNull(address1);
        assertNotNull(address2);
        assertEquals(address1.hashCode(), address2.hashCode());
    }

    @Test
    public void testAddressEntityHashCodeWithId() {
        Address address1 = new Address();
        Address address2 = new Address();
        Integer id = 1;

        assertNotNull(address1);
        assertNotNull(address2);
        address1.setAddress_id(id);
        address2.setAddress_id(id);
        assertEquals(address1.hashCode(), address2.hashCode());
        address2.setAddress_id(2);
        assertNotEquals(address1.hashCode(), address2.hashCode());
    }

    @Test
    public void testAddressEntityHashCodeWithZipCode() {
        Address address1 = new Address();
        Address address2 = new Address();
        String zipCode = "12-345";

        assertNotNull(address1);
        assertNotNull(address2);
        address1.setZip_code(zipCode);
        address2.setZip_code(zipCode);
        assertEquals(address1.hashCode(), address2.hashCode());
        address2.setZip_code("54-321");
        assertNotEquals(address1.hashCode(), address2.hashCode());
    }

    @Test
    public void testAddressEntityHashCodeWithCity() {
        Address address1 = new Address();
        Address address2 = new Address();
        String city = "Lodz";

        assertNotNull(address1);
        assertNotNull(address2);
        address1.setCity(city);
        address2.setCity(city);
        assertEquals(address1.hashCode(), address2.hashCode());
        address2.setCity("Warsaw");
        assertNotEquals(address1.hashCode(), address2.hashCode());
    }


    @Test
    public void testAddressEntityHashCodeWithCountry() {
        Address address1 = new Address();
        Address address2 = new Address();
        String country = "Poland";

        assertNotNull(address1);
        assertNotNull(address2);
        address1.setCountry(country);
        address2.setCountry(country);
        assertEquals(address1.hashCode(), address2.hashCode());
        address2.setCountry("Germany");
        assertNotEquals(address1.hashCode(), address2.hashCode());
    }

    @Test
    public void testAddressEntityHashCodeWithAddressLine() {
        Address address1 = new Address();
        Address address2 = new Address();
        String addressLine = "Piotrkowska";

        assertNotNull(address1);
        assertNotNull(address2);
        address1.setAddress_line(addressLine);
        address2.setAddress_line(addressLine);
        assertEquals(address1.hashCode(), address2.hashCode());
        address2.setAddress_line("Kościuszki");
        assertNotEquals(address1.hashCode(), address2.hashCode());
    }

    @Test
    public void testAddressEntityHashCodeWithUsers() {
        Address address1 = new Address();
        Address address2 = new Address();
        User user = new User();

        assertNotNull(address1);
        assertNotNull(address2);
        address1.setUsers(List.of(user));
        address2.setUsers(List.of(user));
        assertEquals(address1.hashCode(), address2.hashCode());
        address2.setUsers(List.of());
        assertNotEquals(address1.hashCode(), address2.hashCode());
    }

    @Test
    public void testAddressEntityHashCodeWithPrecinct() {
        Address address1 = new Address();
        Address address2 = new Address();
        Precinct precinct = new Precinct();
        precinct.setPrecinct_id(1);

        assertNotNull(address1);
        assertNotNull(address2);
        address1.setPrecinct(precinct);
        address2.setPrecinct(precinct);
        assertEquals(address1.hashCode(), address2.hashCode());
        Precinct precinct2 = new Precinct();
        precinct2.setPrecinct_id(2);
        address2.setPrecinct(precinct2);
        assertNotEquals(address1.hashCode(), address2.hashCode());
    }


    public void testAddressEntityToString() {
        Address address = new Address();
        assertNotNull(address);
        assertEquals("Address(address_id=null, zip_code=null, city=null, country=null, address_line=null, users=null, precinct=null)> but was: <Address(address_id=null, zip_code=nu\n" +
                "ll, voivodeship=null, city=null, country=null, address_line=null, users=null, precinct=null)", address.toString());
    }


}
