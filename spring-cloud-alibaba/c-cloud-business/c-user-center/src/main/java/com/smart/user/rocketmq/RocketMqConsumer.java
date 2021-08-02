package com.smart.user.rocketmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author lukewei
 * @date 2021/7/19 15:04
 */
@Component
@RocketMQMessageListener(topic = "demo_order",consumerGroup = "demo_topic",selectorExpression = "stock")
public class RocketMqConsumer implements RocketMQListener<String>{


        @Override
        public void onMessage(String message) {
            System.out.println(message);
        }
}
