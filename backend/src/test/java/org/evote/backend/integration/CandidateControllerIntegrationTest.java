package org.evote.backend.integration;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import org.evote.backend.BackendApplication;
import org.evote.backend.services.CandidateService;
import org.evote.backend.votes.candidate.dtos.CandidateCreateDTO;
import org.evote.backend.votes.candidate.dtos.CandidateDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.specification.ProxySpecification.port;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BackendApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CandidateControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private CandidateService candidateService;

    private List<Integer> createdCandidates = new ArrayList<>();

    private static final String BASE_PATH = "/api/candidates";

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
        port(port);
    }

    @AfterEach
    public void tearDown() {
        createdCandidates.forEach(candidateId -> candidateService.deleteCandidate(candidateId));
        createdCandidates.clear();
    }


    @Test
    public void testGetAllCandidates() {
        given().port(port).when().get(BASE_PATH + "/all").then().statusCode(200);
    }

//    @Test
//    public void addCandidate() {
//
//        CandidateDTO candidateDTO = given().port(port).contentType("application/json").body(createExampleCandidateCreateDTO())
//                .when().post(BASE_PATH + "/add")
//                .then().statusCode(201).extract().as(CandidateDTO.class);
//
//        createdCandidates.add(candidateDTO.getCandidate_id());
//
//        Assertions.assertNotNull(candidateDTO);
//
//    }

//    @Test
//    public void addCandidateThatAlreadyExists() {
//        CandidateCreateDTO candidateCreateDTO = createExampleCandidateCreateDTO();
//
//        CandidateDTO candidateDTO = given().port(port).contentType("application/json").body(candidateCreateDTO)
//                .when().post(BASE_PATH + "/add")
//                .then().statusCode(201).extract().as(CandidateDTO.class);
//
//        createdCandidates.add(candidateDTO.getCandidate_id());
//
//        given().port(port).contentType("application/json").body(candidateCreateDTO)
//                .when().post(BASE_PATH + "/add")
//                .then().statusCode(400);
//    }

    @Test
    public void testAddCandidateWithNonExistentPoliticalParty() {
        CandidateCreateDTO candidateCreateDTO = createExampleCandidateCreateDTO();

        candidateCreateDTO.setPolitical_party_id(9999);

        given().port(port).contentType("application/json").body(candidateCreateDTO)
                .when().post(BASE_PATH + "/add")
                .then().statusCode(400);
    }

    @Test
    public void testAddCandidateWithNonExistentElection() {
        CandidateCreateDTO candidateCreateDTO = createExampleCandidateCreateDTO();

        candidateCreateDTO.setElection_id(9999);

        given().port(port).contentType("application/json").body(candidateCreateDTO)
                .when().post(BASE_PATH + "/add")
                .then().statusCode(400);
    }

    @Test
    public void testAddCandidateWithNonExistentPrecinct() {
        CandidateCreateDTO candidateCreateDTO = createExampleCandidateCreateDTO();

        candidateCreateDTO.setPrecinct_id(9999);

        given().port(port).contentType("application/json").body(candidateCreateDTO)
                .when().post(BASE_PATH + "/add")
                .then().statusCode(400);
    }

    public CandidateCreateDTO createExampleCandidateCreateDTO() {
        CandidateCreateDTO candidateCreateDTO = new CandidateCreateDTO();
        candidateCreateDTO.setName("John");
        candidateCreateDTO.setSurname("Doe");
        candidateCreateDTO.setPrecinct_id(10);
        candidateCreateDTO.setElection_id(1);
        candidateCreateDTO.setPolitical_party_id(10);
        candidateCreateDTO.setProfession("Software Engineer");
        candidateCreateDTO.setEducation("BSc Computer Science");
        candidateCreateDTO.setBirthDate(new Date());
        candidateCreateDTO.setImage("image.jpg");
        candidateCreateDTO.setInfo("I am a software engineer");
        return candidateCreateDTO;
    }

}
