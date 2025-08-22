package com.khalidlife.springboot.tutorials.mq.rocketmq.consumer;

import com.khalidlife.springboot.tutorials.mq.rocketmq.message.Tutorial06Message;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * tutorial06 顺序消息 消费者
 *
 * @author khalid
 */
@Component
@RocketMQMessageListener(
    topic = Tutorial06Message.TOPIC,
    consumerGroup = "tutorial05-A-consumer-group-" + Tutorial06Message.TOPIC,
    consumeMode = ConsumeMode.ORDERLY // 设置为广播消费
)
@Slf4j
public class Tutorial06AConsumer implements RocketMQListener<Tutorial06Message> {
    @Override
    public void onMessage(Tutorial06Message message) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);

        // sleep 2 秒，用于查看顺序消费的效果
        try {
            Thread.sleep(2 * 1000L);
        } catch (InterruptedException ignore) {
        }
    }
}
