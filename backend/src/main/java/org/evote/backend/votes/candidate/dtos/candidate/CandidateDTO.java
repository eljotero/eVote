package org.evote.backend.votes.candidate.dtos.candidate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDTO {
    private UUID candidate_id;
    private String name;
    private String surname;
    private Date birthDate;
    private String education;
    private String profession;
    private UUID political_party_id;
    private UUID precinct_id;
    private UUID election_id;

}
