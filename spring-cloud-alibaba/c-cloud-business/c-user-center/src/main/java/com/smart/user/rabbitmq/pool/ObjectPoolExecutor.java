package com.smart.user.rabbitmq.pool;

/**
 *
 * @version V1.0
 * @title: ObjectPoolExecutor
 * @description:
 * @author: lukewei
 * @date: 2021-02-03 2021/2/3
 * @remark: 修改内容
 */
@FunctionalInterface
public interface ObjectPoolExecutor<T,R> {

    R execute(T object);
}
