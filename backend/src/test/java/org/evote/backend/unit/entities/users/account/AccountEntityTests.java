package org.evote.backend.unit.entities.users.account;

import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.enums.Role;
import org.hibernate.annotations.Type;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountEntityTests {

    @Test
    public void testAccountEntity() {
        Account account = new Account();
        assertNotNull(account);
    }

    @Test
    public void testAccountEntityWithId() {
        Account account = new Account();
        Integer id = 1;

        assertNotNull(account);
        account.setAccount_id(id);
        assertEquals(id, account.getAccount_id());
    }

    @Test
    public void testAccountEntityWithEmail() {
        Account account = new Account();
        String email = "test@test.com";

        assertNotNull(account);
        account.setEmail(email);
        assertEquals(email, account.getEmail());
    }

    @Test
    public void testAccountEntityWithPassword() {
        Account account = new Account();
        String password = "password";

        assertNotNull(account);
        account.setPassword(password);
        assertEquals(password, account.getPassword());
    }

    @Test
    public void testAccountEntityWithRole() {
        Account account = new Account();
        Role role = Role.USER;

        assertNotNull(account);
        account.setRole(role);
        assertEquals(role, account.getRole());
    }

    @Test
    public void testAccountEntityWithHasVoted() {
        Account account = new Account();
        Boolean hasVoted = false;

        assertNotNull(account);
        account.setHasVoted(hasVoted);
        assertEquals(hasVoted, account.getHasVoted());
    }

    @Test
    public void testAccountEntityWithIsAccountActive() {
        Account account = new Account();
        Boolean isAccountActive = true;

        assertNotNull(account);
        account.setIsAccountActive(isAccountActive);
        assertEquals(isAccountActive, account.getIsAccountActive());
    }

    @Test
    public void testAccountEntityEqualsSameObject() {
        Account account1 = new Account();
        assertEquals(account1, account1);
    }

    @Test
    public void testAccountEntityEqualsNull() {
        Account account1 = new Account();
        assertNotEquals(account1, null);
    }

    @Test
    public void testAccountEntityEqualsDifferentType() {
        Account account1 = new Account();
        assertNotEquals(account1, new Object());
    }

    @Test
    public void testAccountEntityEqualsId() {
        Account account1 = new Account();
        Account account2 = new Account();

        account1.setAccount_id(1);
        account2.setAccount_id(1);
        assertEquals(account1, account2);
        account2.setAccount_id(2);
        assertNotEquals(account1, account2);
        account2.setAccount_id(1);
    }

    @Test
    public void testAccountEntityEqualsEmail() {
        Account account1 = new Account();
        Account account2 = new Account();

        account1.setEmail("test@test.com");
        account2.setEmail("test@test.com");
        assertEquals(account1, account2);
        account2.setEmail("differentTest@test.com");
        assertNotEquals(account1, account2);
    }

    @Test
    public void testAccountEntityEqualsPassword() {
        Account account1 = new Account();
        Account account2 = new Account();

        account1.setPassword("password");
        account2.setPassword("password");
        assertEquals(account1, account2);
        account2.setPassword("differentPassword");
        assertNotEquals(account1, account2);
    }

    @Test
    public void testAccountEntityEqualsRole() {
        Account account1 = new Account();
        Account account2 = new Account();

        account1.setRole(Role.USER);
        account2.setRole(Role.USER);
        assertEquals(account1, account2);
        account2.setRole(Role.ADMIN);
        assertNotEquals(account1, account2);
    }

    @Test
    public void testAccountEntityEqualsHasVoted() {
        Account account1 = new Account();
        Account account2 = new Account();

        account1.setHasVoted(false);
        account2.setHasVoted(false);
        assertEquals(account1, account2);
        account2.setHasVoted(true);
        assertNotEquals(account1, account2);
    }

    @Test
    public void testAccountEntityEqualsIsAccountActive() {
        Account account1 = new Account();
        Account account2 = new Account();

        account1.setIsAccountActive(true);
        account2.setIsAccountActive(true);
        assertEquals(account1, account2);
        account2.setIsAccountActive(false);
        assertNotEquals(account1, account2);
    }

    @Test
    public void testAccountEntityHashCodeAccountId() {
        Account account1 = new Account();
        Account account2 = new Account();

        account1.setAccount_id(1);
        account2.setAccount_id(1);
        assertEquals(account1.hashCode(), account2.hashCode());
        account2.setAccount_id(2);
        assertNotEquals(account1.hashCode(), account2.hashCode());
        account2.setAccount_id(1);
    }

    @Test
    public void testAccountEntityHashCodeEmail() {
        Account account1 = new Account();
        Account account2 = new Account();

        account1.setEmail("test@test.com");
        account2.setEmail("test@test.com");
        assertEquals(account1.hashCode(), account2.hashCode());
        account2.setEmail("differentTest@test.com");
        assertNotEquals(account1.hashCode(), account2.hashCode());
    }

    @Test
    public void testAccountEntityHashCodePassword() {
        Account account1 = new Account();
        Account account2 = new Account();

        account1.setPassword("password");
        account2.setPassword("password");
        assertEquals(account1.hashCode(), account2.hashCode());
        account2.setPassword("differentPassword");
        assertNotEquals(account1.hashCode(), account2.hashCode());
    }

    @Test
    public void testAccountEntityHashCodeRole() {
        Account account1 = new Account();
        Account account2 = new Account();

        account1.setRole(Role.USER);
        account2.setRole(Role.USER);
        assertEquals(account1.hashCode(), account2.hashCode());
        account2.setRole(Role.ADMIN);
        assertNotEquals(account1.hashCode(), account2.hashCode());
    }

    @Test
    public void testAccountEntityHashCodeHasVoted() {
        Account account1 = new Account();
        Account account2 = new Account();

        account1.setHasVoted(false);
        account2.setHasVoted(false);
        assertEquals(account1.hashCode(), account2.hashCode());
        account2.setHasVoted(true);
        assertNotEquals(account1.hashCode(), account2.hashCode());
    }

    @Test
    public void testAccountEntityHashCodeIsAccountActive() {
        Account account1 = new Account();
        Account account2 = new Account();

        account1.setIsAccountActive(true);
        account2.setIsAccountActive(true);
        assertEquals(account1.hashCode(), account2.hashCode());
        account2.setIsAccountActive(false);
        assertNotEquals(account1.hashCode(), account2.hashCode());
    }

    @Test
    public void testAccountEntityToString() {
        Account account = new Account();
        String expected = "Account(account_id=null, email=null, password=null, role=null, hasVoted=null, isAccountActive=null, user=null)";
        assertEquals(expected, account.toString());
    }

}
