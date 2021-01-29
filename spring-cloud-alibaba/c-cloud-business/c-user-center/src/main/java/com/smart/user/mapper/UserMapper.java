package com.smart.user.mapper;

import com.smart.common.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @version V1.0
 * @title: UserMapper
 * @description:
 * @author: lukewei
 * @date: 2020-12-28 2020/12/28
 * @remark: 修改内容
 */
@Mapper
public interface UserMapper extends SuperMapper<User>{

    User findUserById(Long id);

    Long insertUser(User user);
}
