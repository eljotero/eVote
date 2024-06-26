package org.evote.backend.votes.candidate.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import org.evote.backend.votes.election.entity.Election;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.evote.backend.votes.precinct.entity.Precinct;

import java.util.Date;

@Entity
@Data
@Table(name = "candidate", indexes = {
        @Index(name = "idx_surname_birthDate_education", columnList = "surname,birthDate,education")
}
)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "candidate_id")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_seq")
    @SequenceGenerator(name = "candidate_seq", sequenceName = "candidate_sequence", initialValue = 65, allocationSize = 1)
    @Column(name = "candidate_id")
    private Integer candidateId;
    private String name;
    private String surname;
    private Date birthDate;
    private String education;
    private String profession;
    private String info;
    private String image;

    @ManyToOne
    @JoinColumn(name = "political_party_id")
    @JsonManagedReference
    private PoliticalParty politicalParty;

    @ManyToOne
    @JoinColumn(name = "precinct_id")
    private Precinct precinct;

    @ManyToOne
    @JoinColumn(name = "election_id")
    private Election election;

}
