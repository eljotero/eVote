package org.evote.backend.dtos.user;

import lombok.Data;

@Data
public class UserAuthenticateDTO {
    private String email;
    private String password;
}
