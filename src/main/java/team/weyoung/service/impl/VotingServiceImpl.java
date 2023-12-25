package team.weyoung.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import team.weyoung.model.entity.Voting;
import team.weyoung.mapper.VotingMapper;
import team.weyoung.service.IVotingService;
import org.springframework.stereotype.Service;

/**
 * 投票表 服务层实现。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@Service
public class VotingServiceImpl extends ServiceImpl<VotingMapper, Voting> implements IVotingService {

}
