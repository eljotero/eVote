package org.evote.backend.integration;

import org.evote.backend.BackendApplication;
import org.evote.backend.services.CandidateService;
import org.evote.backend.services.ElectionService;
import org.evote.backend.votes.candidate.dtos.CandidateCreateDTO;
import org.evote.backend.votes.candidate.dtos.CandidateDTO;
import org.evote.backend.votes.election.dtos.ElectionCreateDTO;
import org.evote.backend.votes.election.dtos.ElectionDTO;
import org.evote.backend.votes.enums.ElectionType;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.specification.ProxySpecification.port;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BackendApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EletionControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private ElectionService electionService;

    private List<Integer> createdElections = new ArrayList<>();

    private static final String BASE_PATH = "/api/elections";

    @BeforeEach
    public void setup() {
        baseURI = "http://localhost";
        port(port);
    }

    @AfterEach
    public void tearDown() {
        createdElections.forEach(electionId-> electionService.deleteElection(electionId));
        createdElections.clear();
    }

    @Test
    public void testGetAllElections() {
        given().port(port).when().get(BASE_PATH + "/all").then().statusCode(200);
    }

    @Test
    public void testGetUpcomingElections() {

        ElectionDTO electionDTO = given().port(port).contentType("application/json").body(createExampleElectionCreateDTO())
                .when().post(BASE_PATH + "/add")
                .then().statusCode(200).extract().as(ElectionDTO.class);

        createdElections.add(electionDTO.getElection_id());

        List<ElectionDTO> upcomingElections =  given().port(port).when().get(BASE_PATH + "/upcoming")
                .then().statusCode(200)
                .extract().jsonPath().getList("", ElectionDTO.class);

        Assertions.assertNotNull(upcomingElections);
    }



    @Test
    public void addElection() {

        ElectionDTO electionDTO = given().port(port).contentType("application/json").body(createExampleElectionCreateDTO())
                .when().post(BASE_PATH + "/add")
                .then().statusCode(200).extract().as(ElectionDTO.class);

        createdElections.add(electionDTO.getElection_id());

        Assertions.assertNotNull(electionDTO);
    }

    @Test
    public void addElectionThatAlreadyExists() {
        ElectionCreateDTO electionCreateDTO = createExampleElectionCreateDTO();

        ElectionDTO electionDTO = given().port(port).contentType("application/json").body(electionCreateDTO)
                .when().post(BASE_PATH + "/add")
                .then().statusCode(200).extract().as(ElectionDTO.class);

        createdElections.add(electionDTO.getElection_id());

        given().port(port).contentType("application/json").body(electionCreateDTO)
                .when().post(BASE_PATH + "/add")
                .then().statusCode(409);
    }



    public ElectionCreateDTO createExampleElectionCreateDTO() {
        ElectionCreateDTO electionCreateDTO = new ElectionCreateDTO();
        electionCreateDTO.setElection_name("Election Name");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2025);
        calendar.set(Calendar.MONTH, Calendar.JULY);
        calendar.set(Calendar.DAY_OF_MONTH, 24);
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date startDate = calendar.getTime();

        calendar.set(Calendar.YEAR, 2025);
        calendar.set(Calendar.MONTH, Calendar.JULY);
        calendar.set(Calendar.DAY_OF_MONTH, 24);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date endDate = calendar.getTime();



        electionCreateDTO.setStartDate(startDate);
        electionCreateDTO.setEndDate(endDate);
        electionCreateDTO.setType(ElectionType.Presidential);
        return electionCreateDTO;
    }


}
