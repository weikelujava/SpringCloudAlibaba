package com.smart.user.rabbitmq.direct.config;

import com.rabbitmq.client.Channel;
import com.smart.user.rabbitmq.pool.ChannelFactory;
import com.smart.user.rabbitmq.pool.ObjectPool;
import com.smart.user.rabbitmq.pool.ObjectPoolFactory;

/**
 *
 * @version V1.0
 * @title: ChannelPool
 * @description:
 * @author: lukewei
 * @date: 2021-02-03 17:15
 * @remark: 修改内容
 */
public class ChannelPool extends ObjectPool<Channel> {

    private static final int POOL_SIZE = 10;

    private static ChannelPool instance = null;

    private ChannelPool(ObjectPoolFactory<Channel> factory, int poolSize) {
        super(factory, poolSize);
    }

    public static ChannelPool getInstance() {
        if (instance != null) {
            return instance;
        }

        synchronized (ChannelPool.class) {
            if (instance != null) {
                return instance;
            }
            instance = new ChannelPool(ChannelFactory.getInstance(), POOL_SIZE);
            return instance;
        }
    }


    @Override
    protected boolean validate(Channel channel) {
        return channel != null && channel.isOpen();
    }
}
