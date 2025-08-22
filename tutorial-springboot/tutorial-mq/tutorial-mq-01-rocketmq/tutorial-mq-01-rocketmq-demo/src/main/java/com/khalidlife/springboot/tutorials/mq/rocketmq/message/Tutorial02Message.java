package com.khalidlife.springboot.tutorials.mq.rocketmq.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Tutorial02 的 Message 消息
 *
 * @author khalid
 */
@Accessors(chain = true)
@Data
public class Tutorial02Message {
    public static final String TOPIC = "TUTORIAL_02";

    /**
     * 编号
     */
    private Integer id;
}
