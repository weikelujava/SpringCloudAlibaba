package com.smart.user.rabbitmq.direct.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.smart.user.rabbitmq.pool.ChannelFactory;
import com.smart.user.rabbitmq.pool.Queue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 *
 * @version V1.0
 * @title: DirectConsumerTest
 * @description:
 * @author: lukewei
 * @date: 2021-02-03 17:39
 * @remark: 修改内容
 */
public class DirectConsumerTest {

    public static void main(String[] args) throws IOException {
        Channel channel = ChannelFactory.getInstance().create();

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");
        };

        channel.basicConsume(Queue.HELLO.getName(), true, deliverCallback, consumerTag -> { });
    }
}
