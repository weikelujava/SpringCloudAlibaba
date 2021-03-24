package com.smart.demo.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 *
 * @version V1.0
 * @title: ClassLayoutTest
 * @description:  Java openjdk 提供jol 工具，可以查看class的头信息
 * @author: lukewei
 * @date: 2021-03-12 13:37
 * @remark: 修改内容
 */
public class ClassLayoutTest {

    public static void main(String[] args) {

        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());


    }
}
