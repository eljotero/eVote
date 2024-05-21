package org.evote.backend.users.account.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class AddressUpdateDTO {

    private UUID user_id;
    private String zip_code;
    private String city;
    private String country;
    private String voivodeship;
    private String address_line;
}
