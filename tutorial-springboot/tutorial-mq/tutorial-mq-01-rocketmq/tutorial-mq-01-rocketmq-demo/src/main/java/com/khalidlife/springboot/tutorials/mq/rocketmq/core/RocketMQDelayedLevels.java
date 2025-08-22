package com.khalidlife.springboot.tutorials.mq.rocketmq.core;

/**
 * RocketMQ 延迟级别与时间对应表
 *
 * <pre>
 * 延迟级别    时间        延迟级别    时间        延迟级别    时间
 * -----------------------------------------------
 * 1         1s         7         3m          13        9m
 * 2         5s         8         4m          14        10m
 * 3         10s        9         5m          15        20m
 * 4         30s        10        6m          16        30m
 * 5         1m         11        7m          17        1h
 * 6         2m         12        8m          18        2h
 * </pre>
 *
 * 使用示例：
 * {@code
 * Message msg = new Message("TestTopic", "Hello RocketMQ".getBytes());
 * // 设置延迟级别为 3（10秒后投递）
 * msg.setDelayTimeLevel(3);
 * }
 *
 * 注意：延迟级别是预定义的，不支持自定义时间
 */
public class RocketMQDelayedLevels {
    // 延迟级别常量定义
    public static final int LEVEL_1 = 1;  // 1秒
    public static final int LEVEL_2 = 2;  // 5秒
    public static final int LEVEL_3 = 3;  // 10秒
    public static final int LEVEL_4 = 4;  // 30秒
    public static final int LEVEL_5 = 5;  // 1分钟
    public static final int LEVEL_6 = 6;  // 2分钟
    public static final int LEVEL_7 = 7;  // 3分钟
    public static final int LEVEL_8 = 8;  // 4分钟
    public static final int LEVEL_9 = 9;  // 5分钟
    public static final int LEVEL_10 = 10; // 6分钟
    public static final int LEVEL_11 = 11; // 7分钟
    public static final int LEVEL_12 = 12; // 8分钟
    public static final int LEVEL_13 = 13; // 9分钟
    public static final int LEVEL_14 = 14; // 10分钟
    public static final int LEVEL_15 = 15; // 20分钟
    public static final int LEVEL_16 = 16; // 30分钟
    public static final int LEVEL_17 = 17; // 1小时
    public static final int LEVEL_18 = 18; // 2小时
}
