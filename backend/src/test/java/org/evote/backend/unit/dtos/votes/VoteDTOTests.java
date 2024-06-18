package org.evote.backend.unit.dtos.votes;

import org.evote.backend.votes.enums.CityType;
import org.evote.backend.votes.vote.dtos.SingleVoteDTO;
import org.evote.backend.votes.vote.dtos.SubmitVoteDTO;
import org.evote.backend.votes.vote.dtos.VoteDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoteDTOTests {
    @Test
    public void testSingleVoteGettersAndSetters() {
        SingleVoteDTO singleVoteDTO = new SingleVoteDTO();

        Integer candidateId = 1;
        Integer electionId = 1;

        singleVoteDTO.setCandidateId(candidateId);
        singleVoteDTO.setElectionId(electionId);

        assertEquals(candidateId, singleVoteDTO.getCandidateId());
        assertEquals(electionId, singleVoteDTO.getElectionId());
    }

    @Test
    public void testSubmitVoteGettersAndSetters() {
        SubmitVoteDTO submitVoteDTO = new SubmitVoteDTO();

        Date voterBirthDate = new Date();
        CityType voterCityType = CityType.BELOWFIFTYTHOUSAND;
        String voterEducation = "Bachelor";
        String voterCountry = "Country";
        Integer candidateId = 1;

        submitVoteDTO.setVoterBirthDate(voterBirthDate);
        submitVoteDTO.setVoterCityType(voterCityType);
        submitVoteDTO.setVoterEducation(voterEducation);
        submitVoteDTO.setVoterCountry(voterCountry);
        submitVoteDTO.setCandidateId(candidateId);

        assertEquals(voterBirthDate, submitVoteDTO.getVoterBirthDate());
        assertEquals(voterCityType, submitVoteDTO.getVoterCityType());
        assertEquals(voterEducation, submitVoteDTO.getVoterEducation());
        assertEquals(voterCountry, submitVoteDTO.getVoterCountry());
        assertEquals(candidateId, submitVoteDTO.getCandidateId());
    }

    @Test
    public void testVoteGettersAndSetters() {
        VoteDTO voteDTO = new VoteDTO();

        List<SingleVoteDTO> votes = new ArrayList<>();
        votes.add(new SingleVoteDTO(1, 1));
        votes.add(new SingleVoteDTO(2, 1));

        voteDTO.setVotes(votes);

        assertEquals(votes, voteDTO.getVotes());
    }
}
