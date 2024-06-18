package org.evote.backend.unit.controllers;

import org.evote.backend.controllers.PrecinctController;
import org.evote.backend.services.PrecinctService;
import org.evote.backend.users.precinct.entity.Precinct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class PrecinctControllerTests {

    @Mock
    private PrecinctService precinctService;

    @InjectMocks
    private PrecinctController precinctController;

    private List<Precinct> precincts;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        precincts = new ArrayList<>();
    }

    @Test
    public void testGetAllPrecincts() {
        when(precinctService.findAllPrecincts()).thenReturn(precincts);
        List<Precinct> result = precinctController.getAllPrecincts();
        Assertions.assertEquals(precincts, result);
    }

}
