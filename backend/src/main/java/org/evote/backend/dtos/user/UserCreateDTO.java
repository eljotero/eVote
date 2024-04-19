package org.evote.backend.dtos.user;

import lombok.Data;
import org.evote.backend.users.address.entity.Address;
import org.evote.backend.users.enums.CityType;
import org.evote.backend.users.precinct.entity.Precinct;

import java.util.Date;
import java.util.List;

@Data
public class UserCreateDTO {
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
    private List<Precinct> precincts;
    private Address address;
    private CityType cityType;
}
