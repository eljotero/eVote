package org.evote.backend.votes.election.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.evote.backend.votes.enums.ElectionType;

import java.util.Date;

@Entity
@Data
@Table(name = "election")
public class Election {
    @Id
    @GeneratedValue
    private Long election_id;

    private String election_name;

    private Date startDate;

    private Date endDate;

    @Enumerated(EnumType.ORDINAL)
    private ElectionType type;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
