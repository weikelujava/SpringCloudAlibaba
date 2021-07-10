package com.smart.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lukewei
 * @date 2021/6/8 12:56
 */
public class Test6 {
    public static void main(String[] args) {

//        t();
        t1();

    }


    private static void t() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new ShopCartException("400", "出错了");
        }
    }

    static void t1(){
        List<B> bs = new ArrayList<>();
        List<A> as = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            A a = new A();
            a.setId(i+1);
            a.setName(i+":"+i);
            as.add(a);
        }

        List<A> as1 = new ArrayList<>();
        for (int i = 10; i < 12; i++) {
            A a = new A();
            a.setId(i+1);
            a.setName(i+":"+i);
            as1.add(a);
        }

        Map<Integer,List<A>> map = new HashMap<>();
        map.put(11,as);
        map.put(12,as1);


        for (int i = 11; i < 13; i++) {
            B b = new B();
            b.setId(i);
            b.setList(map.get(i));
            bs.add(b);
        }

        List<A> total = new ArrayList<>();

        bs.forEach(b -> {total.addAll(b.getList());});

        for (A a : total) {
            System.out.println(a);
        }




    }

    static class B{
        private int id;

        private List<A> list;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<A> getList() {
            return list;
        }

        public void setList(List<A> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            return "B{" +
                    "id=" + id +
                    ", list=" + list +
                    '}';
        }
    }



    static class A{
        private int id;
        private String name;

        public A() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "A{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
