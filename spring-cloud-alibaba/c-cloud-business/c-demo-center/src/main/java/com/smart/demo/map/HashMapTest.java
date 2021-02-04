package com.smart.demo.map;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @version V1.0
 * @title: HashMapTest
 * @description:
 * @author: lukewei
 * @date: 2021-02-04 9:32
 * @remark: 修改内容
 */
public class HashMapTest {

    public static void main(String[] args) {


        Map<String,String> map = new HashMap<>();
        map.put("name","hashmap");

        System.out.println(map.get("name"));
    }
}
