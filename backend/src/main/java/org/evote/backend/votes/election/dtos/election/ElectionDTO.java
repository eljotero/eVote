package org.evote.backend.votes.election.dtos.election;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.SmallIntJdbcType;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ElectionDTO {
    private Integer election_id;
    private String election_name;
    private Date startDate;
    private Date endDate;
    private SmallIntJdbcType type;
    private UUID candidate_id;


}