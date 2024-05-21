package org.evote.backend.votes.candidate.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCreateDTO {
    private String name;
    private String surname;
    private Date birthDate;
    private String education;
    private String profession;
    private Integer political_party_id;
    private Integer precinct_id;
    private Integer election_id;
    private String info;
    private String image;
}
