package org.evote.backend.users.account.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddressUpdateDTO {

    private String zip_code;
    private String city;
    private String country;
    private String address_line;
}