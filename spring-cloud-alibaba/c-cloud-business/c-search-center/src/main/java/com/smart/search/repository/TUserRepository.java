package com.smart.search.repository;

import com.smart.search.bean.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @version V1.0
 * @title: TUserRepository
 * @description:
 * @author: lukewei
 * @date: 2020-12-28 2020/12/28
 * @remark: 修改内容
 */
@Repository
public interface TUserRepository extends ElasticsearchRepository<User,Long> {

}
