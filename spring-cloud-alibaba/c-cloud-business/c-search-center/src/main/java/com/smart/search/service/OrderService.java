package com.smart.search.service;

import com.smart.common.model.Order;

/**
 *
 * @version V1.0
 * @title: OrderService
 * @description:
 * @author: lukewei
 * @date: 2021-01-29 2021/1/29
 * @remark: 修改内容
 */
public interface OrderService extends ISuperService<Order> {

    Long saveOrder(Order order);
}
