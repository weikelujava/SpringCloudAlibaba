package com.smart.search.mapper;

import com.smart.common.model.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @version V1.0
 * @title: OrderSupper
 * @description:
 * @author: lukewei
 * @date: 2021-01-29 14:47
 * @remark: 修改内容
 */
@Mapper
public interface OrderMapper extends SuperMapper<Order> {

    int insertOrder(Order order);
}
