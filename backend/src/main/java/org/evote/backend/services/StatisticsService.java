package org.evote.backend.services;

import lombok.RequiredArgsConstructor;
import org.evote.backend.votes.election.exception.ElectionNotFoundException;
import org.evote.backend.votes.election.repository.ElectionRepository;
import org.evote.backend.votes.enums.CityType;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.evote.backend.votes.vote.entity.Vote;
import org.evote.backend.votes.vote.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final VoteRepository voteRepository;

    private final ElectionRepository electionRepository;

    public Map<String, Integer> getResults(Integer electionId) {
        if (electionRepository.findById(electionId).isEmpty()) {
            throw new ElectionNotFoundException("Election with id " + electionId + " not found");
        }
        List<Vote> votes = voteRepository.findAll();
        Map<String, Integer> partyVotes = new HashMap<>();
        for (Vote vote : votes) {
            if (vote.getCandidate().getElection().getElectionId().equals(electionId)) {
                PoliticalParty party = vote.getCandidate().getPoliticalParty();
                if (partyVotes.containsKey(party.getName())) {
                    partyVotes.put(party.getName(), partyVotes.get(party.getName()) + 1);
                } else {
                    partyVotes.put(party.getName(), 1);
                }
            }
        }
        return partyVotes;
    }

    public Map<String, Map<String, Integer>> getResultsByCityType(Integer electionId) {
        if (electionRepository.findById(electionId).isEmpty()) {
            throw new ElectionNotFoundException("Election not found");
        }
        List<Vote> votes = voteRepository.findAll();
        Map<String, Map<String, Integer>> cityTypeVotes = new HashMap<>();
        for (Vote vote : votes) {
            if (vote.getCandidate().getElection().getElectionId().equals(electionId)) {
                String cityType = convertCityTypeToString(vote.getVoterCityType());
                PoliticalParty party = vote.getCandidate().getPoliticalParty();
                if (cityTypeVotes.containsKey(cityType)) {
                    Map<String, Integer> partyVotes = cityTypeVotes.get(cityType);
                    if (partyVotes.containsKey(party.getName())) {
                        partyVotes.put(party.getName(), partyVotes.get(party.getName()) + 1);
                    } else {
                        partyVotes.put(party.getName(), 1);
                    }
                } else {
                    Map<String, Integer> partyVotes = new HashMap<>();
                    partyVotes.put(party.getName(), 1);
                    cityTypeVotes.put(cityType, partyVotes);
                }
            }
        }
        return cityTypeVotes;
    }

    public Map<String, Map<String, Integer>> getResultsBySex(Integer electionId) {
        if (electionRepository.findById(electionId).isEmpty()) {
            throw new ElectionNotFoundException("Election not found");
        }
        List<Vote> votes = voteRepository.findAll();
        Map<String, Map<String, Integer>> sexVotes = new HashMap<>();
        for (Vote vote : votes) {
            if (vote.getCandidate().getElection().getElectionId().equals(electionId)) {
                String sex = convertSexToString(vote.getSex());
                PoliticalParty party = vote.getCandidate().getPoliticalParty();
                if (sexVotes.containsKey(sex.toString())) {
                    Map<String, Integer> partyVotes = sexVotes.get(sex.toString());
                    if (partyVotes.containsKey(party.getName())) {
                        partyVotes.put(party.getName(), partyVotes.get(party.getName()) + 1);
                    } else {
                        partyVotes.put(party.getName(), 1);
                    }
                } else {
                    Map<String, Integer> partyVotes = new HashMap<>();
                    partyVotes.put(party.getName(), 1);
                    sexVotes.put(sex.toString(), partyVotes);
                }
            }
        }
        return sexVotes;
    }

    public Map<String, Map<String, Integer>> getResultsByCountry(Integer electionId) {
        if (electionRepository.findById(electionId).isEmpty()) {
            throw new ElectionNotFoundException("Election not found");
        }
        List<Vote> votes = voteRepository.findAll();
        Map<String, Map<String, Integer>> countryVotes = new HashMap<>();
        for (Vote vote : votes) {
            if (vote.getCandidate().getElection().getElectionId().equals(electionId)) {
                String country = vote.getVoterCountry();
                groupByParam(countryVotes, vote, country);
            }
        }
        return countryVotes;
    }

    public Map<String, Map<String, Integer>> getResultsByAgeGroup(Integer electionId) {
        if (electionRepository.findById(electionId).isEmpty()) {
            throw new ElectionNotFoundException("Election not found");
        }
        List<Vote> votes = voteRepository.findAll();
        Map<String, Map<String, Integer>> ageVotes = new HashMap<>();
        for (Vote vote : votes) {
            if (vote.getCandidate().getElection().getElectionId().equals(electionId)) {
                java.util.Date utilDate = new java.util.Date(vote.getVoterBirthdate().getTime());
                Instant birthdateInstant = utilDate.toInstant();
                int age = LocalDate.now().getYear() - birthdateInstant.atZone(ZoneId.systemDefault()).toLocalDate().getYear();
                String ageGroup = getAgeGroup(age);
                groupByParam(ageVotes, vote, ageGroup);
            }
        }
        return ageVotes;
    }


    public Map<String, Map<String, Integer>> getResultsByEducation(Integer electionId) {
        if (electionRepository.findById(electionId).isEmpty()) {
            throw new ElectionNotFoundException("Election not found");
        }
        List<Vote> votes = voteRepository.findAll();
        Map<String, Map<String, Integer>> educationVotes = new HashMap<>();
        for (Vote vote : votes) {
            if (vote.getCandidate().getElection().getElectionId().equals(electionId)) {
                String education = vote.getVoterEducation();
                groupByParam(educationVotes, vote, education);
            }
        }
        return educationVotes;
    }


    public String getAgeGroup(int age) {
        if (age >= 18 && age <= 29) {
            return "18-29";
        } else if (age >= 30 && age <= 39) {
            return "30-39";
        } else if (age >= 40 && age <= 49) {
            return "40-49";
        } else if (age >= 50 && age <= 59) {
            return "50-59";
        } else {
            return "60+";
        }
    }

    public void groupByParam(Map<String, Map<String, Integer>> educationVotes, Vote vote, String education) {
        PoliticalParty party = vote.getCandidate().getPoliticalParty();
        if (educationVotes.containsKey(education)) {
            Map<String, Integer> partyVotes = educationVotes.get(education);
            if (partyVotes.containsKey(party.getName())) {
                partyVotes.put(party.getName(), partyVotes.get(party.getName()) + 1);
            } else {
                partyVotes.put(party.getName(), 1);
            }
        } else {
            Map<String, Integer> partyVotes = new HashMap<>();
            partyVotes.put(party.getName(), 1);
            educationVotes.put(education, partyVotes);
        }
    }

    private String convertSexToString(boolean sex) {
        return sex ? "Mężczyzna" : "Kobieta";
    }

    private String convertCityTypeToString(CityType cityType) {
        return switch (cityType) {
            case OVER500THOUSAND -> "Powyżej 500 tysięcy";
            case TWOHUNDREDTO500THOUSAND -> "Pomiędzy 200 a 500 tysięcy";
            case FIFTYTOTWOHUNDREDTHOUSAND -> "Pomiędzy 50 a 200 tysięcy";
            default -> "Poniżej 50 tysięcy";
        };
    }

}
