package org.evote.backend.votes.candidate.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import org.evote.backend.votes.election.entity.Election;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.evote.backend.votes.precinct.entity.Precinct;
import org.w3c.dom.Text;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "candidate")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "candidate_id")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer candidate_id;
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

    public int getElection_id() {
        return Math.toIntExact(election.getElection_id());
    }

    public int getPrecinct_id() {
        return precinct.getPrecinct_id();
    }
    public int getPolitical_party_id() {
        return politicalParty.getId();
    }

    public void setElection_id(int i) {
        election.setElection_id((Integer) i);
    }

    public void setPrecinct_id(int i) {
        precinct.setPrecinct_id(i);
    }

    public void setPolitical_party_id(int i) {
        politicalParty.setId(i);
    }

}
