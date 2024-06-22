package org.evote.backend.votes.political_party.entity;

import jakarta.persistence.*;
import lombok.*;
import org.evote.backend.votes.address.entity.Address;
import org.evote.backend.votes.candidate.entity.Candidate;

import java.util.List;

@Entity
@Data
@Table(name = "political_party",
indexes = {
        @Index(name = "political_party_name_index", columnList = "name")
})
public class PoliticalParty {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "party_seq")
    @SequenceGenerator(name = "party_seq", sequenceName = "party_sequence", initialValue = 6, allocationSize = 1)
    private Integer politicalPartyId;
    private String name;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "politicalParty")
    private List<Candidate> candidates;
}
