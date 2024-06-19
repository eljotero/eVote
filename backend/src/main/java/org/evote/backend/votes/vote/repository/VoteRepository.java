package org.evote.backend.votes.vote.repository;

import org.evote.backend.votes.vote.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
    List<Vote> findByCandidate_Election_ElectionId(int electionId);
}
