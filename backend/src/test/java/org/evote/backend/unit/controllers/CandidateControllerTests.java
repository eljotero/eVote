package org.evote.backend.unit.controllers;

import org.evote.backend.services.CandidateService;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CandidateControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CandidateService candidateService;

    private List<Candidate> candidates;

    @BeforeEach
    public void setup() {
        Candidate candidate1 = new Candidate();
        Candidate candidate2 = new Candidate();
        candidates = Arrays.asList(candidate1, candidate2);
    }

    @Test
    public void testGetAllCandidates() throws Exception {
        when(candidateService.getAllCandidates()).thenReturn(candidates);

        mockMvc.perform(get("/api/candidates/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetFilteredCandidates() throws Exception {
        int electionId = 1;
        int precinctId = 1;
        when(candidateService.getCandidatesByElectionIdAndPrecinctId(electionId, precinctId)).thenReturn(candidates);

        mockMvc.perform(get("/api/candidates/filtered")
                        .param("electionId", String.valueOf(electionId))
                        .param("precinctId", String.valueOf(precinctId)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}