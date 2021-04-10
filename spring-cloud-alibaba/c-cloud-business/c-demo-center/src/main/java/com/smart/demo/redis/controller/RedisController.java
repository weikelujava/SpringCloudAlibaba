package com.smart.demo.redis.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author weike
 */
@Slf4j
@RestController
public class RedisController {

    private static final String ZSET_KEY = "zset_test";


    @Resource
    private RedisTemplate<String, Map<Integer, Integer>> redisTemplate;


    @GetMapping("/redis/add")
    public void zsetTest() throws InterruptedException {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>(1);
        map.put(1001,2000);
        log.info("------------------------------------------------------------");
        redisTemplate.opsForZSet().add(ZSET_KEY,map,System.currentTimeMillis());
        Thread.sleep(2000);
        Map<Integer,Integer> map1 = new HashMap<Integer, Integer>(1);
        map1.put(1002,2000);
        redisTemplate.opsForZSet().add(ZSET_KEY,map1,System.currentTimeMillis());

        Map<Integer,Integer> map2 = new HashMap<Integer, Integer>(1);
        map2.put(3001,3000);
        redisTemplate.opsForZSet().add(ZSET_KEY,map2,System.currentTimeMillis());

    }

    @GetMapping("/redis/get")
    public void zsetGetTest(){

        log.info("-------------------------------------------------");

        Set<ZSetOperations.TypedTuple<Map<Integer, Integer>>> r4 = redisTemplate.opsForZSet().reverseRangeByScoreWithScores(ZSET_KEY, 0, System.currentTimeMillis(), 1, 2);
        if(null != r4){
            Iterator<ZSetOperations.TypedTuple<Map<Integer, Integer>>> iterator = r4.iterator();
            if(iterator.hasNext()){
                log.info("value:{},score:{}",iterator.next().getValue(),iterator.next().getScore());
            }
        }


        log.info("-------------------------------------------------");
        Long count = redisTemplate.opsForZSet().count(ZSET_KEY, 0, System.currentTimeMillis());
        log.info("count:{}",count);
        Set<Map<Integer, Integer>> r3 = redisTemplate.opsForZSet().reverseRangeByScore(ZSET_KEY, 0, System.currentTimeMillis(),0,4);
        if(null != r3){
            Iterator<Map<Integer, Integer>> iterator = r3.iterator();
            while (iterator.hasNext()){
                log.info("value:{}",iterator.next());
            }
        }
        log.info("-------------------------------------------------");


//        Set<Map<Integer, Integer>> r1 = redisTemplate.opsForZSet().range(ZSET_KEY, 0, -1);
//        if(null != r1){
//            Iterator<Map<Integer, Integer>> iterator = r1.iterator();
//            while (iterator.hasNext()){
//                log.info("r1:{}",iterator.next());
//            }
//        }
//
//        log.info("-------------------------------------------------");
//
//        Set<ZSetOperations.TypedTuple<Map<Integer, Integer>>> typedTuples = redisTemplate.opsForZSet().rangeWithScores(ZSET_KEY, 0, -1);
//        if(null != typedTuples){
//            Iterator<ZSetOperations.TypedTuple<Map<Integer, Integer>>> iterator = typedTuples.iterator();
//            while (iterator.hasNext()){
//                log.info("value:{},score:{}",iterator.next().getValue(),iterator.next().getScore());
//            }
//        }
    }
}
