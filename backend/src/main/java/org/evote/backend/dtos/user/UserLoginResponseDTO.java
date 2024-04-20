package org.evote.backend.dtos.user;

import lombok.Data;
import java.util.UUID;

@Data
public class UserLoginResponseDTO {
    private UUID user_id;
    private String email;
}
