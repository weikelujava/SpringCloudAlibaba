package com.smart.search.feign;

import com.smart.common.model.User;
import com.smart.search.feign.fallback.UserServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @version V1.0
 * @title: UserService
 * @description:
 * @author: lukewei
 * @date: 2021-01-29 2021/1/29
 * @remark: 修改内容
 */

@FeignClient(name = "c-user-center", fallbackFactory = UserServiceFallbackFactory.class, decode404 = true)
public interface UserService {

    @GetMapping("/user/{userId}")
    String findUserNameByUserId(@PathVariable("userId") Long userId);

    @PostMapping("/user")
    Long saveUser(@RequestBody User user);
}
