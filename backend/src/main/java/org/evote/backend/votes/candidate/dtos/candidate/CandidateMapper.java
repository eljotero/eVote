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

        if (candidate.getPrecinct() != null) {
            candidateDTO.setPrecinct_id(candidate.getPrecinct().getPrecinct_id());
        }
        if (candidate.getElection() != null) {
            candidateDTO.setElection_id(candidate.getElection().getElection_id());
        }
        if (candidate.getPoliticalParty() != null) {
            candidateDTO.setPolitical_party_id(candidate.getPoliticalParty().getId());
        }
        candidateDTO.setInfo(candidate.getInfo());
        candidateDTO.setImage(candidate.getImage());
        return candidateDTO;
    }
}