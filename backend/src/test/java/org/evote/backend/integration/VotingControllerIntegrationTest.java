package org.evote.backend.integration;

import org.evote.backend.BackendApplication;
import org.evote.backend.services.AccountService;
import org.evote.backend.services.VotingService;
import org.evote.backend.users.account.dtos.AccountCreateDTO;
import org.evote.backend.users.account.dtos.VotingCodeDTO;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.*;
import static io.restassured.specification.ProxySpecification.port;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BackendApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VotingControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserRepository userRepository;

    private static final String BASE_PATH = "/api/vote";

    private Integer accountId;
    private String token;

    @BeforeEach
    public void setup() {
        baseURI = "http://localhost";
        port(port);
        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
        accountCreateDTO.setEmail("test@test.com");
        accountCreateDTO.setPassword("password1234");
        accountId = given()
                .port(port)
                .contentType("application/json")
                .body(accountCreateDTO)
                .when()
                .post("api/auth/register")
                .then()
                .statusCode(201)
                .extract()
                .path("id");


        token = given()
                .port(port)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(accountCreateDTO)
                .when()
                .post("api/auth/login")
                .then()
                .statusCode(200)
                .extract()
                .path("token");

        Account account = accountService.getAccountById(accountId);
        User user = account.getUser();
        user.setCode("123456");
        userRepository.save(user);
    }

    @AfterEach
    public void tearDown() {
        accountService.deleteAccount(accountId);
    }

    @Test
    public void testVoteWithValidCode() {
        VotingCodeDTO votingCodeDTO = new VotingCodeDTO();
        votingCodeDTO.setCode("123456");

        given()
                .port(port)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("Authorization", "Bearer " + token)
                .body(votingCodeDTO)
                .when()
                .post(BASE_PATH + "/" + accountId)
                .then()
                .statusCode(200)
                .body(not(empty()));
    }


    @Test
    public void testVoteWithInvalidCode() {
        VotingCodeDTO votingCodeDTO = new VotingCodeDTO();
        votingCodeDTO.setCode("invalid_code");

        given()
                .port(port)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("Authorization", "Bearer " + token)
                .body(votingCodeDTO)
                .when()
                .post(BASE_PATH + "/" + accountId)
                .then()
                .statusCode(401)
                .body(equalTo("Invalid code"));
    }
}
