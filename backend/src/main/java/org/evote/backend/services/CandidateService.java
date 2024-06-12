package org.evote.backend.services;

import org.evote.backend.votes.candidate.dtos.CandidateCreateDTO;
import org.evote.backend.votes.candidate.dtos.CandidateMapper;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.evote.backend.votes.candidate.exception.CandidateAlreadyExistsException;
import org.evote.backend.votes.candidate.exception.CandidateNotFoundException;
import org.evote.backend.votes.candidate.repository.CandidateRepository;
import org.evote.backend.votes.election.entity.Election;
import org.evote.backend.votes.election.exception.ElectionNotFoundException;
import org.evote.backend.votes.election.repository.ElectionRepository;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.evote.backend.votes.political_party.exception.PoliticalPartyNotFoundException;
import org.evote.backend.votes.political_party.repository.PoliticalPartyRepository;
import org.evote.backend.votes.precinct.entity.Precinct;
import org.evote.backend.votes.precinct.exception.PrecinctNotFoundException;
import org.evote.backend.votes.precinct.repository.VotesPrecinctRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private PoliticalPartyRepository politicalPartyRepository;
    @Autowired
    private ElectionRepository electionRepository;
    @Autowired
    private VotesPrecinctRepository precinctRepository;

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public List<Candidate> getCandidatesByElectionIdAndPrecinctId(int electionId, int precinctId) {
        return candidateRepository.findAll().stream()
                .filter(candidate -> candidate.getElection().getElectionId() == electionId && candidate.getPrecinct().getPrecinct_id() == precinctId)
                .collect(Collectors.toList());
    }

    public List<Candidate> getCandidatesByPoliticalPartyId(int politicalPartyId) {
        return candidateRepository.findAll().stream()
                .filter(candidate -> candidate.getPoliticalParty().getPoliticalPartyId() == politicalPartyId)
                .collect(Collectors.toList());
    }

    public Candidate getCandidateById(Integer id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("Candidate with id " + id + " not found"));
    }

    @Transactional
    public Candidate addCandidate(CandidateCreateDTO candidateCreateDTO) {
        if (candidateRepository.findByNameAndSurnameAndBirthDateAndEducation(
                candidateCreateDTO.getName(),
                candidateCreateDTO.getSurname(),
                candidateCreateDTO.getBirthDate(),
                candidateCreateDTO.getEducation()) != null) {
            throw new CandidateAlreadyExistsException("Candidate already exists");
        }
        PoliticalParty politicalParty = politicalPartyRepository.findById(candidateCreateDTO.getPolitical_party_id())
                .orElseThrow(() -> new PoliticalPartyNotFoundException("Political party with id " + candidateCreateDTO.getPolitical_party_id() + " not found"));
        Precinct precinct = precinctRepository.findById(candidateCreateDTO.getPrecinct_id())
                .orElseThrow(() -> new PrecinctNotFoundException("Precinct with id " + candidateCreateDTO.getPrecinct_id() + " not found"));
        Election election = electionRepository.findById(candidateCreateDTO.getElection_id())
                .orElseThrow(() -> new ElectionNotFoundException("Election with id " + candidateCreateDTO.getElection_id() + " not found"));

        Candidate candidate = CandidateMapper.toCandidate(candidateCreateDTO);
        candidate.setPoliticalParty(politicalParty);
        candidate.setPrecinct(precinct);
        candidate.setElection(election);

        return candidateRepository.save(candidate);
    }

    @Transactional
    public void deleteCandidate(Integer id) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("Candidate with id " + id + " not found"));
        candidateRepository.delete(candidate);
    }

    @Transactional
    public Candidate updateCandidate(Integer id, CandidateCreateDTO candidateNewInfo) {
        Candidate candidateToUpdate = candidateRepository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("Candidate with id " + id + " not found"));
        PoliticalParty politicalParty = politicalPartyRepository.findById(candidateNewInfo.getPolitical_party_id())
                .orElseThrow(() -> new PoliticalPartyNotFoundException("Political party with id " + candidateNewInfo.getPolitical_party_id() + " not found"));
        Precinct precinct = precinctRepository.findById(candidateNewInfo.getPrecinct_id())
                .orElseThrow(() -> new PrecinctNotFoundException("Precinct with id " + candidateNewInfo.getPrecinct_id() + " not found"));
        Election election = electionRepository.findById(candidateNewInfo.getElection_id())
                .orElseThrow(() -> new ElectionNotFoundException("Election with id " + candidateNewInfo.getElection_id() + " not found"));

        candidateToUpdate.setCandidateId(candidateToUpdate.getCandidateId());
        candidateToUpdate.setPoliticalParty(politicalParty);
        candidateToUpdate.setPrecinct(precinct);
        candidateToUpdate.setElection(election);
        candidateToUpdate.setName(candidateNewInfo.getName());
        candidateToUpdate.setSurname(candidateNewInfo.getSurname());
        candidateToUpdate.setBirthDate(candidateNewInfo.getBirthDate());
        candidateToUpdate.setEducation(candidateNewInfo.getEducation());
        candidateToUpdate.setProfession(candidateNewInfo.getProfession());
        candidateToUpdate.setInfo(candidateNewInfo.getInfo());
        candidateToUpdate.setImage(candidateNewInfo.getImage());

        return candidateRepository.save(candidateToUpdate);
    }
}