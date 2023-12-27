package team.weyoung.model.vo;

import lombok.Data;

@Data
public class MatchInfoVO {

    /**
     * 比赛ID，外键关联到比赛信息表
     */
    private Long competitionId;

    /**
     * 选手1ID，外键关联到选手信息表
     */
    private Long contestant1Id;

    private String contestantName1;

    /**
     * 选手2ID，外键关联到选手信息表
     */
    private Long contestant2Id;

    private String contestantName2;

    /**
     * 选手1选择的歌曲
     */
    private String contestant1Song;

    /**
     * 选手2选择的歌曲
     */
    private String contestant2Song;
}
