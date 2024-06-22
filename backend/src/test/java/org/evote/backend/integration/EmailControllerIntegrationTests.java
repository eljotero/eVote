package org.evote.backend.integration;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import org.evote.backend.BackendApplication;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URL;

import static io.restassured.RestAssured.baseURI;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BackendApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EmailControllerIntegrationTests {

    private final MockMvc mockMvc;

    @LocalServerPort
    private int port;

    @Autowired
    public EmailControllerIntegrationTests(MockMvc mockMvc) {
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
    public void testUnauthenticatedSendEmail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/email/sendEmail"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testLoginAndGetToken() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"test1500@mail.com\",\"password\":\"password123\"}"))
                .andExpect(status().isCreated())
                .andReturn();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"test1500@mail.com\",\"password\":\"password123\"}")).andReturn();
        String content = result.getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(content);
        String token = jsonObject.getString("token");
        mockMvc.perform(MockMvcRequestBuilders.put("/api/user/2")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"Test\",\n" +
                        "    \"surname\": \"Test\",\n" +
                        "    \"personalIdNumber\": 123456789,\n" +
                        "    \"sex\": true,\n" +
                        "    \"birthDate\": \"2021-01-01T00:00:00\",\n" +
                        "    \"education\": \"PRIMARY\",\n" +
                        "    \"cityType\": \"OVER500THOUSAND\",\n" +
                        "    \"profession\": \"Test\",\n" +
                        "    \"zip_code\": \"00-000\",\n" +
                        "    \"city\": \"Test\",\n" +
                        "    \"voivodeship\": \"Test\",\n" +
                        "    \"country\": \"Test\",\n" +
                        "    \"address_line\": \"Test\"\n" +
                        "}")
        ).andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/email/sendEmail")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }
}
