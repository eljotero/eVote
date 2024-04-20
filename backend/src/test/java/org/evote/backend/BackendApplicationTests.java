package org.evote.backend;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    @Qualifier("usersEntityManagerFactory")
    private EntityManager entityManager;

    @Autowired
    @Qualifier("votesEntityManagerFactory")
    private EntityManager entityManagerVotes;

    @Test
    public void testEntityManager() {
        assertNotNull(entityManager);
        assertNotNull(entityManagerVotes);
    }
}
