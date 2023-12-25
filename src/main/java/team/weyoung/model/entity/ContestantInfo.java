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
 * 选项信息表 实体类。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "contestant_info")
public class ContestantInfo implements Serializable {

    /**
     * 选手ID，唯一标识选手
     */
    @Id
    private Long contestantId;

    /**
     * 选手姓名
     */
    private String contestantName;

    /**
     * 所属比赛ID，外键关联到比赛信息表
     */
    private Long competitionId;

    /**
     * 选手获得的投票数
     */
    private Integer score;

    /**
     * 选手总票数（评委分数加观众票数百分比得出的总票数）
     */
    private Integer totalScore;

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
