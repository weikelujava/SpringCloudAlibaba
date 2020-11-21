package com.smart.generator.db.repository.impl;

import com.smart.generator.db.entity.CmsContent;
import com.smart.generator.db.mapper.ICmsContentMapper;
import com.smart.generator.db.repository.MPCmsContentRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 内容 服务实现类
 * </p>
 *
 * @author Weike Lu
 * @since 2020-11-21
 */
@Service
public class CmsContentRepositoryImpl extends ServiceImpl<ICmsContentMapper, CmsContent> implements MPCmsContentRepository {

}
