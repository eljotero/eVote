package org.evote.backend.votes.precinct.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.evote.backend.votes.address.entity.Address;
import org.evote.backend.votes.enums.ElectionType;

import java.util.List;
import java.util.UUID;

@Entity(name = "VotesPrecinct")
@Data
@Table(name = "precinct")
public class Precinct {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID precinct_uuid;

    private Integer precinct_id;
    @ElementCollection
    private List<String> availableAddresses;

    @ElementCollection
    private List<String> availableCities;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Enumerated(EnumType.ORDINAL)
    private ElectionType electionType;

    public Integer getId() {
        return precinct_id;
    }
}
