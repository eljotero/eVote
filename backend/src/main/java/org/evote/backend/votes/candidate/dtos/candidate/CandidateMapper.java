package org.evote.backend.votes.candidate.dtos.candidate;

import org.evote.backend.votes.candidate.entity.Candidate;

public class CandidateMapper {

    public static Candidate toCandidate(CandidateCreateDTO candidateCreateDTO) {
        Candidate candidate = new Candidate();
        candidate.setName(candidateCreateDTO.getName());
        candidate.setSurname(candidateCreateDTO.getSurname());
        candidate.setBirthDate(candidateCreateDTO.getBirthDate());
        candidate.setEducation(candidateCreateDTO.getEducation());
        candidate.setProfession(candidateCreateDTO.getProfession());
        candidate.setInfo(candidateCreateDTO.getInfo());
        candidate.setImage(candidateCreateDTO.getImage());
        return candidate;
    }

    public static CandidateDTO toCandidateDTO(Candidate candidate) {
        CandidateDTO candidateDTO = new CandidateDTO();
        candidateDTO.setCandidate_id(candidate.getCandidateId());
        candidateDTO.setName(candidate.getName());
        candidateDTO.setSurname(candidate.getSurname());
        candidateDTO.setBirthDate(candidate.getBirthDate());
        candidateDTO.setEducation(candidate.getEducation());
        candidateDTO.setProfession(candidate.getProfession());
        candidateDTO.setPolitical_party_id(candidate.getPoliticalParty().getId());
        candidateDTO.setPrecinct_id(candidate.getPrecinct().getPrecinct_id());
        candidateDTO.setElection_id(candidate.getElection().getElectionId());
        candidateDTO.setInfo(candidate.getInfo());
        candidateDTO.setImage(candidate.getImage());
        return candidateDTO;

    }
}