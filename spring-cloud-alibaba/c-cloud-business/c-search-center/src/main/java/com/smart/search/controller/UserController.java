package com.smart.search.controller;

import com.smart.search.bean.User;
import com.smart.search.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable("id") Long id){

        return userService.findUserById(id);
    }


    @PostMapping("/user")
    public Boolean saveUser(@RequestBody User user){
        Long id = userService.insertUser(user);
        return id > 0;
    }

}
