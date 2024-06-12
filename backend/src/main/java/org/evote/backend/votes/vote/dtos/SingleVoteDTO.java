package org.evote.backend.votes.vote.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class SingleVoteDTO {
    private Integer candidateId;
    private Integer electionId;
}
