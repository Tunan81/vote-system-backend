package team.weyoung.controller;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import team.weyoung.common.DeleteRequest;
import team.weyoung.common.ErrorCode;
import team.weyoung.common.Result;
import team.weyoung.exception.BusinessException;
import team.weyoung.exception.ThrowUtils;
import team.weyoung.model.dto.competition.CompetitionQueryRequest;
import team.weyoung.model.dto.contestantInfo.ContestantInfoQueryRequest;
import team.weyoung.model.entity.ContestantInfo;
import team.weyoung.service.IContestantInfoService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 选手信息表 控制层。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@RestController
@RequestMapping("/contestantInfo")
public class ContestantInfoController {

    @Resource
    private IContestantInfoService iContestantInfoService;

    @PostMapping("/add")
    public Result<Long> addContestantInfo(@RequestBody ContestantInfo contestantInfo) {
        if (contestantInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean result = iContestantInfoService.save(contestantInfo);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return Result.success(contestantInfo.getContestantId());
    }

    @PostMapping("/delete")
    public Result<Boolean> deleteContestantInfo(@RequestBody DeleteRequest deleteRequest) {
        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean b = iContestantInfoService.removeById(deleteRequest.getId());
        return Result.success(b);
    }

    @PostMapping("/list/page")
    public Result<Page<ContestantInfo>> listContestantInfoPage(@RequestBody ContestantInfoQueryRequest contestantInfoQueryRequest) {
        Page<ContestantInfo> contestantInfoPage = iContestantInfoService.listContestantInfoPage(contestantInfoQueryRequest);
        return Result.success(contestantInfoPage);
    }
}
