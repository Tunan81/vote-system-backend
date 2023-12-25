package team.weyoung.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import team.weyoung.model.entity.MatchInfo;
import team.weyoung.mapper.MatchInfoMapper;
import team.weyoung.service.IMatchInfoService;
import org.springframework.stereotype.Service;

/**
 * 对战信息表 服务层实现。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@Service
public class MatchInfoServiceImpl extends ServiceImpl<MatchInfoMapper, MatchInfo> implements IMatchInfoService {

}
