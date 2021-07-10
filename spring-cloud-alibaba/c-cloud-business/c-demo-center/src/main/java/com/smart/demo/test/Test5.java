package com.smart.demo.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lukewei
 * @date 2021/5/28 19:33
 */
public class Test5 {



    public static void main(String[] args) {

        String  regex = "^1[3-9]\\d{9}$";

        String phone = "10978390390";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        if(phone.length() == 11){

            System.out.println(m.matches());
        }else {
            System.out.println("合法");
        }

        User user = new User();
        user.setId(1);
        Dto dto = new Dto();
        dto.setUser(user);
        user.setName("zhangsan");
        System.out.println(dto.toString());

    }

    static class User{
        private Integer id;
        private String name;

        public User() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "user{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static class Dto{
        public Dto() {
        }

        private int id;

        private User user;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        @Override
        public String toString() {
            return "Dto{" +
                    "id=" + id +
                    ", user=" + user +
                    '}';
        }
    }
}
