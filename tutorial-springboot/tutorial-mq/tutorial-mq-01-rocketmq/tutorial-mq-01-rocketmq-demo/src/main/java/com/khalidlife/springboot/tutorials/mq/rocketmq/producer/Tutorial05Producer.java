package com.khalidlife.springboot.tutorials.mq.rocketmq.producer;

import com.khalidlife.springboot.tutorials.mq.rocketmq.message.Tutorial05Message;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 广播消费
 *
 * @author khalid
 */
@Component
public class Tutorial05Producer {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public SendResult syncSend(Integer id) {
        Tutorial05Message message = new Tutorial05Message().setId(id);
        // 同步发送消息
        return rocketMQTemplate.syncSend(Tutorial05Message.TOPIC, message);
    }
}
