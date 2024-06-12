package org.evote.backend.unit.services;

import org.evote.backend.services.PoliticalPartyService;
import org.evote.backend.votes.address.entity.Address;
import org.evote.backend.votes.address.repository.VotesAddressRepository;
import org.evote.backend.votes.political_party.dtos.PoliticalPartyCreateDTO;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.evote.backend.votes.political_party.exception.PoliticalPartyAlreadyExistsException;
import org.evote.backend.votes.political_party.repository.PoliticalPartyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PoliticalPartyServiceTests {

    @InjectMocks
    private PoliticalPartyService politicalPartyService;

    @Mock
    private PoliticalPartyRepository politicalPartyRepository;

    @Mock
    private VotesAddressRepository votesAddressRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllPoliticalParties() {
        PoliticalParty politicalParty1 = new PoliticalParty();
        PoliticalParty politicalParty2 = new PoliticalParty();
        List<PoliticalParty> politicalParties = Arrays.asList(politicalParty1, politicalParty2);

        when(politicalPartyRepository.findAll()).thenReturn(politicalParties);

        List<PoliticalParty> result = politicalPartyService.getAllPoliticalParties();

        assertEquals(politicalParties, result);
    }

    @Test
    public void testGetPoliticalPartyById() {
        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setPoliticalPartyId(1);

        when(politicalPartyRepository.findById(1)).thenReturn(java.util.Optional.of(politicalParty));

        PoliticalParty result = politicalPartyService.getPoliticalPartyById(1);

        assertEquals(politicalParty, result);
    }

    @Test
    public void testGetPoliticalPartyByName() {
        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setName("Test");

        when(politicalPartyRepository.findByName("Test")).thenReturn(politicalParty);

        PoliticalParty result = politicalPartyService.getPoliticalPartyByName("Test");

        assertEquals(politicalParty, result);
    }

    @Test
    public void testDeletePoliticalParty() {
        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setPoliticalPartyId(1);

        when(politicalPartyRepository.findById(1)).thenReturn(java.util.Optional.of(politicalParty));
        politicalPartyService.deletePoliticalParty(1);

        when(politicalPartyRepository.findById(1)).thenReturn(java.util.Optional.empty());
    }

    @Test
    public void testUpdatePoliticalParty() {
        PoliticalPartyCreateDTO politicalPartyDTO = new PoliticalPartyCreateDTO();
        politicalPartyDTO.setName("Test");
        politicalPartyDTO.setAddress_id(1);
        Address address = new Address();
        address.setAddress_id(1);
        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setPoliticalPartyId(1);
        when(politicalPartyRepository.findById(1)).thenReturn(java.util.Optional.of(politicalParty));
        when(votesAddressRepository.findById(politicalPartyDTO.getAddress_id())).thenReturn(Optional.of(address));
        when(politicalPartyRepository.save(politicalParty)).thenReturn(politicalParty);
        PoliticalParty result = politicalPartyService.updatePoliticalParty(1, politicalPartyDTO);
        assertEquals(politicalParty, result);
    }

    @Test
    public void testAddPoliticalParty() {
        PoliticalPartyCreateDTO politicalPartyDTO = new PoliticalPartyCreateDTO();
        politicalPartyDTO.setName("Test");
        politicalPartyDTO.setAddress_id(1);
        Address address = new Address();
        address.setAddress_id(1);
        when(politicalPartyRepository.findByName("Test")).thenReturn(null);
        when(votesAddressRepository.findById(politicalPartyDTO.getAddress_id())).thenReturn(Optional.of(address));
        when(politicalPartyRepository.save(any(PoliticalParty.class))).thenAnswer(i -> i.getArguments()[0]);
        PoliticalParty result = politicalPartyService.addPoliticalParty(politicalPartyDTO);
        assertEquals("Test", result.getName());
        assertEquals(address.getAddress_id(), result.getAddress().getAddress_id());
    }

    @Test
    public void testAddPoliticalPartyAlreadyExists() {
        PoliticalPartyCreateDTO politicalPartyDTO = new PoliticalPartyCreateDTO();
        politicalPartyDTO.setName("Test");
        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setName("Test");
        when(politicalPartyRepository.findByName("Test")).thenReturn(politicalParty);
        assertThrows(PoliticalPartyAlreadyExistsException.class, () -> politicalPartyService.addPoliticalParty(politicalPartyDTO));
    }
}