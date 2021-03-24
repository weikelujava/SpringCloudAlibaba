package com.smart.demo.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPool {


    private static final ThreadPoolExecutor POOL = new ThreadPoolExecutor(4,8,10, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(10),new DefaultThreadFactory());

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            int finalI = i;
            POOL.execute(()->{
                System.out.println(finalI +":"+Thread.currentThread().getName()+"---"+POOL.getPoolSize()+"-"+POOL.getCorePoolSize()+"-"+POOL.getMaximumPoolSize()+"-"+POOL.getActiveCount()+"-"+POOL.getTaskCount()+"-");
            });
        }

    }


    /**
     * @ClassName: DefaultThreadFactory
     * @Description: 线程命名工厂
     * @Author: weike
     * @Date: 2020-3-24 18:13:32
     */
    private static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        DefaultThreadFactory() {
            this("myThread-pool-t-");
        }

        DefaultThreadFactory(String prefix) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = prefix + POOL_NUMBER.getAndIncrement();
        }

        @Override
        public Thread newThread(Runnable runnable) {
            Thread t = new Thread(group, runnable,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

}
