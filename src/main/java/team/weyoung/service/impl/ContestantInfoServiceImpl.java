package team.weyoung.service.impl;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import team.weyoung.model.dto.contestantInfo.ContestantInfoQueryRequest;
import team.weyoung.model.entity.ContestantInfo;
import team.weyoung.mapper.ContestantInfoMapper;
import team.weyoung.service.IContestantInfoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 选手信息表 服务层实现。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@Service
@SuppressWarnings("all")
public class ContestantInfoServiceImpl extends ServiceImpl<ContestantInfoMapper, ContestantInfo> implements IContestantInfoService {

    @Override
    public Page<ContestantInfo> listContestantInfoPage(ContestantInfoQueryRequest contestantInfoQueryRequest) {
        Optional<ContestantInfoQueryRequest> optional = Optional.ofNullable(contestantInfoQueryRequest);
        QueryWrapper queryWrapper = new QueryWrapper();
        Optional.ofNullable(contestantInfoQueryRequest.getContestantId())
                .ifPresent(contestantId -> queryWrapper.eq("contestant_id", contestantId));
        Optional.ofNullable(contestantInfoQueryRequest.getContestantName())
                .ifPresent(contestantName -> queryWrapper.like("contestant_name", contestantName));
        Optional.ofNullable(contestantInfoQueryRequest.getCompetitionId())
                .ifPresent(competitionId -> queryWrapper.eq("competition_id", competitionId));
        Long pageSize = contestantInfoQueryRequest.getPageSize();
        Long pageNum = contestantInfoQueryRequest.getPageNumber();
        Page<ContestantInfo> page = new Page<>(pageNum, pageSize);
        return page(page, queryWrapper);
    }
}
