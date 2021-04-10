package com.smart.demo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {


    //这是一个main方法，是程序的入口：
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {

            list.add( doubleNum());
        }
        //创建线程任务对象
        NianHui task = new NianHui(list, 100);
        new Thread(task,"前门").start();
        new Thread(task,"后门").start();

    }

    static  String doubleNum(){
        ArrayList<String> list = new ArrayList<>();
        //红球号码
        while (list.size() < 6) {

            int redNum = (int) (Math.random()*33+1);
            String R = redNum<10? "0"+redNum:redNum+"" ;
            if (!list.contains(R)){
                list.add(R);
            }
        }
        Collections.sort(list);
        //蓝球号码
        int buleNum = (int) (Math.random() * 16 + 1);
        String B = buleNum<10?"0"+buleNum:buleNum+"" ;
        list.add(B);

        return list.toString();
    }
}
class NianHui implements Runnable{
    private List list;
    private  int num ;

    public NianHui(List list,int num) {
        this.list = list;
        this.num = num;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (num <= 0) {
                    System.out.println("奖品已抽完!");
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //随机产生一个随机数 模拟随机抽奖
                int index = (int) (Math.random() * list.size());
                String prise = (String) list.remove(index);
                System.out.println(Thread.currentThread().getName()+
                        "抽到到奖品是"+prise+"第"+num--+"个奖品");
            }
        }

    }
}
