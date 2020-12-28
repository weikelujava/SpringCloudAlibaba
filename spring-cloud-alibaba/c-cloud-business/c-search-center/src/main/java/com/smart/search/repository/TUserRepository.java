package com.smart.search.repository;

import com.smart.search.bean.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: TUserRepository
 * @description:
 * @author: lukewei
 * @date: 2020-12-28 2020/12/28
 * @remark: 修改内容
 */
@Repository
public interface TUserRepository extends ElasticsearchCrudRepository<User,Long> {

}
