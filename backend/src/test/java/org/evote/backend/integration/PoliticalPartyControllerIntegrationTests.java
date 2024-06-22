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
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BackendApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PoliticalPartyControllerIntegrationTests {

    private final MockMvc mockMvc;

    @LocalServerPort
    private int port;

    @Autowired
    public PoliticalPartyControllerIntegrationTests(MockMvc mockMvc) {
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
    public void testGetAllPoliticalParties() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/political_parties/all"))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void testGetPoliticalPartyById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/political_parties/10"))
                .andExpect(jsonPath("$.politicalPartyId").value(10))
                .andExpect(jsonPath("$.name").value("Prawo i Sprawiedliwość"))
                .andExpect(jsonPath("$.address_id").value(1));
    }

    @Test
    public void testGetPoliticalPartyByIdNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/political_parties/100"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUnauthenticatedAddPoliticalParty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/political_parties/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\": \"Nowa Partia\",\n" +
                                "    \"address_id\": 1\n" +
                                "}"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testAuthenticatedAddAndDeletePoliticalParty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/political_parties/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\": \"Nowa Partia\",\n" +
                                "    \"address_id\": 3\n" +
                                "}"))
                .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/political_parties/delete/7"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testUnauthenticatedUpdatePoliticalParty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/political_parties/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\": \"Nowa Partia\",\n" +
                                "    \"address_id\": 1\n" +
                                "}"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testAuthenticatedUpdatePoliticalParty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/political_parties/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\": \"Nowa Partia\",\n" +
                                "    \"address_id\": 3\n" +
                                "}"))
                .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.put("/api/political_parties/update/6")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\": \"Nowa Partia2\",\n" +
                                "    \"address_id\": 3\n" +
                                "}"))
                .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/political_parties/6"))
                .andExpect(jsonPath("$.name").value("Nowa Partia2")).andExpect(jsonPath("$.address_id").value(3));
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/political_parties/delete/6"));
    }


}
