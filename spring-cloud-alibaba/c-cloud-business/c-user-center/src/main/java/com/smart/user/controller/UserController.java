package com.smart.user.controller;

import com.smart.common.model.User;
import com.smart.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @version V1.0
 * @title: UserController
 * @description:
 * @author: lukewei
 * @date: 2020-09-30 9:57
 * @remark: 修改内容
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String getUser(){
        return "hello user";
    }

    @PostMapping("/user")
    public Long saveUser(@RequestBody User user){
        Long userId = userService.insertUser(user);
        log.info("保存用户结果："+userId);
        return userId;
    }
}
