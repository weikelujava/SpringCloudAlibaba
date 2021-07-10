package com.smart.demo.test;

import java.util.Arrays;
import java.util.List;

/**
 * @author lukewei
 * @date 2021/6/10 19:05
 */
public class Test7 {

    public static void main(String[] args) {
        String a = "1,2,3";
        String b = "11";

//        List<String> s1 = Arrays.asList(a.split(","));
//        System.out.println(s1);
//        List<String> s2 = Arrays.asList(b.split(","));
//        System.out.println(s2);

        User user = new User(1,true);
        User user1 = new User(2,false);
        User user2 = new User(3,true);
        List<User> users = Arrays.asList(user, user1, user2);
        // 统计 users中 所有对象属性 flag = true的个数
        long count = users.stream().filter(u -> u.flag == true).count();
        System.out.println(count);
    }

    static class User{
        private int id;
        private Boolean flag;

        public User() {
        }

        public User(int id, Boolean flag) {
            this.id = id;
            this.flag = flag;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Boolean getFlag() {
            return flag;
        }

        public void setFlag(Boolean flag) {
            this.flag = flag;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", flag=" + flag +
                    '}';
        }
    }
}
