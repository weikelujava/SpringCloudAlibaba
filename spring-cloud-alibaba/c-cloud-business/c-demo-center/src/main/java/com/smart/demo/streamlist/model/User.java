package com.smart.demo.streamlist.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lukewei
 * @date 2021/5/13 18:34
 */
@Data
public class User {

    //姓名
    private String name;
    //年龄
    private Integer age;
    //性别
    private Integer sex;
    //地址
    private String address;
    //赏金
    private BigDecimal money;

    public User(String name, Integer age, Integer sex, String address,BigDecimal money) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", money=" + money +
                ", address='" + address + '\'' +
                '}';
    }
}
