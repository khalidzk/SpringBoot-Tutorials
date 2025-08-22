package com.khalidlife.springboot.tutorials.mq.rocketmq.producer;

import com.khalidlife.springboot.tutorials.mq.rocketmq.message.Tutorial04Message;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消费重试
 *
 * @author khalid
 */
@Component
public class Tutorial04Producer {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public SendResult syncSend(Integer id) {
        Tutorial04Message message = new Tutorial04Message().setId(id);
        // 同步发送消息
        return rocketMQTemplate.syncSend(Tutorial04Message.TOPIC, message);
    }
}
