package com.smart.demo.redis.controller;


import com.smart.demo.redis.model.UserTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author weike
 */
@Slf4j
@RestController
public class RedisController {

    private static final String ZSET_KEY = "zset_test";
    private static final String HASH_KEY = "hash_test";


    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @GetMapping("/redis/hash/add")
    public void hashTest(){
        redisTemplate.opsForHash().put(HASH_KEY+"1234","1000",true);
        redisTemplate.opsForHash().put(HASH_KEY+"1234","1001",false);

        redisTemplate.opsForZSet().add(HASH_KEY+"zset1001",3,System.currentTimeMillis());
        redisTemplate.opsForZSet().add(HASH_KEY+"zset1001",4,System.currentTimeMillis());

        redisTemplate.opsForList().leftPush(HASH_KEY+"123","1000");
        redisTemplate.opsForList().leftPush(HASH_KEY+"123","1001");


    }


    @GetMapping("/redis/hash/test")
    public void hashTest1(){
        Map<Object, Object> entries = redisTemplate.opsForHash().entries(HASH_KEY + "1234");
        Iterator<Map.Entry<Object, Object>> iterator = entries.entrySet().iterator();
        while (true){
            if(iterator.hasNext()){
                Map.Entry<Object, Object> next = iterator.next();
                String key =(String) next.getKey();
                Set<Object> objects = redisTemplate.opsForZSet().rangeByScore(key, 0, System.currentTimeMillis());
                objects.forEach((a)->{
                    System.out.println(a.toString());
                });
                continue;
            }
                break;
        }


    }


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

        Map<Integer,Integer> map3 = new HashMap<Integer, Integer>(1);
        map2.put(3001,3000);
        redisTemplate.opsForValue().set("kab",map3);


    }

    @GetMapping("/redis/set")
    public void zsetSetTest() throws InterruptedException {
        long begin = System.currentTimeMillis();

        redisTemplate.opsForHash().put("hkey","key","value");
        log.info("-----------------------------{}",System.currentTimeMillis()-begin);


    }

    @GetMapping("/redis/hash/set")
    public String zsetGetTest(){

        final String key = "test";
        String name = "zhangsan";
        UserTest  u1 = new UserTest();
        u1.setScore(90);
        u1.setSex("男");
        this.redisTemplate.opsForHash().put(key,name,u1);
        this.redisTemplate.expire(key,10, TimeUnit.MINUTES);
        UserTest  u2 = new UserTest();
        u2.setScore(75);
        u2.setSex("女");
        this.redisTemplate.opsForHash().put(key,"lisi",u2);
        this.redisTemplate.expire(key,20, TimeUnit.MINUTES);

        return "接口请求完成";
//        if (!StringUtils.hasText(key)) {
//            return;
//        }
//        redisTemplate.execute(new RedisCallback<Object>() {
//            @Override
//            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
//                byte[] lockBytes = redisTemplate.getStringSerializer().serialize(key);
//                assert lockBytes != null;
//                return redisConnection.setNX(lockBytes, lockBytes);
//            }
//        });


    }

    @GetMapping("/redis/hash/get")
    public void zsetGetTest1() throws IllegalAccessException, InstantiationException, InvocationTargetException {

//        List<Object> lists = redisTemplate.opsForHash().values("hash");
//
//        List<UserTest> userTests = copyPropertiesBySpring(UserTest.class, lists);
//        // 如果转成 List<UserTest>
//
//
//        for (UserTest list : userTests) {
//            System.out.println(list);
//        }
        // -2 不存在 , -1 存在
        Long test = redisTemplate.getExpire("test");
        System.out.println(test);


//        Object abcd = redisTemplate.execute(new RedisCallback<Object>() {
//            @Override
//            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
//                byte[] lockBytes = redisTemplate.getStringSerializer().serialize("test");
//                assert lockBytes != null;
//                return redisConnection.setNX(lockBytes, lockBytes);
//            }
//        });
//        System.out.println(abcd);

    }


    public static <T> List<T> copyPropertiesBySpring(Class<T> targetClazz, List<Object> sources)
            throws IllegalAccessException, InstantiationException {
        List<T> targets = new ArrayList<T>(sources.size());
        for(Object source: sources){
            T target = targetClazz.newInstance();
            BeanUtils.copyProperties(source, target);
            targets.add(target);
        }
        return targets;
    }


}
