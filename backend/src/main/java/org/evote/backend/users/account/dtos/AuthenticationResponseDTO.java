package org.evote.backend.users.account.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponseDTO {

    private String token;

    public AuthenticationResponseDTO(String token) {
        this.token = token;
    }
}
