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
import team.weyoung.common.Result;
import team.weyoung.model.dto.competition.CompetitionQueryRequest;
import team.weyoung.model.entity.ContestantInfo;
import team.weyoung.service.IContestantInfoService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 选项信息表 控制层。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@RestController
@RequestMapping("/contestantInfo")
public class ContestantInfoController {

    @Resource
    private IContestantInfoService iContestantInfoService;

    @PostMapping("/list/page")
    public Result<Page<ContestantInfo>> listContestantInfoPage(@RequestBody CompetitionQueryRequest competitionQueryRequest) {
        long pageNumber = competitionQueryRequest.getPageNumber();
        long pageSize = competitionQueryRequest.getPageSize();
        Page<ContestantInfo> contestantInfoPage = iContestantInfoService.page(new Page<>(pageNumber, pageSize));
        return Result.success(contestantInfoPage);
    }
}
