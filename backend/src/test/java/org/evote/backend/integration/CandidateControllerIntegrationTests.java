package org.evote.backend.integration;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import org.evote.backend.BackendApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URL;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BackendApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CandidateControllerIntegrationTests {

    private final MockMvc mockMvc;

    @LocalServerPort
    private int port;

    @Autowired
    public CandidateControllerIntegrationTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @BeforeEach
    public void setup() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resourceURL = classLoader.getResource("keystore.p12");

        RestAssured.config = RestAssuredConfig.newConfig().sslConfig(
                new SSLConfig().trustStore(resourceURL.getPath(), "password")
                        .and()
                        .allowAllHostnames()
        );

        baseURI = "https://localhost";
        RestAssured.port = port;
    }

    @Test
    public void testGetAllCandidates() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/candidates/all")).andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void testGetFilteredCandidates() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/candidates/filtered?electionId=1&precinctId=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].candidate_id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Michał")))
                .andExpect(jsonPath("$[0].surname", is("Kot")))
                .andExpect(jsonPath("$[0].birthDate", is("1988-04-19T22:00:00.000+00:00")))
                .andExpect(jsonPath("$[0].education", is("inżynier informatyki")))
                .andExpect(jsonPath("$[0].profession", is("Szefunio")))
                .andExpect(jsonPath("$[0].political_party_id", is(10)))
                .andExpect(jsonPath("$[0].precinct_id", is(1)))
                .andExpect(jsonPath("$[0].info", is("Cos tam cos tam.")))
                .andExpect(jsonPath("$[0].image", is("https://storage.googleapis.com/evote_c/obraz_2024-06-11_211139026.png")));
    }

    @Test
    public void testUnauthenticatedAddCandidate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/candidates/add").contentType(MediaType.APPLICATION_JSON).content(
                "{\n" +
                        "    \"name\": \"Jan\",\n" +
                        "    \"surname\": \"Kowalski\",\n" +
                        "    \"birthDate\": \"1988-04-19T22:00:00.000+00:00\",\n" +
                        "    \"education\": \"inżynier informatyki\",\n" +
                        "    \"profession\": \"Szefunio\",\n" +
                        "    \"political_party_id\": 1,\n" +
                        "    \"precinct_id\": 3,\n" +
                        "    \"info\": \"Cos tam cos tam.\",\n" +
                        "    \"image\": \"https://storage.googleapis.com/evote_c/obraz_2024-06-11_211139026.png\"\n" +
                        "}")).andExpect(status().isForbidden());
    }


    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testAuthenticatedAddAndDeleteCandidate() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/candidates/delete/2"))
                .andExpect(status().isNoContent());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/candidates/all")).andExpect(jsonPath("$", hasSize(1)));
    }


}
