package com.smart.demo.list_sort.controller;

import com.smart.demo.list_sort.model.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @version V1.0
 * @title: listSortController
 * @description:
 * @author: lukewei
 * @date: 2020-11-07 16:25
 * @remark: 修改内容
 */
public class ListSortController {


    public static void main(String[] args) {
        //Student student = new Student();
        List<Student> students = new ArrayList<>();
        students.add(new Student(22));
        students.add(new Student(21));
        students.add(new Student(23));
        students.add(new Student(25));
        students.add(new Student(26));
        students.add(new Student(20));
        students.add(new Student(15));
        students.add(new Student(1));
        students.add(new Student(11));

        Iterator it = students.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("排序前↑↑↑   =====   排序后↓↓↓");
        // 这里x和y分别对应比较的两个实体对象。
        students.sort((x, y) -> Integer.compare(x.getAge(), y.getAge()))  ;
        Iterator iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
