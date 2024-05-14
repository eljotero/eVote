package org.evote.backend.votes.election.dtos.election;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.evote.backend.votes.enums.ElectionType;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ElectionCreateDTO {
    private String election_name;
    private Date startDate;
    private Date endDate;
    private ElectionType type;
}
