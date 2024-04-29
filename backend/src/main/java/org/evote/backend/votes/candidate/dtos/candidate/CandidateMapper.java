package org.evote.backend.votes.candidate.dtos.candidate;

import org.evote.backend.votes.candidate.entity.Candidate;

public class CandidateMapper {

    public static CandidateDTO toCandidateDTO(Candidate candidate) {
        CandidateDTO candidateDTO = new CandidateDTO();
        candidateDTO.setCandidate_id(candidate.getCandidate_id());
        candidateDTO.setName(candidate.getName());
        candidateDTO.setSurname(candidate.getSurname());
        candidateDTO.setBirthDate(candidate.getBirthDate());
        candidateDTO.setEducation(candidate.getEducation());
        candidateDTO.setProfession(candidate.getProfession());
        candidateDTO.setPolitical_party_id(candidate.getPoliticalParty().getId());
        candidateDTO.setPrecinct_id(candidate.getPrecinct().getId());
        candidateDTO.setElection_id(candidate.getElection().getId());

        return candidateDTO;
    }

}