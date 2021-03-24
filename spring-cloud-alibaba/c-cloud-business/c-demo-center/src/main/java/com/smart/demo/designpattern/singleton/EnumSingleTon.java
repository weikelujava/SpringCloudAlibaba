package com.smart.demo.designpattern.singleton;


/**
 * 单例模式-枚举
 * 最完美
 * 不仅可以解决线程同步，还可以防止反序列化
 * @author weike
 */
public enum EnumSingleTon {

    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(EnumSingleTon.INSTANCE.hashCode());
            }).start();
        }
    }

}
