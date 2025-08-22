package com.khalidlife.springboot.tutorials.mq.rocketmq.producer;

import com.khalidlife.springboot.tutorials.mq.rocketmq.TutorialRocketmqRocketmqDemoApplication;

import java.util.concurrent.CountDownLatch;

import org.apache.rocketmq.client.producer.SendResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Tutorial05 广播消费 测试类
 *
 * @author khalid
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TutorialRocketmqRocketmqDemoApplication.class)
@Slf4j
public class Tutorial05ProducerTest {
    @Autowired
    private Tutorial05Producer producer;

    @Test
    public void test() throws InterruptedException {
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testSyncSend() throws InterruptedException {
        int id = RandomUtil.randomInt();
        SendResult sendResult = producer.syncSend(id);
        log.info("[testSyncSend][发送编号：[{}] 发送结果：[{}]]", id, sendResult);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

}
