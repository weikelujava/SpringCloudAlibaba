package com.smart.search.redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @version V1.0.0
 * @title: CacheManagerProperties
 * @description:
 * @author: hollysmart
 * @date: 2019/10/16 12:31
 * @remark:
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "spring.redis.cache-manager")
public class CacheManagerProperties {
    private List<CacheConfig> configs;

    @Setter
    @Getter
    public static class CacheConfig {
        /**
         * cache key
         */
        private String key;
        /**
         * 过期时间，sec
         */
        private long second = 60;
    }
}
