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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "precinct_seq")
    @SequenceGenerator(name = "precinct_seq", sequenceName = "precinct_sequence", initialValue = 28, allocationSize = 1)
    private UUID precinct_uuid;

    private Integer precinct_id;

    @ElementCollection
    private List<String> availableAddresses;

    @ElementCollection
    private List<String> availableCities;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Enumerated(EnumType.STRING)
    private ElectionType electionType;

    @ManyToMany
    @JoinTable(
            name = "users_precincts",
            joinColumns = @JoinColumn(name = "precinct_uuid"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonIgnore
    private List<User> users;
}

