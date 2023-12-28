package team.weyoung.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import team.weyoung.model.entity.Voting;

import javax.annotation.Resource;

/**
 * @author <a href="https://gitee.com/xia-haike">图南</a>
 * @version 1.0
 * @since 2023/11/11
 */
@Component
public class MyMessageProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String exchange, String routingKey, Voting voting) {
        System.out.println("消息发送成功");
        rabbitTemplate.convertAndSend(exchange, routingKey, voting);
    }
}
