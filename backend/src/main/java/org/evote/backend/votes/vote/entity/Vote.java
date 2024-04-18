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
    @GeneratedValue
    private Long vote_id;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    private Date voter_birthdate;

    private String voter_education;

    @Enumerated(EnumType.ORDINAL)
    private CityType voter_city_type;

    private Time vote_time;

    private String voter_country;

}
