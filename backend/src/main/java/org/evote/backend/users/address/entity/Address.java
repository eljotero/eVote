package org.evote.backend.users.address.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.evote.backend.users.precinct.entity.Precinct;
import org.evote.backend.users.user.entity.User;

import java.util.List;

@Entity(name = "UsersAddress")
@Data
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue()
    private Integer address_id;

    private String zip_code;

    private String city;

    private String country;

    private String address_line;

    @OneToMany(mappedBy = "address")
    private List<User> users;

    @OneToOne(mappedBy = "address")
    private Precinct precinct;
}
