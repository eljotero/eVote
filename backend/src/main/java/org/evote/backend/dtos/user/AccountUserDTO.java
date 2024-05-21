package org.evote.backend.dtos.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class AccountUserDTO {
    private String email;
    private String name;
    private String surname;
    private Boolean sex;
    private Date birthDate;
    private String education;
    private String profession;
    private String cityType;
    private String personalIdNumber;
    private String zipCode;
    private String city;
    private String country;
    private String addressLine;
    private String voivodeship;
}
