package com.khalidlife.springboot.tutorials.mq.rocketmq.consumer;

import com.khalidlife.springboot.tutorials.mq.rocketmq.message.Tutorial03Message;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * tutorial03 定时消息 消费者
 *
 * @author khalid
 */
@Component
@RocketMQMessageListener(
    topic = Tutorial03Message.TOPIC,
    consumerGroup = "tutorial03-A-consumer-group-" + Tutorial03Message.TOPIC)
@Slf4j
public class Tutorial03AConsumer implements RocketMQListener<Tutorial03Message> {
    @Override
    public void onMessage(Tutorial03Message messageExt) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), messageExt);
    }
}
