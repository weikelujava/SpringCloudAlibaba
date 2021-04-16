package com.smart.demo.npe.test;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author weike
 */
public class NullPointExceptionTest {


    /**
     * 测试NPE
     * switch               switch(type)                     当type为null         判空，赋予默认值
     * equals               str.equals("")                   当str为null          Object.equals("常量","变量")
     * StringBuilder        new StringBuilder(str)           当str为null          判空过滤
     * ConcurrentHashMap    map.put(k,v)                     当v为null            判空过滤
     * lists.newArrayList() Lists.newArrayList(Collection)   当Collection为空      判空过滤
     *
     *
     * @param args main方法参数数组
     */
    public static void main(String[] args) {

//        switchTest();
//        equalsTest();
//        concurrentHashMapTest();
//        stringBuilderTest();
        newArrayListTest();
    }

    public static void switchTest(){
        Integer type = null;

        // 解决方案，判空 返回
        if(type == null){
            return;
        }

        // 解决方案，判空，赋默认值
        if(type == null){
            type = -1;
        }


        switch (type){
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            default:
                break;
        }

        // 如果 type = null，则报 NullPointerException

    }


    public static void equalsTest(){
        String str = null;
        // 错误写法
        System.out.println(str.equals("1"));
        // 正确写法
        System.out.println(Objects.equals("1",str));
    }


    public static void stringBuilderTest(){
        String name = null;
        String desc = null;

        StringBuilder builder = new StringBuilder();

        /*
            NullPointException
            解决方案：判空过滤
         */
        if(null != desc){
            builder.append(desc);
        }
        if(null != name){
            builder.append(name);
        }
        System.out.println(builder.toString());
    }


    public static void concurrentHashMapTest(){
        Map<String,String> map = new ConcurrentHashMap<>(16);
        String key = "key";
        String value = null;

        /*
            NullPointException
            解决方案，判断value是否为空
         */
        if(null != value){
            map.put(key,value);
        }
    }


    public static void newArrayListTest(){

        List<Object> objects = null;

        /*
            NullPointException
            解决方案：判空，过滤
         */
        if(null == objects){
            return;
        }
        ArrayList<Object> arrayList = Lists.newArrayList(objects);
        System.out.println(arrayList.isEmpty());
    }






}
