package com.smart.demo.designpattern.singleton;

/**
 * 单例模式-双重检查模式
 *
 * @author weike
 */
public class DoubleCheckSingleTon {

    private static DoubleCheckSingleTon INSTANCE;

    private DoubleCheckSingleTon(){

    }

    public static DoubleCheckSingleTon getInstance(){
        // 双重检查
        if(null == INSTANCE){
            synchronized (DoubleCheckSingleTon.class){
                if(null == INSTANCE){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new DoubleCheckSingleTon();
                }
            }
        }
        return INSTANCE;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(DoubleCheckSingleTon.getInstance().hashCode());
            }).start();
        }
    }

}
