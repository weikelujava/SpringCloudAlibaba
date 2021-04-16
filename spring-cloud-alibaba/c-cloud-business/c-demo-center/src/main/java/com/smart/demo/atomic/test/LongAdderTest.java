package com.smart.demo.atomic.test;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author weike
 */
public class LongAdderTest {




    public static void main(String[] args) {

        longAdderTest();
    }


    /**
     * volatile 解决线程内存不可见问题，对于一写多读，是可以解决变量同步的问题
     * 如果是多写，同样无法解决线程安全问题。
     * 如果是count++操作，使用原子类实现：
     *  AtomicInteger count = new AtomicInteger();
     *  count.addAndGet(1);
     * 如果是JDK8，推荐使用 LongAdder对象，比AtomicLong性能更好。(减少乐观锁的重试次数)
     */
    private static void longAdderTest(){
        LongAdder adder = new LongAdder();
        adder.add(1);
        adder.increment();
        System.out.println(adder.longValue());
        System.out.println(adder.intValue());
        adder.decrement();
        System.out.println(adder.longValue());
        System.out.println(adder.intValue());
        adder.add(2);
        System.out.println(adder.sum());
        System.out.println(adder.sumThenReset());
        System.out.println(adder.longValue());
        System.out.println(adder.intValue());
        System.out.println(adder.sum());

        // 输出结果
        //2
        //2
        //1
        //1
        //3
        //3
        //0
        //0
        //0
    }
}
