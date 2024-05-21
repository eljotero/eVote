package org.evote.backend.dtos.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class UserUpdateDTO {
    private String name;
    private String surname;
    private Number personalIdNumber;
    private Boolean sex;
    private Date birthDate;
    private String education;
    private String cityType;
    private String profession;
    private String zip_code;
    private String city;
    private String voivodeship;
    private String country;
    private String address_line;
}
