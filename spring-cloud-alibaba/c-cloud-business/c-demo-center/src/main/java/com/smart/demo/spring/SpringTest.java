package com.smart.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @version V1.0
 * @title: SpringTest
 * @description:
 * @author: lukewei
 * @date: 2021-01-26 9:47
 * @remark: 修改内容
 */
public class SpringTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-conf.xml");
        User user = context.getBean("user", User.class);
        System.out.println("name："+user.getName());
    }
}
