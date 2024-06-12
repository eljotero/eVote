package org.evote.backend.users.user.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.address.entity.Address;
import org.evote.backend.users.enums.CityType;
import org.evote.backend.users.enums.Education;
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
    private Boolean sex;
    private String personalIdNumber;
    private String code;
    private Date birthDate;
    @Enumerated(EnumType.STRING)
    private Education education;
    @Enumerated(EnumType.STRING)
    private CityType cityType;
    private String profession;

    @ManyToMany(mappedBy = "users")
    private List<Precinct> precincts;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(mappedBy = "user")
    private Account account;
}
