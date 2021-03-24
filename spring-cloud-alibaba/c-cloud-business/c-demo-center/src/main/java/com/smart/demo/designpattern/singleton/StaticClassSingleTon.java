package com.smart.demo.designpattern.singleton;



/**
 * 单例模式-静态内部类方式
 *
 * JVM保证单例
 * StaticClassSingleTon初始化的时候不会加载内部类StaticClassSingleTonHolder
 * 只有调StaticClassSingleTon.getInstance()方法才会获取内部类的实例对象，多线程下由JVM保证线程安全
 * @author weike
 */
public class StaticClassSingleTon {

    public StaticClassSingleTon() {
    }

    private static class StaticClassSingleTonHolder{
        private final static StaticClassSingleTon INSTANCE = new StaticClassSingleTon();
    }

    public static StaticClassSingleTon getInstance(){
        return StaticClassSingleTonHolder.INSTANCE;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(StaticClassSingleTon.getInstance().hashCode());
            }).start();
        }
    }

}
