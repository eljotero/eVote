package org.evote.backend.votes.candidate.repository;

import org.evote.backend.votes.candidate.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CandidateRepository extends JpaRepository<Candidate, UUID> {
}