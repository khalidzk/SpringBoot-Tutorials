package com.khalidlife.springboot.tutorials.mq.rocketmq.consumer;

import com.khalidlife.springboot.tutorials.mq.rocketmq.message.Tutorial01Message;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * tutorial01 消费者
 *
 * @author khalid
 */
@Component
@RocketMQMessageListener(
    topic = Tutorial01Message.TOPIC,
    consumerGroup = "tutorial01-A-consumer-group-" + Tutorial01Message.TOPIC)
@Slf4j
public class Tutorial01AConsumer implements RocketMQListener<MessageExt> {
    @Override
    public void onMessage(MessageExt messageExt) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), messageExt);
    }
}
