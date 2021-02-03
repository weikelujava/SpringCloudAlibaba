package com.smart.user.rabbitmq.pool;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *
 * @version V1.0
 * @title: ChannelFactory
 * @description:
 * @author: lukewei
 * @date: 2021-02-03 17:04
 * @remark: 修改内容
 */
public class ChannelFactory implements ObjectPoolFactory<Channel> {

    private static ChannelFactory instance;

    private final ConnectionFactory factory;
    private Connection connection;

    private ChannelFactory(){
        factory =new ConnectionFactory();

        factory.setHost("10.2.9.150");
        factory.setPort(5672);
        factory.setVirtualHost("/t");
        factory.setUsername("root");
        factory.setPassword("123456");
        factory.setConnectionTimeout(60);

        manageConnection();
    }

    public static ChannelFactory getInstance() {
        if (instance != null) {
            return instance;
        }

        synchronized (ChannelFactory.class) {
            if (instance != null) {
                return instance;
            }
            instance = new ChannelFactory();
            return instance;
        }
    }

    private Connection manageConnection() {
        if (connection != null && connection.isOpen()) {
            return connection;
        }

        synchronized (this) {
            if (connection != null && connection.isOpen()) {
                return connection;
            }

            try {
                connection = factory.newConnection();
            } catch (IOException | TimeoutException up) {
                throw new RuntimeException(up);
            }

            return connection;
        }
    }

    @Override
    public Channel create() {

        try {
            return manageConnection().createChannel();
        } catch (IOException up) {
            throw new RuntimeException(up);
        }
    }
}
