package org.evote.backend.unit.controllers;

import org.evote.backend.controllers.StatisticsController;
import org.evote.backend.services.StatisticsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StatisticsControllerTests {

    @InjectMocks
    private StatisticsController statisticsController;

    @Mock
    private StatisticsService statisticsService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllResults() {
        int electionId = 1;
        Map<String, Object> expectedResults = new HashMap<>();
        expectedResults.put("results", new HashMap<>());
        expectedResults.put("resultsByEducation", new HashMap<>());
        expectedResults.put("resultsBySex", new HashMap<>());
        expectedResults.put("resultsByCountry", new HashMap<>());
        expectedResults.put("resultsByAgeGroup", new HashMap<>());
        expectedResults.put("resultsByCityType", new HashMap<>());

        when(statisticsService.getResults(electionId)).thenReturn(new HashMap<>());
        when(statisticsService.getResultsByEducation(electionId)).thenReturn(new HashMap<>());
        when(statisticsService.getResultsBySex(electionId)).thenReturn(new HashMap<>());
        when(statisticsService.getResultsByCountry(electionId)).thenReturn(new HashMap<>());
        when(statisticsService.getResultsByAgeGroup(electionId)).thenReturn(new HashMap<>());
        when(statisticsService.getResultsByCityType(electionId)).thenReturn(new HashMap<>());

        ResponseEntity<?> response = statisticsController.getAllResults(electionId);

        assertEquals(ResponseEntity.ok(expectedResults), response);
    }

    @Test
    public void testGetPrediction() {
        Map<String, Integer> test = new HashMap<>();
        test.put("test", 1);
        when(statisticsService.getPredictions("Senate")).thenReturn(test);
        assertEquals(ResponseEntity.ok(test), statisticsController.getPrediction("Senate"));
    }

}