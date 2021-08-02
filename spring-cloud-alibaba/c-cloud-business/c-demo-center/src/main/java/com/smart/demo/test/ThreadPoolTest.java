package com.smart.demo.test;

import com.smart.common.thread.ThreadPoolProvider;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * @author lukewei
 * @date 2021/7/17 16:06
 */
public class ThreadPoolTest {






    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(2);

        ExecutorService executorService = ThreadPoolProvider.newFixedThreadPool();
        List<String> list = new ArrayList<>(1);
        for (int i = 0; i < 1; i++) {
            executorService.execute(()->{

                list.addAll(Arrays.asList("AB"));
                latch.countDown();
            });

            executorService.execute(()->{
                list.addAll(Arrays.asList("CD"));
                latch.countDown();
            });


        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list);
    }
}
