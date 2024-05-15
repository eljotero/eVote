package org.evote.backend.votes.election.repository;

import org.evote.backend.votes.election.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

@org.springframework.stereotype.Repository
public interface ElectionRepository extends JpaRepository<Election, Integer> {
    Election findByElectionNameAndStartDate(String electionName, Date startDate);
}
