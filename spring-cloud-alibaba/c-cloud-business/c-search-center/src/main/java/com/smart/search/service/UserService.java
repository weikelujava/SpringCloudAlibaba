package com.smart.search.service;

import com.smart.search.bean.User;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
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
