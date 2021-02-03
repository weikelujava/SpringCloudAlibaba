package com.smart.user.rabbitmq.direct.produce;

import com.rabbitmq.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 *
 * @version V1.0
 * @title: DirectProduceTTL
 * @description:
 * @author: lukewei
 * @date: 2021-02-03 15:27
 * @remark: 修改内容
 */

@RestController
public class DirectProduceTTL {



    @Autowired
    private ConnectionFactory connectionFactory;


    /**
     * TTL2
     * @return
     * @throws Exception
     */
    @RequestMapping("/direct/produce/ttl")
    public String produce() throws Exception {
        connectionFactory.setConnectionTimeout(60);
        Connection connection = null;
        Channel channel = null;
        try {
            connection = connectionFactory.newConnection();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
            return "connection created failed";
        }
        try {
            channel = connection.createChannel();
        } catch (IOException e) {
            e.printStackTrace();
            return "channel create failed";
        }

        channel.queueDeclare("direct_one", false, false, false, null);
        String msg = "hello rabbitmq";

        AMQP.BasicProperties properties = new AMQP.BasicProperties();

        Map<String,Object> headers = new HashMap<>();
        headers.put("name","rabbit");
        properties = properties.builder().contentEncoding("UTF-8").headers(headers).expiration("10000").build();


        channel.basicPublish("","direct_one",properties,msg.getBytes());

        channel.close();
        connection.close();

        return "发送成功";
    }
}
