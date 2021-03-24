package com.smart.demo.subStr;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: SubString
 * @description:
 * @author: lukewei
 * @date: 2021-03-04 14:47
 * @remark: 修改内容
 */
public class SubStringTest {
    public static void main(String[] args) {
        String str = "10001-about";

        String prev = str.substring(0, str.indexOf("-"));
        String last = str.substring(str.indexOf("-")+1,str.length());

        System.out.println(prev);
        System.out.println(last);
    }
}
