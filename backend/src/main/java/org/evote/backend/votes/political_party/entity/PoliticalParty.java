package org.evote.backend.votes.political_party.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.evote.backend.votes.address.entity.Address;
import org.evote.backend.votes.candidate.entity.Candidate;

import java.util.List;

@Entity
@Data
@Table(name = "political_party")
public class PoliticalParty {
    @Id
    @GeneratedValue
    private Long political_party_id;

    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "politicalParty")
    private List<Candidate> candidates;
}