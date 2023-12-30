package team.weyoung.model.entity;

import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.mybatisflex.core.keygen.KeyGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 比赛表 实体类。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "competition")
public class Competition implements Serializable {

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
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 是否开启投票
     */
    private Boolean isVotingOpen;

    /**
     * 是否开启比赛对战
     */
    private Boolean isMatchOpen;

    /**
     * 是否删除
     */
    private Integer isDelete;

}
