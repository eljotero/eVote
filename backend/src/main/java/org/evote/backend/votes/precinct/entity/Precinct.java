package org.evote.backend.votes.precinct.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.evote.backend.votes.address.entity.Address;
import org.evote.backend.votes.enums.ElectionType;

@Entity(name = "VotesPrecinct")
@Data
@Table(name = "precinct")
public class Precinct {
    @Id
    @GeneratedValue()
    private Integer precinct_id;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Enumerated(EnumType.ORDINAL)
    private ElectionType electionType;

}
