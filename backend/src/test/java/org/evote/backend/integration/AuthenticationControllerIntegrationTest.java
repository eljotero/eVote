package org.evote.backend.integration;

import org.evote.backend.BackendApplication;
import org.evote.backend.services.AccountService;
import org.evote.backend.users.account.dtos.AccountCreateDTO;
import org.evote.backend.users.account.dtos.AccountLoginDTO;
import org.junit.jupiter.api.AfterEach;
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
public class AuthenticationControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private AccountService accountService;

    private List<Integer> createdAccounts = new ArrayList<>();

    private static final String BASE_PATH = "/api/auth";

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
    public void testRegister() {
        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
        accountCreateDTO.setEmail("test@test.com");
        accountCreateDTO.setPassword("password1234");

        Integer accountCreatedId = given().port(port).contentType("application/json").body(accountCreateDTO).when().post(BASE_PATH + "/register").then().statusCode(201).extract().path("id");
        createdAccounts.add(accountCreatedId);
    }

    @Test
    public void testRegisterPasswordToShort() {
        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
        accountCreateDTO.setEmail("test@test.com");
        accountCreateDTO.setPassword("pass");

        given().port(port).contentType("application/json").body(accountCreateDTO).when().post(BASE_PATH + "/register").then().statusCode(400);
    }

    @Test
    public void testRegisterEmailAlreadyExists() {
        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
        accountCreateDTO.setEmail("test@test.com");
        accountCreateDTO.setPassword("password1234");

        Integer accountCreatedId = given().port(port).contentType("application/json").body(accountCreateDTO).when().post(BASE_PATH + "/register").then().statusCode(201).extract().path("id");
        createdAccounts.add(accountCreatedId);

        AccountCreateDTO accountCreateDTO2 = new AccountCreateDTO();
        accountCreateDTO2.setEmail("test@test.com");
        accountCreateDTO2.setPassword("password1234");

        given().port(port).contentType("application/json").body(accountCreateDTO2).when().post(BASE_PATH + "/register").then().statusCode(409);
    }

    @Test
    public void testLogin() {
        AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
        accountCreateDTO.setEmail("test@test.com");
        accountCreateDTO.setPassword("password1234");

        Integer accountCreatedId = given().port(port).contentType("application/json").body(accountCreateDTO).when().post(BASE_PATH + "/register").then().statusCode(201).extract().path("id");
        createdAccounts.add(accountCreatedId);

        given().port(port).contentType("application/json").body(accountCreateDTO).when().post(BASE_PATH + "/login").then().statusCode(200);
    }

    @Test
    public void testLoginNotFound() {
        AccountLoginDTO accountLoginDTO = new AccountLoginDTO();
        accountLoginDTO.setEmail("test@test.com");
        accountLoginDTO.setPassword("password1234");

        given().port(port).contentType("application/json").body(accountLoginDTO).when().post(BASE_PATH + "/login").then().statusCode(404);
    }

}
