package org.evote.backend.votes.candidate.dtos.candidate;

import org.evote.backend.votes.candidate.entity.Candidate;

public class CandidateMapper {
    public static CandidateCreateDTO toCandidateCreateDTO(Candidate candidate) {
        CandidateCreateDTO candidateDTO = new CandidateCreateDTO();
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

    public static Candidate toCandidate(CandidateCreateDTO candidateCreateDTO) {
        Candidate candidate = new Candidate();
        candidate.setName(candidateCreateDTO.getName());
        candidate.setSurname(candidateCreateDTO.getSurname());
        candidate.setBirthDate(candidateCreateDTO.getBirthDate());
        candidate.setEducation(candidateCreateDTO.getEducation());
        candidate.setProfession(candidateCreateDTO.getProfession());
        candidate.setInfo(candidateCreateDTO.getInfo());
        candidate.setImage(candidateCreateDTO.getImage());
        candidate.setPrecinct_id(candidateCreateDTO.getPrecinct_id());
        candidate.setElection_id(candidateCreateDTO.getElection_id());
        candidate.setPolitical_party_id(candidateCreateDTO.getPolitical_party_id());
        return candidate;
    }

    public static CandidateDTO toCandidateDTO(Candidate candidate) {
        CandidateDTO candidateDTO = new CandidateDTO();
        candidateDTO.setCandidate_id(candidate.getCandidate_id());
        candidateDTO.setName(candidate.getName());
        candidateDTO.setSurname(candidate.getSurname());
        candidateDTO.setBirthDate(candidate.getBirthDate());
        candidateDTO.setEducation(candidate.getEducation());
        candidateDTO.setProfession(candidate.getProfession());
        candidateDTO.setInfo(candidate.getInfo());
        candidateDTO.setImage(candidate.getImage());
        return candidateDTO;

    }
}