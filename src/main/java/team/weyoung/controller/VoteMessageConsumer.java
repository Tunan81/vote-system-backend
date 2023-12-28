package team.weyoung.controller;

import com.rabbitmq.client.Channel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import team.weyoung.constant.RabbitMQConstant;
import team.weyoung.model.entity.Voting;
import team.weyoung.service.IVotingService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class VoteMessageConsumer {

    @Resource
    private IVotingService iVotingService;

    @SneakyThrows
    @RabbitListener(queues = RabbitMQConstant.QUEUE_VOTE, ackMode = "MANUAL")
    public long receiveMessage(Voting voting, HttpServletRequest request,
                               Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) {
        try {
            long result = iVotingService.addVote(voting,request);
            // 消息消费成功 手动确认
            channel.basicAck(deliveryTag, false);
            return result;
        } catch (Exception e) {
            // 消息消费失败
            log.error("消息消费失败", e);
            // 消息消费失败，将消息重新放回队列
            channel.basicNack(deliveryTag, false, false);
            return 0;
        }
    }
}
