package team.weyoung.config;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import team.weyoung.constant.RabbitMQConstant;

import javax.annotation.PostConstruct;

/**
 * This class is responsible for initializing the RabbitMQ connection and setting up the necessary exchange and queue.
 * It is annotated with @Component to be automatically detected by Spring for dependency injection.
 *
 * @author Tunan
 * @version 1.0
 * @since 2023/12/19
 */
@Slf4j
@Component
public class InitRabbitMqBean {

    // The host for the RabbitMQ server. The default value is "localhost".
    @Value("${spring.rabbitmq.host:localhost}")
    private String host;

    /**
     * 该方法负责初始化RabbitMQ连接，声明交换和队列，并将队列绑定到交换。
     * 它被注解为@PostConstruct，在Spring完成依赖注入后自动执行。
     */
    @PostConstruct
    public void doInit() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(host);
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.basicQos(200);
            channel.exchangeDeclare(RabbitMQConstant.EXCHANGE_VOTE_DIRECT, "direct");
            channel.queueDeclare(RabbitMQConstant.QUEUE_VOTE, true, false, false, null);
            channel.queueBind(RabbitMQConstant.QUEUE_VOTE, RabbitMQConstant.EXCHANGE_VOTE_DIRECT, RabbitMQConstant.ROUTING_VOTE);
            log.info("初始化rabbitmq成功");
        } catch (Exception e) {
            log.error("初始化rabbitmq失败", e);
        }
    }
}