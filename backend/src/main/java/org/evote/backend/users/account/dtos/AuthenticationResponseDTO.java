package org.evote.backend.users.account.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponseDTO {

    private String token;

    private Integer id;

    public AuthenticationResponseDTO(String token, Integer id) {
        this.token = token;
        this.id = id;
    }
}
