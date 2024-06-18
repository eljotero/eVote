package org.evote.backend.integration;


import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import org.evote.backend.BackendApplication;
import org.evote.backend.services.AccountService;
import org.evote.backend.users.account.dtos.AccountCreateDTO;
import org.evote.backend.users.account.dtos.AccountDTO;
import org.evote.backend.users.account.entity.Account;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.specification.ProxySpecification.port;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BackendApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private AccountService accountService;

    private List<Integer> createdAccounts = new ArrayList<>();

    private static final String BASE_PATH = "/api/account";

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
//        port(port);
    }

    @AfterEach
    public void tearDown() {
        createdAccounts.forEach(accountId -> accountService.deleteAccount(accountId));
        createdAccounts.clear();
    }

//
//    @Test
//    @WithMockUser(roles = "ADMIN")
//    public void testGetAllAccounts() {
//        given()
//                .when()
//                .get(BASE_PATH + "/all")
//                .then()
//                .statusCode(200)
//                .body("size()", greaterThan(0));
//    }
//
//
//    @Test
//    @WithMockUser(roles = "ADMIN")
//    public void testAddAccountReturn201() {
//        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
//        accountCreateDTO.setEmail("test@test.com");
//        accountCreateDTO.setPassword("password1234");
//
//        Integer createdAccountId = given().port(port).contentType("application/json").body(accountCreateDTO).when().post(BASE_PATH + "/add").then().statusCode(201).extract().path("id");
//        createdAccounts.add(createdAccountId);
//    }
//
//    @Test
//    @WithMockUser(roles = "ADMIN")
//    public void testAddAlreadyExistingAccount() {
//        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
//        accountCreateDTO.setEmail("test@test.com");
//        accountCreateDTO.setPassword("password1234");
//
//        Integer createdAccountId = given().port(port).contentType("application/json").body(accountCreateDTO).when().post(BASE_PATH + "/add").then().statusCode(201).extract().path("id");
//        createdAccounts.add(createdAccountId);
//
//        AccountCreateDTO accountCreateDTO2 = new AccountCreateDTO();
//        accountCreateDTO2.setEmail("test@test.com");
//        accountCreateDTO2.setPassword("password1234");
//
//        given().port(port).contentType("application/json").body(accountCreateDTO2).when().post(BASE_PATH + "/add").then().statusCode(409);
//    }
//
//    @Test
//    @WithMockUser(roles = "ADMIN")
//    public void testGetAccountById() {
//        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
//        accountCreateDTO.setEmail("test@test.com");
//        accountCreateDTO.setPassword("password1234");
//
//        Integer createdAccountId = given().port(port).contentType("application/json").body(accountCreateDTO).when().post(BASE_PATH + "/add").then().statusCode(201).extract().path("id");
//        createdAccounts.add(createdAccountId);
//
//        AccountDTO accountDTO = given().port(port).when().get(BASE_PATH + "/" + createdAccountId).then().statusCode(200).extract().as(AccountDTO.class);
//
//        assertEquals(accountCreateDTO.getEmail(), accountDTO.getEmail());
//        assertEquals(accountCreateDTO.getRole(), accountDTO.getRole());
//        assertEquals(accountCreateDTO.getHasVoted(), accountDTO.getHasVoted());
//    }
//
//    @Test
//    @WithMockUser(roles = "ADMIN")
//    public void testDeleteAccountById() {
//        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
//        accountCreateDTO.setEmail("test@test.com");
//        accountCreateDTO.setPassword("password1234");
//
//        Integer createdAccountId = given().port(port).contentType("application/json").body(accountCreateDTO).when().post(BASE_PATH + "/add").then().statusCode(201).extract().path("id");
//        createdAccounts.add(createdAccountId);
//        given()
//                .when()
//                .delete(BASE_PATH + "/delete/" + createdAccountId)
//                .then()
//                .statusCode(204);
//    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testGetByIdNonExistentAccount() {
        given().port(port).when().get("http://localhost:" + port + "/api/account/999999").then().statusCode(400);
    }

}
