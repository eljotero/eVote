package org.evote.backend.votes.election.dtos.election;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ElectionDTO {
    private Long election_id;
    private String election_name;
    private Date startDate;
    private Date endDate;
    private String type; // ElectionType is converted to String
    private Long candidate_id; // Assuming Candidate's id is of type Long
}