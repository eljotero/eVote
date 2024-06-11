package org.evote.backend.unit.controllers;

import org.evote.backend.config.JwtService;
import org.evote.backend.controllers.VotingController;
import org.evote.backend.services.AccountService;
import org.evote.backend.services.VotingService;
import org.evote.backend.users.account.dtos.VotingCodeDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class VotingControllerTests {

    @Mock
    private JwtService jwtService;

    @Mock
    private AccountService accountService;

    @Mock
    private VotingService votingService;

    @InjectMocks
    private VotingController votingController;

    private VotingCodeDTO votingCodeDTO;
    private int id;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        id = 1;
        votingCodeDTO = new VotingCodeDTO();
        votingCodeDTO.setCode("validCode");
    }

    @Test
    public void testVoteValidCode() {
        when(votingService.verifyCode(id, votingCodeDTO.getCode())).thenReturn(true);
        when(votingService.generateVotingToken(id)).thenReturn("newVotingToken");

        ResponseEntity<String> response = votingController.vote(id, votingCodeDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("newVotingToken", response.getBody());
    }

    @Test
    public void testVoteInvalidCode() {
        when(votingService.verifyCode(id, votingCodeDTO.getCode())).thenReturn(false);

        ResponseEntity<String> response = votingController.vote(id, votingCodeDTO);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals("Invalid code", response.getBody());
    }
}
