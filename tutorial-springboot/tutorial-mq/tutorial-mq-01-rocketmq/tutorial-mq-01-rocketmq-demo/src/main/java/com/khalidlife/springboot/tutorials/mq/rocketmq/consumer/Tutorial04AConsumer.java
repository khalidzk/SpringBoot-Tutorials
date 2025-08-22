package com.khalidlife.springboot.tutorials.mq.rocketmq.consumer;

import com.khalidlife.springboot.tutorials.mq.rocketmq.message.Tutorial04Message;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * tutorial04 消费重试 消费者
 *
 * @author khalid
 */
@Component
@RocketMQMessageListener(
    topic = Tutorial04Message.TOPIC,
    consumerGroup = "tutorial04-A-consumer-group-" + Tutorial04Message.TOPIC)
@Slf4j
public class Tutorial04AConsumer implements RocketMQListener<Tutorial04Message> {
    @Override
    public void onMessage(Tutorial04Message messageExt) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), messageExt);

        // <X> 注意，此处抛出一个 RuntimeException 异常，模拟消费失败
        throw new RuntimeException("此处抛出一个 RuntimeException 异常，模拟消费失败");
    }
}
