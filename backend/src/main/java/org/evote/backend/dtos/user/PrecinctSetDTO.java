package org.evote.backend.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.evote.backend.users.enums.ElectionType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrecinctSetDTO {
    private String city;
    private ElectionType electionType;
    private String voivodeship;
}
