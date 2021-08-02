//package com.smart.user.rabbitmq.direct.consumer;
//
//import com.rabbitmq.client.*;
//import lombok.SneakyThrows;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.concurrent.TimeoutException;
//
///**
// *
// * @version V1.0
// * @title: DirectConsumerTTL
// * @description:
// * @author: lukewei
// * @date: 2021-02-03 16:05
// * @remark: 修改内容
// */
//
//@Component
//public class DirectConsumerTTL {
//
//    @Autowired
//    private ConnectionFactory connectionFactory;
//
//    /**
//     * TTL3
//     * @throws IOException
//     * @throws TimeoutException
//     */
//    @PostConstruct
//    public void run() throws IOException, TimeoutException {
//
//        Connection connection = connectionFactory.newConnection();
//        Channel channel = connection.createChannel();
//        channel.queueDeclare("direct_one", false, false, false, null);
//
//
//        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
//            System.out.println(" [x] Received '" + message + "'");
//        };
//        channel.basicConsume("direct_one", true, deliverCallback, consumerTag -> { });
//    }
//}
