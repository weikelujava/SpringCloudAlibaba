package com.smart.demo.streamlist.controller;

import com.smart.demo.streamlist.model.User;
import org.checkerframework.checker.units.qual.A;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

/**
 * @author lukewei
 * @date 2021/5/13 17:30
 */
@RestController
public class StreamControllerTest {


    public static void main(String[] args) {
        List<User> list = Arrays.asList(
                new User("李星云", 18, 0, "渝州", new BigDecimal(1000)),
                new User("陆林轩", 16, 1, "渝州", new BigDecimal(500)),
                new User("姬如雪", 17, 1, "幻音坊", new BigDecimal(800)),
                new User("姬如雪2", 19, 1, "幻音坊", new BigDecimal(800)),
                new User("袁天罡", 99, 0, "藏兵谷", new BigDecimal(100000)),
                new User("张子凡", 19, 0, "天师府", new BigDecimal(900)),
                new User("陆佑劫", 45, 0, "不良人", new BigDecimal(600)),
                new User("张天师", 48, 0, "天师府", new BigDecimal(1100)),
                new User("蚩梦", 18, 1, "万毒窟", new BigDecimal(800))
        );

        Map<String, List<User>> collect2 = list.stream().collect(Collectors.toMap(User::getAddress, user -> {
                    List<User> users = new ArrayList<>(1);
                    users.add(user);
                    return users;
                },
                (List<User> users, List<User> user2) -> {
                    users.addAll(user2);
                    return users;
                }

        ));

        Set<Map.Entry<String, List<User>>> entries = collect2.entrySet();
        Iterator<Map.Entry<String, List<User>>> iterator = entries.iterator();
        while (true){
            if(iterator.hasNext()){
                System.out.println(iterator.next().getValue());
            }else {
                break;
            }
        }


//        Set<Map.Entry<String, User>> entries = collect2.entrySet();
//        Iterator<Map.Entry<String, User>> iterator = entries.iterator();
//        while (true){
//            if(iterator.hasNext()){
//                System.out.println(iterator.next());
//            }else {
//                break;
//            }
//        }



//        List<User> collect2 = list.stream().filter(user -> user.getSex() == 1).collect(Collectors.toList());
//        System.out.println(collect2);
//        System.out.println("---------------------------------------------");
//        Map<String, List<User>> collect3 = collect2.stream().collect(groupingBy(user -> user.getAddress()));
//        System.out.println(collect3);


//        List<Integer> collect2 = list.stream().map(User::getAge).collect(Collectors.toList());
//        System.out.println(collect2);
//
//        List<String> addressList = new ArrayList<>(1);
//
//        List<User> collect3 = list.stream().sorted(Comparator.comparing(User::getAge).reversed()).collect(Collectors.toList());
//        for (User user : collect3) {
//            System.out.println(user);
//            if(!addressList.contains(user.getAddress())){
//                addressList.add(user.getAddress());
//            }
//        }
//
//        System.out.println("--------------------------");
//        for (String s : addressList) {
//
//            System.out.println(s);
//        }



//        Map<String, List<User>> collect2 = list.stream().sorted(Comparator.comparing(User::getAge).reversed()).collect(Collectors.groupingBy(User::getAddress));
//
//        Set<Map.Entry<String, List<User>>> entries = collect2.entrySet();
//        Iterator<Map.Entry<String, List<User>>> iterator = entries.iterator();
//        while (true){
//            if(iterator.hasNext()){
//                System.out.println(iterator.next());
//            }else {
//                break;
//            }
//        }



//        Map<String, Optional<User>> collect3 = list.stream().collect(Collectors.groupingBy(User::getAddress, maxBy(Comparator.comparing(User::getAge))));
//        Set<Map.Entry<String, Optional<User>>> entries = collect3.entrySet();
//        Iterator<Map.Entry<String, Optional<User>>> iterator = entries.iterator();
//        while (true){
//            if(iterator.hasNext()){
//                System.out.println(iterator.next());
//            }else {
//                break;
//            }
//        }

        List<String> collect = list.stream().map(User::getAddress).distinct().collect(Collectors.toList());
//        for (String s : collect) {
//            System.out.println(s);
//        }

        List<Integer> collect1 = list.stream().map(User::getAge).collect(Collectors.toList());
//        for (Integer integer : collect1) {
//            System.out.println(integer);
//        }

//        Map<String, User> collect2 = list.stream().collect(Collectors.toMap(User::getAddress,user -> user));
//        Set<Map.Entry<String, User>> entries = collect2.entrySet();
//        Iterator<Map.Entry<String, User>> iterator = entries.iterator();
//        while (true){
//            if(iterator.hasNext()){
//                System.out.println(iterator.next());
//            }else {
//                break;
//            }
//        }





    }

}
