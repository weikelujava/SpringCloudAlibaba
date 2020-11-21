package com.smart.generator.db.repository.impl;

import com.smart.generator.db.entity.CmsContentFile;
import com.smart.generator.db.mapper.ICmsContentFileMapper;
import com.smart.generator.db.repository.MPCmsContentFileRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 内容附件 服务实现类
 * </p>
 *
 * @author Weike Lu
 * @since 2020-11-21
 */
@Service
public class CmsContentFileRepositoryImpl extends ServiceImpl<ICmsContentFileMapper, CmsContentFile> implements MPCmsContentFileRepository {

}
