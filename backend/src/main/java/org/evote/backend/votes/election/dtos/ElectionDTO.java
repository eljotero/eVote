package org.evote.backend.votes.election.dtos;

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
public class ElectionDTO {
    private Integer election_id;
    private String election_name;
    private Date startDate;
    private Date endDate;
    private ElectionType type;
    private Integer candidate_id;
}