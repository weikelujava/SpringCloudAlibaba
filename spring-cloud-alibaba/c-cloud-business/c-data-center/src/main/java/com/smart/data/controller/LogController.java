package com.smart.data.controller;

import com.smart.data.mode.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: LogController
 * @description:
 * @author: lukewei
 * @date: 2021-01-04 14:27
 * @remark: 修改内容
 */
@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {


    @GetMapping("/produce")
    public void produceLogs() throws InterruptedException {

        List<Integer> productIds = Arrays.asList(1000, 2000, 3000, 4000, 5000);
        Map<Integer,Integer> productPriceMap = new HashMap<>();
        productPriceMap.put(1000,10);
        productPriceMap.put(2000,20);
        productPriceMap.put(3000,30);
        productPriceMap.put(4000,40);
        productPriceMap.put(5000,50);

        Map<Integer,String> productNameMap = new HashMap<>();
        productNameMap.put(1000,"食物");
        productNameMap.put(2000,"电影");
        productNameMap.put(3000,"ktv");
        productNameMap.put(4000,"饮料");
        productNameMap.put(5000,"Java");

        for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            Product product = new Product();
//           int random = (int)(Math.round(Math.random()*5))-1;
           int random = new Random().nextInt(5);
            log.error(random+"");
            product.setId(productIds.get(random));

            product.setPrice(productPriceMap.get(product.getId()));
            product.setName(productNameMap.get(product.getId()));

            log.info(product.toString());
        }
    }
}
