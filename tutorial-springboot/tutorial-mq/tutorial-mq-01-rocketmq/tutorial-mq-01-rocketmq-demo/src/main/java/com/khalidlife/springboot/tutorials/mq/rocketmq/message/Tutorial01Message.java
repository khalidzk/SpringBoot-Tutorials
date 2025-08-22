package com.khalidlife.springboot.tutorials.mq.rocketmq.message;

import lombok.Data;

/**
 * Tutorial01 的 Message 消息
 *
 * @author khalid
 */
@Data
public class Tutorial01Message {
    public static final String TOPIC = "TUTORIAL_01";

    /**
     * 编号
     */
    private Integer id;
}
