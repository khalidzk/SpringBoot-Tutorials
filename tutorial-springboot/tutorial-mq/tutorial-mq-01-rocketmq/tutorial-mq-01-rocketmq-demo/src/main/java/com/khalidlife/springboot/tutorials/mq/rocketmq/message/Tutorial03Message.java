package com.khalidlife.springboot.tutorials.mq.rocketmq.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Tutorial03 的 定时消息
 *
 * @author khalid
 */
@Accessors(chain = true)
@Data
public class Tutorial03Message {
    public static final String TOPIC = "TUTORIAL_03";

    /**
     * 编号
     */
    private Integer id;
}
