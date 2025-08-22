package com.khalidlife.springboot.tutorials.mq.rocketmq.consumer;

import com.khalidlife.springboot.tutorials.mq.rocketmq.message.Tutorial02Message;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * tutorial02 批量发送消息 消费者
 *
 * @author khalid
 */
@Component
@RocketMQMessageListener(
    topic = Tutorial02Message.TOPIC,
    consumerGroup = "tutorial02-A-consumer-group-" + Tutorial02Message.TOPIC)
@Slf4j
public class Tutorial02AConsumer implements RocketMQListener<Tutorial02Message> {
    @Override
    public void onMessage(Tutorial02Message messageExt) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), messageExt);
    }
}
