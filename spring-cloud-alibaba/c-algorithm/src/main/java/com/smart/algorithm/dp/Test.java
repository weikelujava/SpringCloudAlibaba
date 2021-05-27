package com.smart.algorithm.dp;

import cn.hutool.core.util.RandomUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lukewei
 * @date 2021/5/7 16:36
 */
public class Test {

    private static LinkedList<String[]> recursionSub ( LinkedList<String[]> list, int count, String[][] array, int ind,
                                                       int start, int... indexs )
    {
        start++;
        if (start > count - 1)
        {
            return null;
        }
        if (start == 0)
        {
            indexs = new int[array.length];
        }
        for ( indexs[start] = 0; indexs[start] < array[start].length; indexs[start]++ )
        {
            recursionSub (list, count, array, 0, start, indexs);
            if (start == count - 1)
            {
                String[] temp = new String[count];
                for ( int i = count - 1; i >= 0; i-- )
                {
                    temp[start - i] = array[start - i][indexs[start - i]];
                }
                list.add (temp);
            }
        }
        return list;
    }

    public static void main ( String[] args )
    {
        String[] s1 = { "a", "b", "c" };
        String[] s2 = { "d", "e", "f" };
        String[] s3 = { "x", "y", "z"  };
        String[][] temp = { s1, s2, s3 };

        LinkedList<String[]> list = new LinkedList<String[]> ();
        recursionSub (list, temp.length, temp, 0, -1);
        for ( int i = 0; i < list.size (); i++ )
        {
            System.out.println (Arrays.toString (list.get (i)).replaceAll ("[\\[\\]\\,\\s]", ""));
        }
    }

}
