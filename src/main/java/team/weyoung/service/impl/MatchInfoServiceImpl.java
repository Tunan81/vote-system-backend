package team.weyoung.service.impl;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
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
            matchInfoVO.setCompetitionId(matchInfo.getCompetitionId());
            matchInfoVO.setContestant1Id(matchInfo.getContestant1Id());
            matchInfoVO.setContestant2Id(matchInfo.getContestant2Id());
            ContestantInfo contestantInfo1 = iContestantInfoService
                    .getOne(new QueryWrapper().eq("contestant_id", matchInfo.getContestant1Id()));
            ContestantInfo contestantInfo2 = iContestantInfoService
                    .getOne(new QueryWrapper().eq("contestant_id", matchInfo.getContestant2Id()));
            matchInfoVO.setContestant1Song(contestantInfo1.getSongName());
            matchInfoVO.setContestant2Song(contestantInfo2.getSongName());
            matchInfoVO.setContestantName1(contestantInfo1.getContestantName());
            matchInfoVO.setContestantName2(contestantInfo2.getContestantName());
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
}
