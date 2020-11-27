package com.smart.generator.db.repository.impl;

import com.smart.generator.db.entity.CmsCategory;
import com.smart.generator.db.mapper.ICmsCategoryMapper;
import com.smart.generator.db.repository.MPCmsCategoryRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 分类 服务实现类
 * </p>
 *
 * @author Weike Lu
 * @since 2020-11-27
 */
@Service
public class CmsCategoryRepositoryImpl extends ServiceImpl<ICmsCategoryMapper, CmsCategory> implements MPCmsCategoryRepository {

}
