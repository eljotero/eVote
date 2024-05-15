package org.evote.backend.integration;


import org.evote.backend.BackendApplication;
import org.evote.backend.services.AccountService;
import org.evote.backend.users.account.dtos.AccountCreateDTO;
import org.evote.backend.users.account.dtos.AccountDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.specification.ProxySpecification.port;

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
        baseURI = "http://localhost";
        port(port);
    }

    @AfterEach
    public void tearDown() {
        createdAccounts.forEach(accountId -> accountService.deleteAccount(accountId));
        createdAccounts.clear();
    }

    @Test
    public void testGetAllAccountsReturn200() {
        given().port(port).when().get(BASE_PATH + "/all").then().statusCode(200);
    }

    @Test
    public void testAddAccountReturn201() {
        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
        accountCreateDTO.setEmail("test@test.com");
        accountCreateDTO.setPassword("password1234");

        Integer createdAccountId = given().port(port).contentType("application/json").body(accountCreateDTO).when().post(BASE_PATH + "/add").then().statusCode(201).extract().path("id");
        createdAccounts.add(createdAccountId);
    }

    @Test
    public void testAddAlreadyExistingAccount() {
        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
        accountCreateDTO.setEmail("test@test.com");
        accountCreateDTO.setPassword("password1234");

        Integer createdAccountId = given().port(port).contentType("application/json").body(accountCreateDTO).when().post(BASE_PATH + "/add").then().statusCode(201).extract().path("id");
        createdAccounts.add(createdAccountId);

        AccountCreateDTO accountCreateDTO2 = new AccountCreateDTO();
        accountCreateDTO2.setEmail("test@test.com");
        accountCreateDTO2.setPassword("password1234");

        given().port(port).contentType("application/json").body(accountCreateDTO2).when().post(BASE_PATH + "/add").then().statusCode(409);
    }

    @Test
    public void testGetAccountById() {
        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
        accountCreateDTO.setEmail("test@test.com");
        accountCreateDTO.setPassword("password1234");

        Integer createdAccountId = given().port(port).contentType("application/json").body(accountCreateDTO).when().post(BASE_PATH + "/add").then().statusCode(201).extract().path("id");
        createdAccounts.add(createdAccountId);

        AccountDTO accountDTO = given().port(port).when().get(BASE_PATH + "/" + createdAccountId).then().statusCode(200).extract().as(AccountDTO.class);

        Assertions.assertEquals(accountCreateDTO.getEmail(), accountDTO.getEmail());
        Assertions.assertEquals(accountCreateDTO.getRole(), accountDTO.getRole());
        Assertions.assertEquals(accountCreateDTO.getHasVoted(), accountDTO.getHasVoted());
    }


    @Test
    public void testGetByIdNonExistentAccount() {
        given().port(port).when().get("http://localhost:" + port + "/api/account/999999").then().statusCode(404);
    }

}
