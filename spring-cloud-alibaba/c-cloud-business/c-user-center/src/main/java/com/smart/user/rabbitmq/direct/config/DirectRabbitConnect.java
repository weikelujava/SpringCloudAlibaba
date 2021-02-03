package com.smart.user.rabbitmq.direct.config;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *
 * @version V1.0
 * @title: DirectRabbitConnect
 * @description:
 * @author: lukewei
 * @date: 2021-02-03 15:22
 * @remark: 修改内容
 */
@Component
public class DirectRabbitConnect {


    /**
     * TTL1
     * @return
     */
    @Bean
    public ConnectionFactory connectionFactory(){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("10.2.9.150");
        factory.setPort(5672);
        factory.setVirtualHost("/t");
        factory.setUsername("root");
        factory.setPassword("123456");
        factory.setConnectionTimeout(60);
        return factory;
    }
}
