package org.evote.backend.users.address.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.evote.backend.users.precinct.entity.Precinct;
import org.evote.backend.users.user.entity.User;

import java.util.List;

@Entity(name = "UsersAddress")
@Data
@Table(name = "address", indexes = {
        @Index(name = "idx_zip_city_country_voivodeship_addressLine", columnList = "zip_code, city, country, voivodeship, address_line", unique = true),
})
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vote_seq")
    @SequenceGenerator(name = "vote_seq", sequenceName = "address_sequence", initialValue = 17, allocationSize = 1)
    private Integer address_id;

    private String zip_code;

    private String voivodeship;

    private String city;

    private String country;

    private String address_line;

    @OneToMany(mappedBy = "address")
    @JsonIgnore
    private List<User> users;

    @OneToMany(mappedBy = "address")
    @JsonIgnore
    private List<Precinct> precincts;
}