package com.khalidlife.springboot.tutorials.mq.rocketmq.consumer;

import com.khalidlife.springboot.tutorials.mq.rocketmq.message.Tutorial05Message;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * tutorial05 广播消费 消费者
 *
 * @author khalid
 */
@Component
@RocketMQMessageListener(
    topic = Tutorial05Message.TOPIC,
    consumerGroup = "tutorial05-A-consumer-group-" + Tutorial05Message.TOPIC,
    messageModel = MessageModel.BROADCASTING // 设置为广播消费
)
@Slf4j
public class Tutorial05AConsumer implements RocketMQListener<Tutorial05Message> {
    @Override
    public void onMessage(Tutorial05Message messageExt) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), messageExt);
    }
}
