package org.evote.backend.unit.controllers;

import org.evote.backend.services.PoliticalPartyService;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
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
public class Political_partyControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PoliticalPartyService politicalPartyService;

    private List<PoliticalParty> politicalParties;

    @BeforeEach
    public void setup() {
        PoliticalParty politicalParty1 = new PoliticalParty();
        PoliticalParty politicalParty2 = new PoliticalParty();
        politicalParties = Arrays.asList(politicalParty1, politicalParty2);
    }

    @Test
    public void testGetAllPoliticalParties() throws Exception {
        when(politicalPartyService.getAllPoliticalParties()).thenReturn(politicalParties);

        mockMvc.perform(get("/api/political_parties/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetPoliticalPartyNameById() throws Exception {
        Long id = 1L;
        String name = "Test Party";
        when(politicalPartyService.getPoliticalPartyNameById(id)).thenReturn(name);

        mockMvc.perform(get("/api/political_parties/name/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string(name));
    }
}