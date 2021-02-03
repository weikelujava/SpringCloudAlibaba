package com.smart.common.model;

import java.io.Serializable;

/**
 *
 * @version V1.0
 * @title: User
 * @description:
 * @author: lukewei
 * @date: 2021-01-29 13:05
 * @remark: 修改内容
 */
public class User implements Serializable {


    private static final long serialVersionUID = -6545972289267185578L;

    private Long id;

    private String userName;

    private int age;

    private String university;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", university='" + university + '\'' +
                '}';
    }
}
