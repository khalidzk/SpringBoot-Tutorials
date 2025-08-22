package com.khalidlife.springboot.tutorials.mq.rocketmq.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Tutorial03 的 消费重试消息
 *
 * @author khalid
 */
@Accessors(chain = true)
@Data
public class Tutorial04Message {
    public static final String TOPIC = "TUTORIAL_04";

    /**
     * 编号
     */
    private Integer id;
}
