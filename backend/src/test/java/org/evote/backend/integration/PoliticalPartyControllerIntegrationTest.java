package org.evote.backend.integration;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import org.evote.backend.BackendApplication;
import org.evote.backend.services.PoliticalPartyService;
import org.evote.backend.votes.address.repository.VotesAddressRepository;
import org.evote.backend.votes.political_party.dtos.PoliticalPartyCreateDTO;
import org.evote.backend.votes.political_party.dtos.PoliticalPartyDTO;
import org.glassfish.jaxb.core.v2.TODO;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.specification.ProxySpecification.port;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BackendApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PoliticalPartyControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private PoliticalPartyService politicalPartyService;

    private List<Integer> createdPoliticalParties = new ArrayList<>();

    private static final String BASE_PATH = "/api/political_parties";

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
        createdPoliticalParties.forEach(politicalPartyId-> politicalPartyService.deletePoliticalParty(politicalPartyId));
        createdPoliticalParties.clear();
    }

    @Test
    public void testGetAllPoliticalParties() {
        given().port(port).when().get(BASE_PATH + "/all").then().statusCode(200);
    }


    //TODO: ZMODYFIKOWAĆ TESTY TAK ŻEBY w BEFORE EACH TWORZONY BYŁ NOWY ADRES, NAJLEPIEJ Z ID W DZIESIĄTKACH
    //TODO: NIE ZAPOMNIEĆ O USUWANIU GO Z BAZY W AFTER EACH
/*    @Test
    public void testGetPoliticalPartyById() {
        PoliticalPartyDTO politicalPartyDTO = given().port(port).when().get(BASE_PATH + "/1").then().statusCode(200).extract().as(PoliticalPartyDTO.class);

        Assertions.assertNotNull(politicalPartyDTO);
    }

    @Test
    public void addPoliticalParty() {

        PoliticalPartyDTO politicalPartyDTO = given().port(port).contentType("application/json").body(createExamplePoliticalPartyCreateDTO())
                .when().post(BASE_PATH + "/add")
                .then().statusCode(200).extract().as(PoliticalPartyDTO.class);

        createdPoliticalParties.add(politicalPartyDTO.getPoliticalPartyId());

        Assertions.assertNotNull(politicalPartyDTO);
    }

    @Test
    public void addPoliticalPartyThatAlreadyExists() {
        PoliticalPartyCreateDTO politicalPartyCreateDTO = createExamplePoliticalPartyCreateDTO();

        PoliticalPartyDTO politicalPartyDTO = given().port(port).contentType("application/json").body(politicalPartyCreateDTO)
                .when().post(BASE_PATH + "/add")
                .then().statusCode(200).extract().as(PoliticalPartyDTO.class);

        createdPoliticalParties.add(politicalPartyDTO.getPoliticalPartyId());

        given().port(port).contentType("application/json").body(politicalPartyCreateDTO)
                .when().post(BASE_PATH + "/add")
                .then().statusCode(409);
    }*/



    public PoliticalPartyCreateDTO createExamplePoliticalPartyCreateDTO() {
        PoliticalPartyCreateDTO politicalPartyCreateDTO = new PoliticalPartyCreateDTO();

        politicalPartyCreateDTO.setName("Example Political Party");
        politicalPartyCreateDTO.setAddress_id(50);

        return politicalPartyCreateDTO;
    }


}
