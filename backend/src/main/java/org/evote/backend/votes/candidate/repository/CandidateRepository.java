package org.evote.backend.votes.candidate.repository;

import org.evote.backend.votes.candidate.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
}
