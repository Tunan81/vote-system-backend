package team.weyoung.controller;

import com.mybatisflex.core.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import team.weyoung.common.ErrorCode;
import team.weyoung.common.Result;
import team.weyoung.constant.RabbitMQConstant;
import team.weyoung.controller.rabbitmq.MyMessageProducer;
import team.weyoung.exception.BusinessException;
import team.weyoung.model.dto.VotingMessage;
import team.weyoung.model.entity.Voting;
import team.weyoung.service.IVotingService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 投票表 控制层。
 *
 * @author TuNan
 * @since 2023-12-25
 */
@Slf4j
@RestController
@RequestMapping("/voting")
public class VotingController {

    @Resource
    private IVotingService iVotingService;

    @Resource
    private MyMessageProducer myMessageProducer;

    @PostMapping("/add")
    public Result<Boolean> addVote(@RequestBody Voting voting, HttpServletRequest request) {
        if (voting == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Voting voting1 = iVotingService.getOne(new QueryWrapper()
                .eq("user_id", voting.getUserId())
                .eq("contestant_id", voting.getContestantId()));
        if (voting1 != null) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "已经投过票了");
        }
        //long result = iVotingService.addVote(voting, request);
        myMessageProducer.sendMessage(RabbitMQConstant.EXCHANGE_VOTE_DIRECT, RabbitMQConstant.ROUTING_VOTE, voting);
        return Result.success(true);
    }

}
