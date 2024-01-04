package team.weyoung.service.impl;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import team.weyoung.common.ErrorCode;
import team.weyoung.exception.BusinessException;
import team.weyoung.model.dto.matchInfo.MatchInfoQueryRequest;
import team.weyoung.model.entity.ContestantInfo;
import team.weyoung.model.vo.MatchInfoVO;
import team.weyoung.model.entity.MatchInfo;
import team.weyoung.mapper.MatchInfoMapper;
import team.weyoung.service.IContestantInfoService;
import team.weyoung.service.IMatchInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 对战信息表 服务层实现。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@Service
@SuppressWarnings("all")
public class MatchInfoServiceImpl extends ServiceImpl<MatchInfoMapper, MatchInfo> implements IMatchInfoService {

    @Resource
    private IContestantInfoService iContestantInfoService;

    @Override
    public Page<MatchInfoVO> listMatchInfo(MatchInfoQueryRequest matchInfoQueryRequest) {
        Optional<MatchInfoQueryRequest> optional = Optional.ofNullable(matchInfoQueryRequest);
        QueryWrapper queryWrapper = new QueryWrapper();
        Optional.ofNullable(matchInfoQueryRequest.getMatchId())
                .ifPresent(matchId -> queryWrapper.eq("match_id", matchId));
        Optional.ofNullable(matchInfoQueryRequest.getCompetitionId())
                .ifPresent(competitionId -> queryWrapper.eq("competition_id", competitionId));
        Long pageSize = matchInfoQueryRequest.getPageSize();
        Long pageNum = matchInfoQueryRequest.getPageNumber();
        List<MatchInfo> matchInfos = this.list(queryWrapper);
        List<MatchInfoVO> matchInfoVOS = new ArrayList<>();
        // 根据选手id取选手表中查询对应的歌曲
        matchInfos.forEach(matchInfo -> {
            MatchInfoVO matchInfoVO = new MatchInfoVO();
            matchInfoVO.setMatchId(matchInfo.getMatchId());
            matchInfoVO.setCompetitionId(matchInfo.getCompetitionId());
            matchInfoVO.setContestant1Id(matchInfo.getContestant1Id());
            matchInfoVO.setContestant2Id(matchInfo.getContestant2Id());
            matchInfoVO.setIsMatchOpen(matchInfo.getIsMatchOpen());
            ContestantInfo contestantInfo1 = iContestantInfoService
                    .getOne(new QueryWrapper().eq("contestant_id", matchInfo.getContestant1Id()));
            ContestantInfo contestantInfo2 = iContestantInfoService
                    .getOne(new QueryWrapper().eq("contestant_id", matchInfo.getContestant2Id()));
            matchInfoVO.setContestant1Song(contestantInfo1.getSongName());
            matchInfoVO.setContestant2Song(contestantInfo2.getSongName());
            matchInfoVO.setContestantName1(contestantInfo1.getContestantName());
            matchInfoVO.setContestantName2(contestantInfo2.getContestantName());
            matchInfoVO.setScore(contestantInfo1.getScore());
            matchInfoVO.setScore2(contestantInfo2.getScore());
            matchInfoVOS.add(matchInfoVO);
        });
        // 将list转换为page
        Page<MatchInfoVO> matchInfoPage = new Page<>();
        matchInfoPage.setPageNumber(pageNum);
        matchInfoPage.setPageSize(pageSize);
        matchInfoPage.setTotalRow(matchInfoVOS.size());
        matchInfoPage.setRecords(matchInfoVOS);
        return matchInfoPage;
    }

    @Override
    public boolean updateMatchInfo(MatchInfo matchInfo) {
        Boolean isMatchOpen = matchInfo.getIsMatchOpen();
        // 先查询表中是否有isMatchOpen为1的数据
        MatchInfo matchInfo1 = this.getOne(new QueryWrapper().eq("is_match_open", 1));
        MatchInfo matchInfo2 = new MatchInfo();
        if (isMatchOpen) {
            if (matchInfo1 != null) {
                System.out.println(matchInfo);
                throw new BusinessException(ErrorCode.OPERATION_ERROR, "已存在开启的比赛");
            }
        }
        // 对象转换
        BeanUtils.copyProperties(matchInfo, matchInfo2);
        // 修改数据
        return this.updateById(matchInfo2);
    }
}
