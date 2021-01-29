package com.smart.search.controller;

import com.smart.common.model.Order;
import com.smart.search.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: OrderController
 * @description:
 * @author: lukewei
 * @date: 2021-01-29 14:45
 * @remark: 修改内容
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public Boolean saveOrder(){
        Order order = new Order();
        Long orderId = orderService.saveOrder(order);
        if(null != orderId){
            return true;
        }
        return false;
    }
}
