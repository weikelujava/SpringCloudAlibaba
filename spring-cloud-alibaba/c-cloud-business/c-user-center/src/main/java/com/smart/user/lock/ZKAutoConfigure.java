package com.smart.user.lock;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @version V1.0
 * @title: a
 * @description:
 * @author: lukewei
 * @date: 2021-01-25 14:12
 * @remark: 修改内容
 */
@Configuration
@AutoConfigureAfter(ZKServer.class)
public class ZKAutoConfigure {

    @Bean
    @ConditionalOnBean(CuratorFramework.class)
    public ZkClient createZKClient(){
        return new ZkClientImpl();
    }
}
