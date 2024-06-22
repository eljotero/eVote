package org.evote.backend.votes.election.entity;

import jakarta.persistence.*;
import lombok.*;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.evote.backend.votes.enums.ElectionType;

import java.util.Date;

@Entity
@Data
@Table(name = "election")
public class Election {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "election_seq")
    @SequenceGenerator(name = "election_seq", sequenceName = "election_sequence", initialValue = 9, allocationSize = 1)
    private Integer electionId;

    private String electionName;

    private Date startDate;

    private Date endDate;

    @Enumerated(EnumType.STRING)
    private ElectionType type;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}
