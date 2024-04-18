package org.evote.backend.users.user.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.evote.backend.users.address.entity.Address;
import org.evote.backend.users.enums.CityType;
import org.evote.backend.users.precinct.entity.Precinct;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID user_id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private Number personalIdNumber;

    private String code;

    private Boolean hasVoted;

    private Date birthDate;

    private String education;

    private String profession;

    private Boolean sex;

    @ManyToMany
    @JoinTable(name = "precinct", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "precinct_id"))
    private List<Precinct> precincts;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Enumerated(EnumType.ORDINAL)
    private CityType cityType;
}
