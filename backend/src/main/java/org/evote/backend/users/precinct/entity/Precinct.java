package org.evote.backend.users.precinct.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.evote.backend.users.address.entity.Address;
import org.evote.backend.users.enums.ElectionType;

@Entity(name = "UsersPrecinct")
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
