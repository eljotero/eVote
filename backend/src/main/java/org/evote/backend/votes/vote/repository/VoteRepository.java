package org.evote.backend.votes.vote.repository;

import org.evote.backend.votes.vote.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
}
