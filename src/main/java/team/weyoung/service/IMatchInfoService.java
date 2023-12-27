package team.weyoung.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;
import team.weyoung.model.dto.matchInfo.MatchInfoQueryRequest;
import team.weyoung.model.vo.MatchInfoVO;
import team.weyoung.model.entity.MatchInfo;

/**
 * 对战信息表 服务层。
 *
 * @author TuNan
 * @since 2023-12-25
 */
public interface IMatchInfoService extends IService<MatchInfo> {

    Page<MatchInfoVO> listMatchInfo(MatchInfoQueryRequest matchInfoQueryRequest);
}
