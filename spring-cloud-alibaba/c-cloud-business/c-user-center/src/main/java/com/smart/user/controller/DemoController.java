package com.smart.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: DemoController
 * @description:
 * @author: lukewei
 * @date: 2020-10-16 9:36
 * @remark: 修改内容
 */
@Slf4j
@RestController
public class DemoController {

    @GetMapping("/demo")
    public String testSendHttpRequestToNnginx(){

        String baseUrl = "https://bbbb.xxx.com/delcache?target=product_detail&&type=pc-mobile&&target_id=10190&&re_target=category_detail&&re_target_id=10052";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        try {
            String result = restTemplate.getForObject(new URI(baseUrl), String.class);
            log.info("访问结果："+ result);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "发送成功";
    }
}
