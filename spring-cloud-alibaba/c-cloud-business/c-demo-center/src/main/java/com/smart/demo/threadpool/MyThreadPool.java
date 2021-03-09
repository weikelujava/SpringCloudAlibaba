package com.smart.demo.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @version V1.0
 * @title: MyThreadPool
 * @description:
 * @author: lukewei
 * @date: 2021-03-09 14:27
 * @remark: 修改内容
 */
@Slf4j
public class MyThreadPool{


    /**
     * JDK中支持一下4中创建类型创建，但是阿里巴巴规范中强烈要求禁止使用Executors来创建线程池
     * 目的：使用Executors来创建线程池不容易管理队列，容易造成OOM(内存溢出)
     *
     * 建议使用ThreadPoolExecutor来创建线程池
     */



        /**
         * 临时线程池
         * 特点：
         *      核心线程数为0
         *      最大线程数为Integer.MAX_VALUE,线程可以无限增加
         *      keepAliveTime为60S
         *      队列使用的SynchronousQueue的一个阻塞队列，这个队列无法存储，因为她的核心线程为0，所以它只负责任务的传递和中转时效率更高
         */
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        Executors.newCachedThreadPool(Executors.defaultThreadFactory());

        /**
         * 固定长度线程池
         * 特点：
         *      核心线程数为8，自定义
         *      最大线程数也为8，跟核心线程数相同
         *      keepAliveTime为0 MS
         *      队列使用的LinkedBlockingQueue的一个阻塞队列，这个队列可以有界或者无界，如果添加速度大于移除速度的时候无界的情况下可能造成OOM。
         *      因为队列是一个链表结构的有界阻塞队列，最大长度为Integer.MAX_VALUE,链表所以可以说是有界也可以说无界
         *
         *     固定长度的线程池，创建时从0开始创建，创建后就不会在销毁，而是全部作为常用线程池，所以基本上第三个参数和第四个参数都是无意义的。
         */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(8);
//        Executors.newFixedThreadPool(50,Executors.defaultThreadFactory());

        /**
         * 任务型(周期性)线程池
         * 特点：
         *      核心线程数为8，自定义
         *      最大线程数为Integer.MAX_VALUE,线程可以无限增加
         *      keepAliveTime为0 NS
         *      队列使用的DelayedWorkQueue的一个定制优先级队列，这个队列堆中使用的特殊的二叉树的数据结构存储，
         *      特殊二叉树的数据结构，要求父级的节点值不能小于子节点的值，保证大的值在上面，小的值在下面。这样可以实现快速的插入和删除，来实现优先级队列实现。
         */
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(8);
//        Executors.newScheduledThreadPool(8,Executors.defaultThreadFactory());


        /**
         * 单例线程线程池
         * 特点：
         *      核心线程数为1，固定
         *      最大线程数为1，
         *      KeepAliveTime为 0MS
         *      队列使用的LinkedBlockingQueue的一个阻塞队列，这个队列可以有界或者无界，如果添加速度大于移除速度的时候无界的情况下可能造成OOM。
         *      因为队列是一个链表结构的有界阻塞队列，最大长度为Integer.MAX_VALUE,链表所以可以说是有界也可以说无界
         *
         *      但是最大线程和核心线程都为1，那就是不管多少任务，它有且只会有一个线程去执行，如果执行过程中发生线程销毁，那会重新创建一个新城来执行后续的热舞
         * 场景：适合所有的任务按照提交的顺序来执行的场景，是个单线程的串行化
         */
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
//        Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());


    static class MyDefaultThreadFactory implements ThreadFactory{

        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        MyDefaultThreadFactory() {
            this("myThread-pool-t-");
        }

        MyDefaultThreadFactory(String prefix) {
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


    /**
     * @return ExecutorService
     * @Title newFixedThreadPool
     * @Description: 获取定长的线程池
     * @author weike
     * @date 2020-3-24 18:13:24
     */
    public static ExecutorService newFixedThreadPool() {
        return FIXED_THREAD_POOL;
    }

    /**
     * 智适应获取cpu大小
     * @return cpuCoreSize
     */
    private static Integer cpuCoreSize(){
        return Runtime.getRuntime().availableProcessors() != 0 ? Runtime.getRuntime().availableProcessors():8;
    }

    /**
     * 自定义线程池策略
     * 线程被拒绝后，重新开启一个线程执行被拒绝线程
     */
    private static class CustomRejectedExecutionHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            log.info("New Thread begin run which thread is Rejected");
            MyThreadPool.newFixedThreadPool().execute(r);
        }
    }


    /**
     * 线程池<br/>
     * 备注:不建议随处创建,可统一一处调用
     * new ThreadPoolExecutor.AbortPolicy() 添加不上抛异常
     * 目前使用自定义拒绝策略，在队列满了后放入新线程继续执行
     *
     * 队列：
     * 1.ArrayBlockingQueue; 有界阻塞队列
     * 2.LinkedBlockingQueue; 如果不指定容量，默认为Integer.MAX_VALUE,就成了无界队列
     * 3.SynchronousQueue; 特别的队列
     *
     * 其中拒绝策略有4种：
     *   1.new ThreadPoolExecutor.AbortPolicy()         丢弃任务并抛出RejectedExecutionException异常
     *   2.new ThreadPoolExecutor.CallerRunsPolicy()    也是丢弃任务，但是不抛出异常。
     *   3.new ThreadPoolExecutor.DiscardOldestPolicy() 丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
     *   4.new ThreadPoolExecutor.DiscardPolicy()       由调用线程处理该任务
     *
     *  参数优化：
     *  1.如果是密集型CPU，那么最大线程数应该配置线程核心数+1；
     *  2.如果是IO型CPU，那么最大线程应该配置线程核心数*2
     *
     */
    private static final ExecutorService FIXED_THREAD_POOL = new ThreadPoolExecutor(cpuCoreSize(), cpuCoreSize()*2, 10, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(10000),
            new MyDefaultThreadFactory(),
            new CustomRejectedExecutionHandler());

    private static final ExecutorService FIXED_THREAD_POOL1 = new ThreadPoolExecutor(cpuCoreSize(), cpuCoreSize()*2, 10, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(10000),
            new MyDefaultThreadFactory(),
            new ThreadPoolExecutor.DiscardPolicy());



}
