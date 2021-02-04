package com.smart.demo.thread;

/**
 *
 * @version V1.0
 * @title: ThreadLocal
 * @description:
 * @author: lukewei
 * @date: 2021-02-04 10:45
 * @remark: 修改内容
 */
public class ThreadLocalTest {

    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        new Thread().start();
    }
}
