package org.evote.backend.dtos.user;

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
