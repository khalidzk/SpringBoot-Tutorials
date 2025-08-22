package com.khalidlife.springboot.tutorials.mq.rocketmq.producer;

import com.khalidlife.springboot.tutorials.mq.rocketmq.message.Tutorial03Message;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * 定时消息
 *
 * @author khalid
 */
@Component
public class Tutorial03Producer {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public SendResult syncSendDelay(Integer id, int delayLevel) {
        Message message = MessageBuilder.withPayload(new Tutorial03Message().setId(id)).build();
        // 同步发送消息
        return rocketMQTemplate.syncSend(Tutorial03Message.TOPIC, message, 30 * 1000, delayLevel);
    }

    public void asyncSendDelay(Integer id, int delayLevel, SendCallback sendCallback) {
        Message message = MessageBuilder.withPayload(new Tutorial03Message().setId(id)).build();
        // 异步发送消息
        rocketMQTemplate.asyncSend(Tutorial03Message.TOPIC, message, sendCallback, 30 * 1000, delayLevel);
    }

}
