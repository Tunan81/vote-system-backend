package team.weyoung.controller;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import team.weyoung.common.Result;
import team.weyoung.model.dto.matchInfo.MatchInfoQueryRequest;
import team.weyoung.model.entity.ContestantInfo;
import team.weyoung.model.entity.MatchInfo;
import team.weyoung.model.vo.MatchInfoVO;
import team.weyoung.service.IContestantInfoService;
import team.weyoung.service.IMatchInfoService;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 对战信息表 控制层。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@RestController
@RequestMapping("/matchInfo")
public class MatchInfoController {

    @Resource
    private IMatchInfoService iMatchInfoService;

    @Resource
    private IContestantInfoService iContestantInfoService;

    @PostMapping("/get/one")
    public Result<MatchInfoVO> getCurrentMatch(@RequestBody MatchInfoQueryRequest matchInfoQueryRequest) {
        Long competitionId = matchInfoQueryRequest.getCompetitionId();
        MatchInfo matchInfo = iMatchInfoService.getOne(new QueryWrapper()
                .eq("is_match_open", 1)
                .eq("competition_id", competitionId));
        if (matchInfo == null) {
            return Result.fail("当前没有进行中的对战");
        }
        // 根据选手id取选手表中查询对应的歌曲
        MatchInfoVO matchInfoVO = new MatchInfoVO();
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
        return Result.success(matchInfoVO);
    }

    @PostMapping("/list/page")
    public Result<Page<MatchInfoVO>> listMatchInfoPage(@RequestBody MatchInfoQueryRequest matchInfoQueryRequest) {
        Page<MatchInfoVO> page = iMatchInfoService.listMatchInfo(matchInfoQueryRequest);
        return Result.success(page);
    }

    @PostMapping("/update")
    public Result<Boolean> updateMatchInfo(@RequestBody MatchInfo matchInfo) {
        boolean result = iMatchInfoService.updateMatchInfo(matchInfo);
        return Result.success(result);
    }

}
