package org.evote.backend.unit.controllers;

import org.evote.backend.services.ElectionService;
import org.evote.backend.votes.election.entity.Election;
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
public class ElectionControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ElectionService electionService;

    private List<Election> elections;

    @BeforeEach
    public void setup() {
        Election election1 = new Election();
        Election election2 = new Election();
        elections = Arrays.asList(election1, election2);
    }

    @Test
    public void testGetAllElections() throws Exception {
        when(electionService.getAllElections()).thenReturn(elections);

        mockMvc.perform(get("/api/elections/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetUpcomingElections() throws Exception {
        when(electionService.getUpcomingElections()).thenReturn(elections);

        mockMvc.perform(get("/api/elections/upcoming"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}