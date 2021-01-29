package com.smart.user;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.concurrent.atomic.AtomicInteger;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @version V1.0
 * @title: UserApplication
 * @description:
 * @author: lukewei
 * @date: 2020-09-30 10:06
 * @remark: 修改内容
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
