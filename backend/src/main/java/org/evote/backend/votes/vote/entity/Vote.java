package org.evote.backend.votes.vote.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.evote.backend.votes.candidate.entity.Candidate;
import org.evote.backend.votes.enums.CityType;

import java.sql.Time;
import java.util.Date;

@Entity
@Data
@Table(name = "vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vote_seq")
    @SequenceGenerator(name = "vote_seq", sequenceName = "vote_sequence", initialValue = 338, allocationSize = 1)
    private Long voteId;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    private Date voterBirthdate;

    private String voterEducation;

    @Enumerated(EnumType.ORDINAL)
    private CityType voterCityType;

    private Time voteTime;

    private String voterCountry;

    private Boolean sex;

}
