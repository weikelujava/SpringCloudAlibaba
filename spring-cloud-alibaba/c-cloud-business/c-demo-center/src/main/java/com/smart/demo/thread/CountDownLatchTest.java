package com.smart.demo.thread;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @version V1.0
 * @title: CountDownLatchTest
 * @description:
 * @author: lukewei
 * @date: 2021-02-04 10:04
 * @remark: 修改内容
 *
 *
 * CountDownLatch同步计数器
 *
 *
 */
public class CountDownLatchTest {


    public static void main(String[] args) throws Exception {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(){
            @SneakyThrows
            public void run() {
            System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
            Thread.sleep(6000);
            System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
            // 一个线程执行完成后，递减计数器
            latch.countDown();
        };}.start();
        new Thread(){
            @SneakyThrows
            public void run() {
            System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
            Thread.sleep(6000);
            System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
            // 一个线程执行完成后，递减计数器
            latch.countDown();
        };}.start();
        System.out.println("等待 2 个子线程执行完毕...");

        // 阻塞线程，等待latch的值递减为0
        latch.await();
        System.out.println("2 个子线程已经执行完毕");
        System.out.println("继续执行主线程");

    }
}
