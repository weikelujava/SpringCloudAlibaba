package com.smart.demo.reference;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @version V1.0
 * @title: StrongReference
 * @description:
 * @author: lukewei
 * @date: 2021-02-04 11:11
 * @remark: 修改内容
 */
public class StrongReference {

    public static void main(String[] args) {

        // 强引用
        Object o = new Object();

        // 帮助垃圾回收此对象
        o = null;

        List list = new ArrayList();
    }
}
