package com.khalidlife.springboot.tutorials.mq.rocketmq.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Tutorial03 的 广播消费消息
 *
 * @author khalid
 */
@Accessors(chain = true)
@Data
public class Tutorial05Message {
    public static final String TOPIC = "TUTORIAL_05";

    /**
     * 编号
     */
    private Integer id;
}
