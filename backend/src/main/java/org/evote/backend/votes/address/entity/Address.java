package org.evote.backend.votes.address.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.evote.backend.votes.political_party.entity.PoliticalParty;
import org.evote.backend.votes.precinct.entity.Precinct;

@Entity(name = "VotesAddress")
@Data
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "address_sequence", initialValue = 6, allocationSize = 1)
    private Integer address_id;

    private String zip_code;

    private String city;

    private String country;

    private String address_line;

    @OneToOne(mappedBy = "address")
    private Precinct precinct;

    @OneToOne(mappedBy = "address")
    private PoliticalParty politicalParty;
}
