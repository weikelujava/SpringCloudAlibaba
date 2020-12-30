package com.smart.demo.streamlist.controller;

import com.smart.demo.streamlist.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @version V1.0
 * @title: StreamListController
 * @description:  JDK8新特性 Stream流的使用Demo
 * @author: lukewei
 * @date: 2020-11-21 10:34
 * @remark: 修改内容
 */
@Slf4j
@RestController
public class StreamListController {


    /**
     * 将List转Map
     * 场景：
     *      比如一个商品列表中，包含所有的商品属性，商品属性定义的为商品ID和商品所属的品牌ID
     *      然后将商品列表转成Map,键为品牌ID，值为商品ID
     *      将List转成Map
     * @return
     */
    @GetMapping("/stream/list-map")
    public Object listConvertMap(){
        List<Product> list = Arrays.asList(new Product(11311,10343),
                new Product(11324,10343));

        Map<Integer,List<Integer>> map = new HashMap<>();
        map.put(10343,Arrays.asList(11311,11324));

        log.info(map.toString());

        Map<Integer, List<Integer>> map2 = list.stream().collect(Collectors.toMap(Product::getCategoryId,
                p -> {
                    List<Integer> categoryIds = new ArrayList<>();
                    categoryIds.add(p.getId());
                    return categoryIds;
                },
                (List<Integer> value1, List<Integer> value2) -> {
                    value1.addAll(value2);
                    return value1;
                }
        ));
        log.info(map2.toString());

        return map2;
    }

    @GetMapping("/stream/list-to-map")
    public Object listConvertToMap(){

        List<Product> list = Arrays.asList(new Product(11311,10342),
                new Product(11324,10343));

        Map<Integer, Integer> map = list.stream().collect(Collectors.toMap(Product::getId, Product::getCategoryId));
        log.info(map.toString());

        return map;
    }


}
