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
public class ElectionControllerIntegrationTest {

    private final MockMvc mockMvc;

    @LocalServerPort
    private int port;

    @Autowired
    public ElectionControllerIntegrationTest(MockMvc mockMvc) {
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
    public void testGetAllElections() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/elections/all"))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void testGetUpcomingElections() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/elections/upcoming"))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void testUnauthenticatedAddElection() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/elections/add").contentType(MediaType.APPLICATION_JSON).content(
                        "{\n" +
                                "    \"name\": \"Election 3\",\n" +
                                "    \"startDate\": \"2025-01-01T00:00:00\",\n" +
                                "    \"endDate\": \"2025-01-02T00:00:00\",\n" +
                                "    \"type\": \"Presidential\"\n" +
                                "}"
                ))
                .andExpect(status().isForbidden());
    }


    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testAddAndDeleteElection() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/elections/add").contentType(MediaType.APPLICATION_JSON).content(
                        "{\n" +
                                "    \"name\": \"Election 3\",\n" +
                                "    \"startDate\": \"2025-01-01T00:00:00\",\n" +
                                "    \"endDate\": \"2025-01-02T00:00:00\",\n" +
                                "    \"type\": \"Presidential\"\n" +
                                "}"
                ))
                .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/elections/delete/9"))
                .andExpect(status().isOk());
    }


}
