package com.smart.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/user")
    public String getUser(){
        return "hello user";
    }
}
