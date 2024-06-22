package org.evote.backend.integration;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import org.evote.backend.BackendApplication;
import org.evote.backend.services.AccountService;
import org.evote.backend.users.account.dtos.AccountCreateDTO;
import org.evote.backend.users.account.dtos.VotingCodeDTO;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.repository.UserRepository;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URL;
import java.util.UUID;

import static io.restassured.RestAssured.*;
import static io.restassured.specification.ProxySpecification.port;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BackendApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class VotingControllerIntegrationTests {


    private final MockMvc mockMvc;

    @LocalServerPort
    private int port;


    @Autowired
    public VotingControllerIntegrationTests(MockMvc mockMvc) {
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
    public void testUnauthenticatedGenerateVotingCode() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/vote/voteToken"))
                .andExpect(status().isBadRequest());
    }
    

}
