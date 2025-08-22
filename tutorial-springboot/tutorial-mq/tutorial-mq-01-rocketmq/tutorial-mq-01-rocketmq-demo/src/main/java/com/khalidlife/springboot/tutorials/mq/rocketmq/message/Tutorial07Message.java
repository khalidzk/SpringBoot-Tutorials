package com.khalidlife.springboot.tutorials.mq.rocketmq.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Tutorial03 的 事务消息
 *
 * @author khalid
 */
@Accessors(chain = true)
@Data
public class Tutorial07Message {
    public static final String TOPIC = "TUTORIAL_07";

    /**
     * 编号
     */
    private Integer id;
}
