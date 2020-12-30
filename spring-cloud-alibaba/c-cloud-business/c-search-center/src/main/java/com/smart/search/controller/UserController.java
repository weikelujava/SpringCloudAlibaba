package com.smart.search.controller;

import com.smart.search.bean.User;
import com.smart.search.repository.TUserRepository;
import com.smart.search.service.UserService;
import org.apache.commons.collections.IteratorUtils;
import org.apache.ibatis.annotations.Mapper;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: UserController
 * @description:
 * @author: lukewei
 * @date: 2020-12-28 17:43
 * @remark: 修改内容
 */
@RestController
@RequestMapping("/api/search")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private TUserRepository userRepository;

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable("id") Long id){

        return userService.findUserById(id);
    }


    @PostMapping("/user")
    public Boolean saveUser(@RequestBody User user){
        Long id = userService.insertUser(user);
        return id > 0;
    }


    @GetMapping("/user/search")
    public List<User> findUserBySearch(@RequestBody Map<String,String> map){
        String searchName = map.get("searchName");

        MultiMatchQueryBuilder builder = QueryBuilders.multiMatchQuery(searchName,"name","remark");
//        QueryBuilder builder = QueryBuilders.boolQuery().must(QueryBuilders.)
        Iterable<User> search = userRepository.search(builder);
        return IteratorUtils.toList(search.iterator());
    }

    @GetMapping("/user/1")
    public List<User> findUsersBySearch1(@RequestBody Map<String,String> map){
        String searchName = map.get("searchName");
        QueryBuilder builder = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("remark", searchName));
//        QueryBuilder builder = QueryBuilders.boolQuery().must(QueryBuilders.)
        Iterable<User> search = userRepository.search(builder);
        return IteratorUtils.toList(search.iterator());
    }

    @GetMapping("/user/2")
    public List<User> findUsersBySearch2(@RequestBody Map<String,String> map){
        String searchName = map.get("searchName");
        TermQueryBuilder builder = QueryBuilders.termQuery("remark",searchName);
//        QueryBuilder builder = QueryBuilders.boolQuery().must(QueryBuilders.)
        Iterable<User> search = userRepository.search(builder);
        return IteratorUtils.toList(search.iterator());
    }

}
