package com.smart.search;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @version V1.0
 * @title: SearchApplication
 * @description:
 * @author: lukewei
 * @date: 2020-12-28 15:43
 * @remark: 修改内容
 */
@MapperScan(basePackages = "com.smart.search.mapper")
//@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.smart.search.feign")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SearchApplication {

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(SearchApplication.class,args);
    }
}
