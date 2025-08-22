package com.khalidlife.springboot.tutorials.mq.rocketmq.producer;

import com.khalidlife.springboot.tutorials.mq.rocketmq.message.Tutorial01Message;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 常规消息测试
 *
 * @author khalid
 */
@Component
public class Tutorial01Producer {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 同步发送消息
     *
     * @param id
     * @return
     */
    public SendResult syncSend(Integer id) {
        Tutorial01Message tutorial01Message = new Tutorial01Message();
        tutorial01Message.setId(id);
        // 同步发送消息
        return rocketMQTemplate.syncSend(Tutorial01Message.TOPIC, tutorial01Message);
    }

    /**
     * 异步发送消息
     *
     * @param id
     * @param callback
     */
    public void asyncSend(Integer id, SendCallback callback) {
        Tutorial01Message tutorial01Message = new Tutorial01Message();
        tutorial01Message.setId(id);
        // 异步发送消息
        rocketMQTemplate.asyncSend(Tutorial01Message.TOPIC, tutorial01Message, callback);
    }

    /**
     * Oneway发送消息
     *
     * @param id
     */
    public void onewaySend(Integer id) {
        Tutorial01Message tutorial01Message = new Tutorial01Message();
        tutorial01Message.setId(id);
        // oneway发送消息
        rocketMQTemplate.sendOneWay(Tutorial01Message.TOPIC, tutorial01Message);
    }
}
