package team.weyoung.model.dto.competition;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.core.keygen.KeyGenerators;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CompetitionUpdateDTO implements Serializable {
    /**
     * 比赛ID，唯一标识比赛
     */
    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    private Long competitionId;

    /**
     * 比赛名称
     */
    private String competitionName;

    /**
     * 比赛开始时间
     */
    private LocalDateTime startTime;

    /**
     * 比赛结束时间
     */
    private LocalDateTime endTime;

    /**
     * 比赛阶段，例如初赛、半决赛、决赛等
     */
    private String competitionStage;

    /**
     * 比赛简介
     */
    private String competitionInfo;

    /**
     * 是否开启投票
     */
    private Boolean isVotingOpen;

    /**
     * 是否开启比赛对战
     */
    private Boolean isMatchOpen;

    private static final long serialVersionUID = 1L;
}
