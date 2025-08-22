package com.khalidlife.springboot.tutorials.mq.rocketmq.consumer;

import com.khalidlife.springboot.tutorials.mq.rocketmq.message.Tutorial07Message;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * tutorial07 事务消息 消费者
 *
 * @author khalid
 */
@Component
@RocketMQMessageListener(
    topic = Tutorial07Message.TOPIC,
    consumerGroup = "tutorial05-A-consumer-group-" + Tutorial07Message.TOPIC,
    consumeMode = ConsumeMode.ORDERLY // 设置为广播消费
)
@Slf4j
public class Tutorial07AConsumer implements RocketMQListener<Tutorial07Message> {
    @Override
    public void onMessage(Tutorial07Message message) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
