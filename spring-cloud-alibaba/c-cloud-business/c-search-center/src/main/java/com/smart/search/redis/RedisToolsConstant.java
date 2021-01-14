package com.smart.search.redis;

/**
 *
 * @version V1.0.0
 * @title: redis 工具常量
 * @description:
 * @author: hollysmart
 * @date: 2019/10/16 12:31
 * @remark:
 */
public class RedisToolsConstant {
    /**
     * single Redis
     */
    public final static int SINGLE = 1;
    /**
     * Redis cluster
     */
    public final static int CLUSTER = 2;

    private RedisToolsConstant() {
        throw new IllegalStateException("Utility class");
    }
}
