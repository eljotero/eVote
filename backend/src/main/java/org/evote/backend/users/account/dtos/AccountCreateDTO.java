package org.evote.backend.users.account.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.evote.backend.users.enums.Role;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreateDTO {
    private String email;
    private String password;
    private Role role = Role.USER;
    private Boolean hasVoted = false;
    private Boolean isAccountActive = false;
}
