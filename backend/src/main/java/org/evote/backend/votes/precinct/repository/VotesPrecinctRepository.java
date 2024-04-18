package org.evote.backend.votes.precinct.repository;

import org.evote.backend.votes.precinct.entity.Precinct;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface VotesPrecinctRepository extends JpaRepository<Precinct, Integer> {
}
