package org.evote.backend.votes.political_party.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.evote.backend.votes.address.entity.Address;
import org.evote.backend.votes.candidate.entity.Candidate;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "political_party")
public class PoliticalParty {
    @Id
    @GeneratedValue
    private Integer political_party_id;

    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "politicalParty")
    private List<Candidate> candidates;
    public Integer getId() {
        return political_party_id;
    }

    public void setId(Integer l) {
        this.political_party_id = l;
    }

    public void setAddress_id(Integer addressId) {
    }
}
