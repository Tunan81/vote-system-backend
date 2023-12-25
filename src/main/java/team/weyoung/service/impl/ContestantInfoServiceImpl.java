package team.weyoung.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import team.weyoung.model.entity.ContestantInfo;
import team.weyoung.mapper.ContestantInfoMapper;
import team.weyoung.service.IContestantInfoService;
import org.springframework.stereotype.Service;

/**
 * 选项信息表 服务层实现。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@Service
public class ContestantInfoServiceImpl extends ServiceImpl<ContestantInfoMapper, ContestantInfo> implements IContestantInfoService {

}
