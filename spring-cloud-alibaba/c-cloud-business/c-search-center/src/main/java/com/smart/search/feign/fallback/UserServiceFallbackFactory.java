package com.smart.search.feign.fallback;

import com.smart.common.model.User;
import com.smart.search.feign.UserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @version V1.0
 * @title: UserServiceFallback
 * @description:
 * @author: lukewei
 * @date: 2021-01-29 11:19
 * @remark: 修改内容
 */

@Service
public class UserServiceFallbackFactory implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {

            @Override
            public String findUserNameByUserId(Long userId) {
                return null;
            }

            @Override
            public Long saveUser(User user) {
                return null;
            }
        };
    }
}
