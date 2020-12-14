package com.smart.demo.list_sort.controller;

import com.smart.demo.list_sort.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @version V1.0
 * @title: ListDistinctController
 * @description:
 * @author: lukewei
 * @date: 2020-11-07 18:13
 * @remark: 修改内容
 */
public class ListDistinctController {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("zhangsan");

        List<Student> students = new ArrayList<>();
        students.add(new Student(10,"zhangsan"));
        students.add(new Student(11,"lisi"));
        students.add(new Student(12,"wangwu"));

        List<Student> collect = students.stream().filter(o -> !names.contains(o.getName())).collect(Collectors.toList());
        System.out.println(collect);
    }
}
