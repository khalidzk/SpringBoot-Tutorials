package com.khalidlife.springboot.tutorials.mq.rocketmq.producer;

import com.khalidlife.springboot.tutorials.mq.rocketmq.TutorialRocketmqRocketmqDemoApplication;

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
 * Tutorial01测试类
 *
 * @author khalid
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TutorialRocketmqRocketmqDemoApplication.class)
@Slf4j
public class Tutorial01ProducerTest {
    @Autowired
    private Tutorial01Producer producer;

    @Test
    public void testSyncSend() throws InterruptedException {
        int id = RandomUtil.randomInt();
        SendResult sendResult = producer.syncSend(id);
        log.info("[testSyncSend][发送编号：[{}] 发送结果：[{}]]", id, sendResult);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testAsyncSend() throws InterruptedException {
        int id = RandomUtil.randomInt();
        producer.asyncSend(id, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("[testAsyncSend][发送编号：[{}] 发送success, 结果：[{}]]", id, sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                log.info("[testAsyncSend][发送编号：[{}] 发送异常]]", id, throwable);
            }
        });

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testOnewaySend() throws InterruptedException {
        int id = RandomUtil.randomInt();
        producer.onewaySend(id);
        log.info("[testOnewaySend][发送编号：[{}] 发送成功]", id);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
