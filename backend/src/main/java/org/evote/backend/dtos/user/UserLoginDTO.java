package org.evote.backend.dtos.user;

import lombok.Data;

@Data
public class UserLoginDTO {
    private String email;
    private String password;
}
