package org.evote.backend.votes.candidate.repository;

import org.evote.backend.votes.candidate.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.UUID;

@org.springframework.stereotype.Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    Candidate findByNameAndSurnameAndBirthDateAndEducation(String name, String surname, Date birthDate, String education);
}