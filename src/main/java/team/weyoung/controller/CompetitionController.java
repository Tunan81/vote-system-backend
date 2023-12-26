package team.weyoung.controller;

import com.alibaba.excel.EasyExcel;
import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import team.weyoung.common.DeleteRequest;
import team.weyoung.common.ErrorCode;
import team.weyoung.common.Result;
import team.weyoung.exception.BusinessException;
import team.weyoung.exception.ThrowUtils;
import team.weyoung.model.dto.competition.CompetitionQueryRequest;
import team.weyoung.model.dto.competition.ContestantUploadDTO;
import team.weyoung.model.entity.Competition;
import team.weyoung.service.ICompetitionService;
import team.weyoung.service.IContestantInfoService;
import team.weyoung.listener.UploadDTOListener;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 比赛表 控制层。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@RestController
@RequestMapping("/competition")
public class CompetitionController {

    @Resource
    private ICompetitionService iCompetitionService;

    @Resource
    private IContestantInfoService iContestantInfoService;

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

    @PostMapping("/list/page")
    public Result<Page<Competition>> page(@RequestBody CompetitionQueryRequest competitionQueryRequest, HttpServletRequest request) {
        long pageNumber = competitionQueryRequest.getPageNumber();
        long pageSize = competitionQueryRequest.getPageSize();
        Page<Competition> competitionPage = iCompetitionService.page(new Page<>(pageNumber, pageSize));
        return Result.success(competitionPage);
    }

    @PostMapping("/upload")
    public Result<Boolean> upload(MultipartFile file,Long competitionId) throws IOException {
        if (file.isEmpty()) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        EasyExcel.read(file.getInputStream(), ContestantUploadDTO.class, new UploadDTOListener(iContestantInfoService,competitionId)).sheet().doRead();
        // 把文件存入到临时文件
        return Result.success(true);
    }
}
