package team.weyoung.controller;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import team.weyoung.common.Result;
import team.weyoung.model.dto.matchInfo.MatchInfoQueryRequest;
import team.weyoung.model.vo.MatchInfoVO;
import team.weyoung.service.IMatchInfoService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @PostMapping("/list/page")
    public Result<Page<MatchInfoVO>> listMatchInfoPage(@RequestBody MatchInfoQueryRequest matchInfoQueryRequest) {
        Page<MatchInfoVO> page = iMatchInfoService.listMatchInfo(matchInfoQueryRequest);
        return Result.success(page);
    }

}
