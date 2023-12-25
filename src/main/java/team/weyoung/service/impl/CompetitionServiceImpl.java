package team.weyoung.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import team.weyoung.model.entity.Competition;
import team.weyoung.mapper.CompetitionMapper;
import team.weyoung.service.ICompetitionService;
import org.springframework.stereotype.Service;

/**
 * 比赛表 服务层实现。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@Service
public class CompetitionServiceImpl extends ServiceImpl<CompetitionMapper, Competition> implements ICompetitionService {

}
