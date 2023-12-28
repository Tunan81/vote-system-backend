package team.weyoung.constant;

/**
 * 此类包含与 RabbitMQ 配置相关的常量。
 */
public interface RabbitMQConstant {

    String EXCHANGE_VOTE_DIRECT = "tunan.vote.direct";

    String QUEUE_VOTE = "tunan.vote.queue";

    String ROUTING_VOTE = "tunan.vote.routing";
}