package org.evote.backend.unit.services;

import org.evote.backend.services.PrecinctService;
import org.evote.backend.users.precinct.entity.Precinct;
import org.evote.backend.users.precinct.repository.UsersPrecinctRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PrecinctServiceTests {

    @Mock
    private UsersPrecinctRepository usersRepository;

    @InjectMocks
    private PrecinctService precinctService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAllPrecincts() {
        Precinct precinct = new Precinct();
        List<Precinct> precincts = new ArrayList<>();
        precincts.add(precinct);
        when(usersRepository.findAll()).thenReturn(precincts);
        List<Precinct> result = precinctService.findAllPrecincts();
        assertEquals(precincts, result);
    }

    @Test
    public void testFindPrecinctCity() {
        Precinct precinct = new Precinct();
        when(usersRepository.findByAvailableCitiesContainsAndElectionType("city", null)).thenReturn(Optional.of(precinct));
        Precinct result = precinctService.findPrecinctCity("city", null).get();
        assertEquals(precinct, result);
    }

    @Test
    public void testFindPrecinctEuro() {
        Precinct precinct = new Precinct();
        when(usersRepository.findByAddressVoivodeship("voivodeship", null)).thenReturn(Optional.of(precinct));
        Precinct result = precinctService.findPrecinctEuro("voivodeship", null).get();
        assertEquals(precinct, result);
    }
}