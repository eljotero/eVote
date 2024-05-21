package org.evote.backend.users.precinct.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.evote.backend.users.address.entity.Address;
import org.evote.backend.users.enums.ElectionType;
import org.evote.backend.users.user.entity.User;

import java.util.List;
import java.util.UUID;

@Entity(name = "UsersPrecinct")
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

    @ManyToMany(mappedBy = "precincts")
    @JsonIgnore
    private List<User> users;
}

