package com.smart.user.service.impl;

import cn.hutool.core.util.IdUtil;
import com.smart.common.model.User;
import com.smart.user.mapper.UserMapper;
import com.smart.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @version V1.0
 * @title: UserServiceImpl
 * @description:
 * @author: lukewei
 * @date: 2020-12-28 18:05
 * @remark: 修改内容
 */
@Service
public class UserServiceImpl extends SuperServiceImpl<UserMapper, User> implements UserService {


    @Override
    public User findUserById(Long id) {
        return null;
    }

    @Override
    public Long insertUser(User user) {

        List<String> list = Arrays.asList("清华大学","北京大学","中国人民大学","哈尔滨工业大学","上海交通大学");
        long id = IdUtil.getSnowflake(1, 1).nextId();
        user.setId(id);
        user.setAge(new Random().nextInt(40)+1);
        user.setUniversity(list.get(new Random().nextInt(5)));
        int rows = baseMapper.insert(user);
        if(rows>0){
            return user.getId();
        }
        return null;
    }
}
