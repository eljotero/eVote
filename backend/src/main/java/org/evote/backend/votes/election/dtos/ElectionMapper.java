package org.evote.backend.votes.election.dtos;

import org.evote.backend.votes.election.entity.Election;

public class ElectionMapper {

    public static ElectionDTO toElectionDTO(Election election) {
        ElectionDTO electionDTO = new ElectionDTO();
        electionDTO.setElection_id(election.getElectionId());
        electionDTO.setElection_name(election.getElectionName());
        electionDTO.setStartDate(election.getStartDate());
        electionDTO.setEndDate(election.getEndDate());
        electionDTO.setType(election.getType());
        if (election.getCandidate() != null) {
            electionDTO.setCandidate_id(election.getCandidate().getCandidateId());
        }
        return electionDTO;
    }

    public static Election toElection(ElectionCreateDTO electionCreateDTO) {
        Election election = new Election();

        election.setElectionName(electionCreateDTO.getElection_name());
        election.setStartDate(electionCreateDTO.getStartDate());
        election.setEndDate(electionCreateDTO.getEndDate());
        election.setType(electionCreateDTO.getType());

        return election;
    }
}