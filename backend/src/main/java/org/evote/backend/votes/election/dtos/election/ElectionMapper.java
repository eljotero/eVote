package org.evote.backend.votes.election.dtos.election;

import org.evote.backend.votes.election.entity.Election;

public class ElectionMapper {

    public static ElectionDTO toElectionDTO(Election election) {
        ElectionDTO electionDTO = new ElectionDTO();
        if (election.getElection_id() != null) {
            electionDTO.setElection_id(Math.toIntExact(election.getElection_id()));
        }
        electionDTO.setElection_name(election.getElection_name());
        electionDTO.setStartDate(election.getStartDate());
        electionDTO.setEndDate(election.getEndDate());
        //electionDTO.setType(election.getType().name());
        if (election.getCandidate() != null) {
            electionDTO.setCandidate_id(election.getCandidate().getCandidate_id());
        }

        return electionDTO;
    }

}