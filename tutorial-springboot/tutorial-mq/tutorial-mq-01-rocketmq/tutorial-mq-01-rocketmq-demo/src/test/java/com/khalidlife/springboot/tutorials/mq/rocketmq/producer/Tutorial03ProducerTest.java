package com.khalidlife.springboot.tutorials.mq.rocketmq.producer;

import com.khalidlife.springboot.tutorials.mq.rocketmq.TutorialRocketmqRocketmqDemoApplication;
import com.khalidlife.springboot.tutorials.mq.rocketmq.core.RocketMQDelayedLevels;

import java.util.concurrent.CountDownLatch;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Tutorial03 延时消息 测试类
 *
 * @author khalid
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TutorialRocketmqRocketmqDemoApplication.class)
@Slf4j
public class Tutorial03ProducerTest {
    @Autowired
    private Tutorial03Producer producer;

    @Test
    public void testSyncSendDelay() throws InterruptedException {
        int id = RandomUtil.randomInt();
        SendResult sendResult = producer.syncSendDelay(id, RocketMQDelayedLevels.LEVEL_3);// 延迟级别 3 ，即 10秒后消费
        log.info("[testSyncSendDelay][发送编号：[{}] 发送结果：[{}]]", id, sendResult);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testAsyncSendDelay() throws InterruptedException {
        int id = RandomUtil.randomInt();
        producer.asyncSendDelay(id, RocketMQDelayedLevels.LEVEL_4, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("[testAsyncSendDelay][发送编号：[{}] 发送success, 结果：[{}]]", id, sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                log.info("[testAsyncSendDelay][发送编号：[{}] 发送异常]]", id, throwable);
            }
        });

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

}
