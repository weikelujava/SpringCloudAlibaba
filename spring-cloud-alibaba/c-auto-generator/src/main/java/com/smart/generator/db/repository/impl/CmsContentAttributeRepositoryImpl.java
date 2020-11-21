package com.smart.generator.db.repository.impl;

import com.smart.generator.db.entity.CmsContentAttribute;
import com.smart.generator.db.mapper.ICmsContentAttributeMapper;
import com.smart.generator.db.repository.MPCmsContentAttributeRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 内容扩展 服务实现类
 * </p>
 *
 * @author Weike Lu
 * @since 2020-11-21
 */
@Service
public class CmsContentAttributeRepositoryImpl extends ServiceImpl<ICmsContentAttributeMapper, CmsContentAttribute> implements MPCmsContentAttributeRepository {

}
