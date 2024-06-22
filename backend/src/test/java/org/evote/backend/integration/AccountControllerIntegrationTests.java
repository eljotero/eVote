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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URL;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BackendApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AccountControllerIntegrationTests {

    private final MockMvc mockMvc;

    @LocalServerPort
    private int port;

    @Autowired
    public AccountControllerIntegrationTests(MockMvc mockMvc) {
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
    public void testUnauthenticatedGetAllAccounts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/account/all"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testAuthenticatedGetAllAccounts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/account/all"))
                .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(greaterThan(0))));
    }


    @Test
    public void testUnauthenticatedSetAccountToInactive() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/account/delete/1"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "user", roles = {"ADMIN"})
    public void testAuthenticatedSetAccountToInactive() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/account/delete/7"))
                .andExpect(status().isNoContent());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/account/7"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUnauthenticatedGetAccountById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/account/1"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testGetAccountById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/account/5"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.email", is("test@mail.com")))
                .andExpect(jsonPath("$.name", is("Test")))
                .andExpect(jsonPath("$.surname", is("Test")))
                .andExpect(jsonPath("$.sex", is(false)))
                .andExpect(jsonPath("$.birthDate", is("1998-12-31T23:00:00.000+00:00")))
                .andExpect(jsonPath("$.education", is("VOCATIONAL")))
                .andExpect(jsonPath("$.profession", is("STUDENT")))
                .andExpect(jsonPath("$.cityType", is("OVER500THOUSAND")))
                .andExpect(jsonPath("$.personalIdNumber", is("123456789")))
                .andExpect(jsonPath("$.zipCode", is("12345")))
                .andExpect(jsonPath("$.city", is("Test")))
                .andExpect(jsonPath("$.country", is("Test")))
                .andExpect(jsonPath("$.addressLine", is("Test")))
                .andExpect(jsonPath("$.voivodeship", is("Test")));
    }

}