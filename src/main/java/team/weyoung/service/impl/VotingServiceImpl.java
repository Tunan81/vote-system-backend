package team.weyoung.service.impl;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import team.weyoung.common.ErrorCode;
import team.weyoung.constant.UserConstant;
import team.weyoung.exception.BusinessException;
import team.weyoung.model.entity.ContestantInfo;
import team.weyoung.model.entity.User;
import team.weyoung.model.entity.Voting;
import team.weyoung.mapper.VotingMapper;
import team.weyoung.service.IContestantInfoService;
import team.weyoung.service.IVotingService;
import org.springframework.stereotype.Service;
import team.weyoung.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 投票表 服务层实现。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@Slf4j
@Service
public class VotingServiceImpl extends ServiceImpl<VotingMapper, Voting> implements IVotingService {

    @Resource
    private IContestantInfoService iContestantInfoService;

    @Resource
    private UserService userService;

    @Override
    public long addVote(Voting voting) {
        ContestantInfo contestantInfo = iContestantInfoService.getById(voting.getContestantId());
        // 1.判断是否是评委投票
        if (voting.getUserId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请先登录");
        }
        User currentUser = userService.getById(voting.getUserId());
        String userRole = currentUser.getUserRole();
        if (userRole.equals(UserConstant.DEFAULT_ROLE)) {
            // 普通用户投票
            contestantInfo.setScore(contestantInfo.getScore() + 1);
        } else {
            // 评委投票
            contestantInfo.setScore(contestantInfo.getScore() + 5);
        }
        // 2.添加投票记录
        this.save(voting);
        // 3.更新选手信息
        iContestantInfoService.updateById(contestantInfo);
        return voting.getVoteId();
    }
}
