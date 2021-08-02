package com.smart.user.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lukewei
 * @date 2021/7/19 14:53
 */
@Slf4j
@RestController
public class RocketMqProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    @GetMapping("/rocketmq/send")
    public void sendMessage(){
        log.info("开始发送消息...");
        Message<String> message = new GenericMessage<>("hello user");
        rocketMQTemplate.convertAndSend("demo_user:stock",message);

    }

}
