package team.weyoung.service;

import com.mybatisflex.core.service.IService;
import team.weyoung.model.entity.Voting;

import javax.servlet.http.HttpServletRequest;

/**
 * 投票表 服务层。
 *
 * @author TuNan
 * @since 2023-12-25
 */
public interface IVotingService extends IService<Voting> {

    long addVote(Voting voting, HttpServletRequest request);
}
