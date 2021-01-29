package com.smart.user.service;


import com.smart.common.model.User;

/**
 *
 * @version V1.0
 * @title: UserService
 * @description:
 * @author: lukewei
 * @date: 2020-12-28 2020/12/28
 * @remark: 修改内容
 */
public interface UserService {

    User findUserById(Long id);

    Long insertUser(User user);
}
