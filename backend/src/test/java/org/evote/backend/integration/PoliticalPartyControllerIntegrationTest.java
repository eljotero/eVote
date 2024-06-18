package org.evote.backend.integration;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import org.evote.backend.BackendApplication;
import org.evote.backend.services.PoliticalPartyService;
import org.evote.backend.votes.address.entity.Address;
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
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URL;
import java.util.*;

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

    @Autowired
    private VotesAddressRepository votesAddressRepository;

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
        Optional<Address> optionalAddress = votesAddressRepository.findById(69);
        optionalAddress.ifPresent(address -> votesAddressRepository.delete(address));
    }

    @Test
    public void testGetAllPoliticalParties() {
        given().port(port).when().get(BASE_PATH + "/all").then().statusCode(200);
    }


//    @Test
//    public void testGetPoliticalPartyById() {
//        PoliticalPartyDTO politicalPartyDTO = given().port(port).when().get(BASE_PATH + "/1").then().statusCode(200).extract().as(PoliticalPartyDTO.class);
//
//        Assertions.assertNotNull(politicalPartyDTO);
//    }

//    @Test
//    public void addPoliticalParty() {
//
//        PoliticalPartyDTO politicalPartyDTO = given().port(port).contentType("application/json").body(createExamplePoliticalPartyCreateDTO())
//                .when().post(BASE_PATH + "/add")
//                .then().statusCode(200).extract().as(PoliticalPartyDTO.class);
//
//        createdPoliticalParties.add(politicalPartyDTO.getPoliticalPartyId());
//
//        Assertions.assertNotNull(politicalPartyDTO);
//    }
//
//    @Test
//    public void addPoliticalPartyThatAlreadyExists() {
//        PoliticalPartyCreateDTO politicalPartyCreateDTO = createExamplePoliticalPartyCreateDTO();
//
//        PoliticalPartyDTO politicalPartyDTO = given().port(port).contentType("application/json").body(politicalPartyCreateDTO)
//                .when().post(BASE_PATH + "/add")
//                .then().statusCode(200).extract().as(PoliticalPartyDTO.class);
//
//        createdPoliticalParties.add(politicalPartyDTO.getPoliticalPartyId());
//
//        given().port(port).contentType("application/json").body(politicalPartyCreateDTO)
//                .when().post(BASE_PATH + "/add")
//                .then().statusCode(409);
//    }



    public PoliticalPartyCreateDTO createExamplePoliticalPartyCreateDTO() {
        Address address = new Address();
        address.setAddress_id(69);
        address.setCity("Example City");
        address.setCountry("Example Country");
        address.setZip_code("00-000");
        address.setAddress_line("Example Address Line");
        votesAddressRepository.save(address);

        PoliticalPartyCreateDTO politicalPartyCreateDTO = new PoliticalPartyCreateDTO();
        politicalPartyCreateDTO.setName("Example Political Party");
        politicalPartyCreateDTO.setAddress_id(address.getAddress_id());

        return politicalPartyCreateDTO;
    }


}
