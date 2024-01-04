package team.weyoung.model.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.sql.Timestamp;

import com.mybatisflex.core.keygen.KeyGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 对战信息表 实体类。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "match_info")
public class MatchInfo implements Serializable {

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

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 是否开启比赛对战
     */
    private Boolean isMatchOpen;

    /**
     * 是否删除
     */
    private Integer isDelete;

}
