package org.evote.backend.votes.election.repository;

import org.evote.backend.votes.election.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface ElectionRepository extends JpaRepository<Election, Integer> {
}
