package team.weyoung.model.dto.matchInfo;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.core.keygen.KeyGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import team.weyoung.common.PageRequest;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class MatchInfoQueryRequest extends PageRequest implements Serializable {

    /**
     * 对战ID，唯一标识比赛对战
     */
    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    private Long matchId;

    /**
     * 比赛ID，外键关联到比赛信息表
     */
    private Long competitionId;

    /**
     * 选手1ID，外键关联到选手信息表
     */
    private Long contestant1Id;

    /**
     * 选手2ID，外键关联到选手信息表
     */
    private Long contestant2Id;

    /**
     * 获胜选手ID，关联到选手信息表
     */
    private Long winningContestantId;

    private static final long serialVersionUID = 1L;
}
