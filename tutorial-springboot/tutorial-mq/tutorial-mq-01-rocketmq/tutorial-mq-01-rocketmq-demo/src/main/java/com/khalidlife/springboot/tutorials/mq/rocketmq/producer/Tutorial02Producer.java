package com.khalidlife.springboot.tutorials.mq.rocketmq.producer;

import com.khalidlife.springboot.tutorials.mq.rocketmq.message.Tutorial02Message;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * 批量发送消息
 *
 * @author khalid
 */
@Component
public class Tutorial02Producer {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 批量发送消息
     *
     * @param ids
     */
    public SendResult sendBatch(Collection<Integer> ids) {
        // 创建多条 Tutorial02Message 消息
        List<Message> messages = new ArrayList<>(ids.size());
        for (Integer id : ids) {
            // 创建 Tutorial02Message 消息
            Tutorial02Message message = new Tutorial02Message().setId(id);
            // 构建 Spring Messaging 定义的 Message 消息
            messages.add(MessageBuilder.withPayload(message).build());
        }
        // 异步发送消息
        return rocketMQTemplate.syncSend(Tutorial02Message.TOPIC, messages, 30 * 1000L);
    }

}
