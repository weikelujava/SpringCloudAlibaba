package com.smart.search.service.impl;

import cn.hutool.core.util.IdUtil;
import com.smart.common.model.Order;
import com.smart.common.model.User;
import com.smart.search.feign.UserService;
import com.smart.search.mapper.OrderMapper;
import com.smart.search.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @version V1.0
 * @title: OrderServiceImpl
 * @description:
 * @author: lukewei
 * @date: 2021-01-29 14:47
 * @remark: 修改内容
 */
@Service
public class OrderServiceImpl extends SuperServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private UserService userService;

    @Override
    public Long saveOrder(Order order) {
        User user = new User();
        user.setUserName("Jackson");
        Long userId = userService.saveUser(user);
        if(null != userId){
            order.setId(IdUtil.getSnowflake(1,1).nextId());
            order.setPrice(2);
            order.setProduct("平多多-水果");
            order.setProductId("2");
            order.setUserId(userId);
            int rows = baseMapper.insertOrder(order);
            if(rows > 0){
                return order.getId();
            }
        }
        return null;
    }
}
