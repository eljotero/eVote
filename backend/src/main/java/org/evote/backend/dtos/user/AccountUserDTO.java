package org.evote.backend.dtos.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class AccountUserDTO {
    private String email;
    private Boolean hasVoted;
    private Boolean isAccountActive;
    private UUID user_id;
    private String name;
    private String surname;
    private Boolean sex;
    private Date birthDate;
    private String education;
    private String profession;
}
