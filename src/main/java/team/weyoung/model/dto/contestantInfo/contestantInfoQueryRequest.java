package team.weyoung.model.dto.contestantInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import team.weyoung.common.PageRequest;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class contestantInfoQueryRequest extends PageRequest implements Serializable {
    /**
     * id
     */
    private Long contestantId;

    /**
     * 选手名称
     */
    private String contestantName;

    private static final long serialVersionUID = 1L;
}
