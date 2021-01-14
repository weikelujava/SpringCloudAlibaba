package com.smart.search.controller;

import com.smart.search.redis.RedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 *
 * @version V1.0
 * @title: RedisController
 * @description:
 * @author: lukewei
 * @date: 2021-01-14 10:24
 * @remark: 修改内容
 *
 * zadd: 添加元素，格式：zadd zset的key score值 项的值，Score和项可以是多对，Score可以是整数,也可以是浮点数，还可以是+inf表示无穷大，-inf表示负无穷大
 * zrang：获取元素索引区间的元素，格式是：zrang zset的key，起始索引，终止索引 (whitscore)
 * zrangbyscore: 获取分数区间内的元素，格式是：zrangbyscore zset的key 起始score，终止score(withscore),默认是包含端点值的，如果加上"("表示不包含，后面还可以加上limit来限制
 * zrem: 删除元素，格式是：zrem zset的key项的值，项的值可以是多个
 * zcard: 获取集合中元素个数，格式是：zcard zset的key
 * zincrby: 增减元素的score,格式是：zincrby zset的key 正负数字 项的值
 * zcount: 获取分数区间内元素的个数，格式是： zcount zset的key,起始score 终止score
 * zrank: 获取项在zset中的索引，格式是：zrank zset的key 项的值
 * zscore: 获取元素的分数，格式是： zscore zset的key 项的值，返回项在zset中的score
 * zrevrank: 获取项在zset中倒叙的索引，格式是：zrevrank zset的key 项的值
 * zrevrange: 获取索引区间的元素，格式是：zrevrange zset的key 项的值
 * zrevrangebysocre: 获取分数区间内的元素，格式是：zrevrangebyscore zset的key 终止score 起始score(withscore)
 * zremrangebyrank: 删除索引区间内的元素，格式是：zremarangebyrank zset的key 起始索引 终止索引
 * zremrangbysocre: 删除分数区间内的元素，格式是：zremrangebysocre zset的key 起始score 终止score
 * 交集
 *
 */
@Slf4j
@RestController
@RequestMapping("/redis")
public class RedisController {


    @Autowired
    private RedisRepository redisRepository;


    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    
    private static final String ZSET_KEY = "zset_test";




    @RequestMapping("/zset/add")
    public void zSetAdd(){
        log.info("------------------------------------------------------------");
        Long removeRange = redisTemplate.opsForZSet().removeRange(ZSET_KEY, 0, -1);
        log.info("清理缓存元素数量："+removeRange);

        ZSetOperations.TypedTuple<Object> tuple = new DefaultTypedTuple<Object>("i have a dream",1.2);
        ZSetOperations.TypedTuple<Object> tuple1 = new DefaultTypedTuple<Object>("i have a dream too",1.3);
        ZSetOperations.TypedTuple<Object> tuple2 = new DefaultTypedTuple<Object>("just",1.4);
        ZSetOperations.TypedTuple<Object> tuple3 = new DefaultTypedTuple<Object>("just do it",1.5);
        Set<ZSetOperations.TypedTuple<Object>> tupleSet = new HashSet<>();
        tupleSet.add(tuple);
        tupleSet.add(tuple1);
        tupleSet.add(tuple2);
        tupleSet.add(tuple3);
        redisTemplate.opsForZSet().add(ZSET_KEY,tupleSet);
        
        redisTemplate.opsForZSet().add(ZSET_KEY,"single add",0.8);
        log.info("------------------------------------------------------------");
        Long count = redisTemplate.opsForZSet().size(ZSET_KEY);
        log.info("有序集合中的元素数量："+count);
        log.info("------------------------------------------------------------");
        Set<Object> range = redisTemplate.opsForZSet().range(ZSET_KEY, 0, -1);
        if(null != range && range.size() > 0){
            for (Object o : range) {
                log.info("range 有序集合中的元素：" + o.toString());
            }
        }

        log.info("------------------------------------------------------------");

        Set<Object> reverseRange = redisTemplate.opsForZSet().reverseRange(ZSET_KEY, 1, 2);
        if(null != reverseRange && reverseRange.size() > 0){
            for (Object o : reverseRange) {
                log.info("reverseRange 有序集合中的元素：" + o.toString());
            }
        }
        log.info("------------------------------------------------------------");

        Cursor<ZSetOperations.TypedTuple<Object>> scan = redisTemplate.opsForZSet().scan(ZSET_KEY, ScanOptions.NONE);
        while (scan.hasNext()){
            ZSetOperations.TypedTuple<Object> next = scan.next();
            log.info("scan: "+next.getValue()+" : "+next.getScore());
        }
        log.info("------------------------------------------------------------");
    }
}
