package team.weyoung.model.dto.contestantInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import team.weyoung.common.PageRequest;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContestantInfoQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long contestantId;

    private Long competitionId;

    /**
     * 选手名称
     */
    private String contestantName;

    private static final long serialVersionUID = 1L;
}
