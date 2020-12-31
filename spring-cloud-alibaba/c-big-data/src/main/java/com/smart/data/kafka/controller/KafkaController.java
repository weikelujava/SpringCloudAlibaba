package com.smart.data.kafka.controller;

import com.smart.data.kafka.config.KafkaProduce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @version V1.0
 * @title: KafkaController
 * @description:
 * @author: lukewei
 * @date: 2020-12-31 16:34
 * @remark: 修改内容
 */
@Slf4j
@RestController
public class KafkaController {

    @Autowired
    private KafkaProduce kafkaProduce;

    @GetMapping("/kafka/send")
    public void sendKafkaMessage(){
        String msg = "this is a test kafka topic message!";
        kafkaProduce.send(msg);
    }
}
