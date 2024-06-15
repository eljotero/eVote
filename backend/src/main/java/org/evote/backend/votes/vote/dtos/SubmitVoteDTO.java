package org.evote.backend.votes.vote.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubmitVoteDTO {
    private Date voterBirthDate;
    private Integer voterCityType;
    private String voterEducation;
    private String voterCountry;
    private Integer candidateId;
}
