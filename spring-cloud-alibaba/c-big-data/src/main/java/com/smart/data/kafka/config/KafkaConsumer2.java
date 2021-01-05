package com.smart.data.kafka.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 *
 * @version V1.0
 * @title: KafkaConsumer2
 * @description:  账单主题的消费者
 *                通过Flume收集日志信息，同时将该日志信息下发到Kafka
 *                其中Flume的配置信息，参考/resource目录下的flume.conf
 * @author: lukewei
 * @date: 2021-01-04 17:34
 * @remark: 修改内容
 */
@Slf4j
@Component
public class KafkaConsumer2 {

    @KafkaListener(topics = "bill_topic",groupId = "bill_groupId")
    public void topic_test(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {

        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            log.info("topic_test bill_topic 消费了： Topic:" + topic + ",Message:" + msg);
            ack.acknowledge();
        }
    }
}
