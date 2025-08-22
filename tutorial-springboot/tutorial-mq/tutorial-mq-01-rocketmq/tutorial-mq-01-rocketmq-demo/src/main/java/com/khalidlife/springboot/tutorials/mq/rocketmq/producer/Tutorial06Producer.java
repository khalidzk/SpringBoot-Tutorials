package com.khalidlife.springboot.tutorials.mq.rocketmq.producer;

import com.khalidlife.springboot.tutorials.mq.rocketmq.message.Tutorial06Message;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 顺序消息
 *
 * @author khalid
 */
@Component
public class Tutorial06Producer {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public SendResult syncSendOrderly(Integer id) {
        // 创建 Tutorial06Message 消息
        Tutorial06Message message = new Tutorial06Message();
        message.setId(id);
        // 同步发送消息
        return rocketMQTemplate.syncSendOrderly(Tutorial06Message.TOPIC, message, String.valueOf(id));
    }

    public void asyncSendOrderly(Integer id, SendCallback callback) {
        // 创建 Tutorial06Message 消息
        Tutorial06Message message = new Tutorial06Message();
        message.setId(id);
        // 异步发送消息
        rocketMQTemplate.asyncSendOrderly(Tutorial06Message.TOPIC, message, String.valueOf(id), callback);
    }

    public void onewaySendOrderly(Integer id) {
        // 创建 Tutorial06Message 消息
        Tutorial06Message message = new Tutorial06Message();
        message.setId(id);
        // 异步发送消息
        rocketMQTemplate.sendOneWayOrderly(Tutorial06Message.TOPIC, message, String.valueOf(id));
    }
}
