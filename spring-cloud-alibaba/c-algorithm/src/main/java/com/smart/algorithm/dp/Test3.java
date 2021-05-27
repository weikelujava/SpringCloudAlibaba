package com.smart.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lukewei
 * @date 2021/5/8 10:49
 */
public class Test3 {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            if(i<4){
                a.add("哈"+i);
            }else{
                b.add(i+"");
            }
        }
        System.out.println(a+"-------"+b);

        List<List<String>> list = Arrays.asList(a, b);
        System.out.println("============="+list);

        String[][] temps = new String[list.size()][];
        for (int i = 0; i < temps.length; i++) {
            temps[i] = new String[list.get(i).size()];
            for (int j = 0; j < temps[i].length; j++) {
                temps[i][j] = list.get(i).get(j);
            }
        }
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        for (String[] temp : temps) {
            for (int i = 0; i < temp.length; i++) {
                for (String s : temp) {
                    System.out.println(s);
                }
            }
        }
    }
}
