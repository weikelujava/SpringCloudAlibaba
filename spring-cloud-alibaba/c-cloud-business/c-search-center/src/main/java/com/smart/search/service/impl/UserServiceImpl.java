package com.smart.search.service.impl;

import cn.hutool.core.util.IdUtil;
import com.smart.search.bean.User;
import com.smart.search.mapper.UserMapper;
import com.smart.search.repository.TUserRepository;
import com.smart.search.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: UserServiceImpl
 * @description:
 * @author: lukewei
 * @date: 2020-12-28 18:05
 * @remark: 修改内容
 */
@Service
public class UserServiceImpl extends SuperServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private TUserRepository tUserRepository;

    @Override
    public User findUserById(Long id) {
        return baseMapper.findUserById(id);
    }

    @Override
    public Long insertUser(User user) {
        long id = IdUtil.createSnowflake(1, 1).nextId();
        user.setId(id);
        user.setLoginTime(new Date());
        Long userId = baseMapper.insertUser(user);
        if(userId > 0){
            tUserRepository.save(user);
        }
        return userId;
    }
}
