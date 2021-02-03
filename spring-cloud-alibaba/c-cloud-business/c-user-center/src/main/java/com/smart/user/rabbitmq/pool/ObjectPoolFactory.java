package com.smart.user.rabbitmq.pool;

/**
 *
 * @version V1.0
 * @title: ObjectPoolFactory
 * @description:
 * @author: lukewei
 * @date: 2021-02-03 17:05
 * @remark: 修改内容
 */
@FunctionalInterface
public interface ObjectPoolFactory<T> {

    T create();
}
