package com.smart.search.redis.bitmap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.BitSet;

/**
 *
 * @version V1.0
 * @title: BitMapTest
 * @description:
 * @author: lukewei
 * @date: 2021-02-04 17:30
 * @remark: 修改内容
 */
@Component
public class BitMapTest {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @GetMapping("/redis/bitmap")
    public void bitmap(){
        BitSet bitSet = new BitSet();
        bitSet.set(1);
    }

    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        bitSet.set(1);
        bitSet.set(2200123);
        System.out.println(bitSet.get(0));
        System.out.println(bitSet.get(1));
        System.out.println(bitSet.get(2));
        System.out.println(bitSet.get(2200123));
    }
}
