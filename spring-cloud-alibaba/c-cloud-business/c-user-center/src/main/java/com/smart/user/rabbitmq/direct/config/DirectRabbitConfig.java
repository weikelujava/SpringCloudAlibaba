package com.smart.user.rabbitmq.direct.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @version V1.0
 * @title: DirectRabbitConfig
 * @description:
 * @author: lukewei
 * @date: 2021-02-03 14:45
 * @remark: 修改内容
 */
@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue DirectQueueOne(){
        return new Queue("direct_one",true);
    }

    @Bean
    public DirectExchange DirectExchange(){
        return new DirectExchange("direct_exchange",true,false);
    }

    @Bean
    public Binding bindingDirectQueueOneToDirectExchange(){
        return BindingBuilder.bind(DirectQueueOne()).to(DirectExchange()).with("direct_routing_key");
    }


    @Bean
    public Queue DirectQueueTwo(){
        return new Queue("direct_two",true);
    }
}
