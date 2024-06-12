package org.evote.backend.unit.controllers;

import org.evote.backend.controllers.PoliticalPartyController;
import org.evote.backend.services.PoliticalPartyService;
import org.evote.backend.votes.address.entity.Address;
import org.evote.backend.votes.political_party.dtos.PoliticalPartyCreateDTO;
import org.evote.backend.votes.political_party.dtos.PoliticalPartyDTO;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.when;

public class PoliticalPartyControllerTests {

    @Mock
    private PoliticalPartyService politicalPartyService;

    @InjectMocks
    private PoliticalPartyController politicalPartyController;

    private List<PoliticalParty> politicalParties;

    @BeforeEach
    public void setup() {
        PoliticalParty politicalParty1 = new PoliticalParty();
        PoliticalParty politicalParty2 = new PoliticalParty();
        Address address1 = new Address();
        Address address2 = new Address();

        address1.setCity("City 1");
        address1.setCountry("Country 1");
        address1.setAddress_line("Street 1");
        address1.setZip_code("Zip Code 1");
        politicalParty1.setPoliticalPartyId(1);
        politicalParty1.setName("Political Party 1");
        politicalParty1.setAddress(address1);

        address2.setCity("City 2");
        address2.setCountry("Country 2");
        address2.setAddress_line("Street 2");
        address2.setZip_code("Zip Code 2");
        politicalParty2.setPoliticalPartyId(2);
        politicalParty2.setName("Political Party 2");
        politicalParty2.setAddress(address2);

        politicalParties = Arrays.asList(politicalParty1, politicalParty2);
    }

    @Test
    public void testGetAllPoliticalParties() {
        when(politicalPartyService.getAllPoliticalParties()).thenReturn(politicalParties);

        ResponseEntity<List<PoliticalPartyDTO>> response = politicalPartyController.getAllPoliticalParties();

        Assertions.assertEquals(response.getStatusCode().value(), 200);
        Assertions.assertEquals(Objects.requireNonNull(response.getBody()).size(), 2);

    }

    @Test
    public void testGetPoliticalPartyById() {
        Integer id = 1;
        when(politicalPartyService.getPoliticalPartyById(id)).thenReturn(politicalParties.get(0));

        ResponseEntity<PoliticalPartyDTO> response = politicalPartyController.getPoliticalPartyById(id);

        Assertions.assertEquals(response.getStatusCode().value(), 200);
        Assertions.assertEquals(Objects.requireNonNull(response.getBody()).getName(), "Political Party 1");
    }

    @Test
    public void testDeletePoliticalParty() {
        Integer id = 1;
        ResponseEntity<Void> response = politicalPartyController.deletePoliticalParty(id);
        Assertions.assertNull(response.getBody());
    }

    @Test
    public void testAddPoliticalParty() {
        PoliticalPartyCreateDTO politicalPartyCreateDTO = new PoliticalPartyCreateDTO();
        politicalPartyCreateDTO.setName("Political Party 1");
        politicalPartyCreateDTO.setAddress_id(1);

        when(politicalPartyService.addPoliticalParty(politicalPartyCreateDTO)).thenReturn(politicalParties.get(0));

        ResponseEntity<PoliticalPartyDTO> response = politicalPartyController.addPoliticalParty(politicalPartyCreateDTO);

        Assertions.assertEquals(response.getStatusCode().value(), 200);
        Assertions.assertEquals(Objects.requireNonNull(response.getBody()).getName(), "Political Party 1");
    }
}