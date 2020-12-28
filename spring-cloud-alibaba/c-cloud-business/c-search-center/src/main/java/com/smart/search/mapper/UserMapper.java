package com.smart.search.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.search.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
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
