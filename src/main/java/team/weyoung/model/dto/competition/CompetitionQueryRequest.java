package team.weyoung.model.dto.competition;

import lombok.Data;
import lombok.EqualsAndHashCode;
import team.weyoung.common.PageRequest;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompetitionQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long competitionId;

    /**
     * 比赛名称
     */
    private String competitionName;

    private static final long serialVersionUID = 1L;
}
