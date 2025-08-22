package com.khalidlife.springboot.tutorials.mq.rocketmq.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Tutorial03 的 顺序消息
 *
 * @author khalid
 */
@Accessors(chain = true)
@Data
public class Tutorial06Message {
    public static final String TOPIC = "TUTORIAL_06";

    /**
     * 编号
     */
    private Integer id;
}
