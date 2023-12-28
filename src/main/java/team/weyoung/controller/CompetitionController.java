package team.weyoung.controller;

import com.alibaba.excel.EasyExcel;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import team.weyoung.common.DeleteRequest;
import team.weyoung.common.ErrorCode;
import team.weyoung.common.Result;
import team.weyoung.exception.BusinessException;
import team.weyoung.exception.ThrowUtils;
import team.weyoung.model.dto.competition.CompetitionQueryRequest;
import team.weyoung.model.dto.competition.CompetitionUpdateDTO;
import team.weyoung.model.dto.contestantInfo.ContestantUploadDTO;
import team.weyoung.model.entity.Competition;
import team.weyoung.model.entity.ContestantInfo;
import team.weyoung.model.entity.MatchInfo;
import team.weyoung.service.ICompetitionService;
import team.weyoung.service.IContestantInfoService;
import team.weyoung.listener.UploadDTOListener;
import team.weyoung.service.IMatchInfoService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 比赛表 控制层。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@Slf4j
@RestController
@RequestMapping("/competition")
public class CompetitionController {

    @Resource
    private ICompetitionService iCompetitionService;

    @Resource
    private IContestantInfoService iContestantInfoService;

    @Resource
    private IMatchInfoService iMatchInfoService;

    @PostMapping("/add")
    public Result<Long> addCompetition(@RequestBody Competition competition) {
        if (competition == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean result = iCompetitionService.save(competition);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return Result.success(competition.getCompetitionId());
    }

    @PostMapping("/delete")
    public Result<Boolean> deleteCompetition(@RequestBody DeleteRequest deleteRequest) {
        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean b = iCompetitionService.removeById(deleteRequest.getId());
        return Result.success(b);
    }

    @PostMapping("/update")
    public Result<Boolean> updateCompetition(@RequestBody CompetitionUpdateDTO competitionUpdateDTO) {
        if (competitionUpdateDTO == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Competition competition = iCompetitionService.getOne(new QueryWrapper()
                .eq("competition_id", competitionUpdateDTO.getCompetitionId()));
        // 如果isMatch字段改变则执行对战操作
        if (competitionUpdateDTO.getIsMatchOpen() != null && competitionUpdateDTO.getIsMatchOpen()) {
            // 查询当前比赛的人数
            List<ContestantInfo> contestantInfos = iContestantInfoService.list(new QueryWrapper()
                    .eq("competition_id", competitionUpdateDTO.getCompetitionId()));
            // 如果人数为奇数则不允许开启对战
            if (contestantInfos.size() % 2 != 0) {
                throw new BusinessException(ErrorCode.OPERATION_ERROR, "当前比赛人数为奇数，不允许开启对战");
            }
            // 如果人数为偶数则执行对战操作 随机将两人分为一组插入对战表
            Collections.shuffle(contestantInfos);
            List<MatchInfo> matchInfos = new ArrayList<>();
            for (int i = 0; i < contestantInfos.size() - 1; i += 2) {
                ContestantInfo contestant1 = contestantInfos.get(i);
                ContestantInfo contestant2 = contestantInfos.get(i + 1);
                // 插入 matchInfo
                MatchInfo matchInfo = MatchInfo.builder()
                        .competitionId(competitionUpdateDTO.getCompetitionId())
                        .contestant1Id(contestant1.getContestantId())
                        .contestant2Id(contestant2.getContestantId())
                        .build();
                matchInfos.add(matchInfo);
            }
            boolean b = iMatchInfoService.saveBatch(matchInfos);
            ThrowUtils.throwIf(!b, ErrorCode.OPERATION_ERROR);
        } else {
            // 删除对战表信息
            List<MatchInfo> matchInfos = iMatchInfoService.list(new QueryWrapper()
                    .eq("competition_id", competitionUpdateDTO.getCompetitionId()));
            if (matchInfos != null && matchInfos.size() > 0) {
                Collection<Long> matchIds = new ArrayList<>();
                for (MatchInfo matchInfo : matchInfos) {
                    matchIds.add(matchInfo.getMatchId());
                }
                boolean b = iMatchInfoService.removeByIds(matchIds);
                ThrowUtils.throwIf(!b, ErrorCode.OPERATION_ERROR);
            }
        }
        BeanUtils.copyProperties(competitionUpdateDTO, competition);
        boolean result = iCompetitionService.updateById(competition);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return Result.success(true);
    }

    @PostMapping("/list/page")
    public Result<Page<Competition>> page(@RequestBody CompetitionQueryRequest competitionQueryRequest, HttpServletRequest request) {
        long pageNumber = competitionQueryRequest.getPageNumber();
        long pageSize = competitionQueryRequest.getPageSize();
        Page<Competition> competitionPage = iCompetitionService.page(new Page<>(pageNumber, pageSize));
        return Result.success(competitionPage);
    }

    @PostMapping("/upload")
    public Result<Boolean> upload(MultipartFile file, Long competitionId) throws IOException {
        if (file.isEmpty()) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        if (competitionId == null || competitionId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        EasyExcel.read(file.getInputStream(), ContestantUploadDTO.class,
                new UploadDTOListener(iContestantInfoService, competitionId)).sheet().doRead();
        // 把文件存入到临时文件
        return Result.success(true);
    }
}
