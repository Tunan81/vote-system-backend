package team.weyoung.model.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 投票表 实体类。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "voting")
public class Voting implements Serializable {

    /**
     * 投票ID，唯一标识投票
     */
    @Id
    private Long voteId;

    /**
     * 选手ID，外键关联到选手信息表
     */
    private Long contestantId;

    /**
     * 用户ID，外键关联到用户表（投票的观众或评委）
     */
    private Long userId;

    /**
     * 是否已投票
     */
    private Boolean voteCount;

    /**
     * 是否是评委投票
     */
    private Boolean isJudgeVote;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 是否删除
     */
    private Integer isDelete;

}
