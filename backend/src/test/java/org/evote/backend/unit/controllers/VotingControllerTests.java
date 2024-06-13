package org.evote.backend.unit.controllers;

import org.evote.backend.services.JwtService;
import org.evote.backend.controllers.VotingController;
import org.evote.backend.services.AccountService;
import org.evote.backend.services.VotingService;
import org.evote.backend.users.account.dtos.VotingCodeDTO;
import org.evote.backend.votes.vote.dtos.SingleVoteDTO;
import org.evote.backend.votes.vote.dtos.VoteDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.List;

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
    public void testGenerateVotingToken() {
        when(jwtService.extractEmail("tokensssss")).thenReturn("email");
        when(votingService.generateVotingToken("email", votingCodeDTO.getCode())).thenReturn("tokensssss");
        assertEquals(HttpStatus.OK, votingController.generateVotingToken("tokensssss", votingCodeDTO).getStatusCode());
    }

    @Test
    public void testVote() {
        VoteDTO voteDTO = new VoteDTO();
        SingleVoteDTO singleVoteDTO = new SingleVoteDTO();
        voteDTO.setVotes(List.of(singleVoteDTO));
        when(jwtService.extractEmail("tokensssss")).thenReturn("email");
        when(votingService.vote("email", voteDTO)).thenReturn("Voted");
        assertEquals(HttpStatus.OK, votingController.vote("tokensssss", voteDTO).getStatusCode());
    }
}
