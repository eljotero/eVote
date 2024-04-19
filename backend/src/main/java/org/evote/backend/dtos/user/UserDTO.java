package org.evote.backend.dtos;
import org.evote.backend.users.enums.CityType;
import java.util.Date;
import java.util.UUID;
import lombok.Data;

@Data
public class UserDTO {
    private UUID user_id;
    private String name;
    private String surname;
    private String email;
    private Number personalIdNumber;
    private Boolean hasVoted;
    private Date birthDate;
    private String education;
    private String profession;
    private Boolean sex;
    private CityType cityType;

}