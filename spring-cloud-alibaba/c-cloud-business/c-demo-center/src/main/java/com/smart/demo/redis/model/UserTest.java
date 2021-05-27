package com.smart.demo.redis.model;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author lukewei
 * @date 2021/5/13 16:56
 */
public class UserTest {

    private String sex;

    private Integer score;

    public UserTest() {
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "UserTest{" +
                "sex='" + sex + '\'' +
                ", score=" + score +
                '}';
    }
}


