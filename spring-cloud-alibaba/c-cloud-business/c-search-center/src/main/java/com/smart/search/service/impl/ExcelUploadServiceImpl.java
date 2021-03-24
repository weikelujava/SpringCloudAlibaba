package com.smart.search.service.impl;

import com.smart.search.redis.RedisRepository;
import com.smart.search.service.ExcelUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: ExcelUploadServiceImpl
 * @description:
 * @author: lukewei
 * @date: 2021-03-13 11:06
 * @remark: 修改内容
 */

@Service
public class ExcelUploadServiceImpl implements ExcelUploadService {

    @Autowired
    private RedisRepository redisRepository;

    @Override
    public void saveExcelDateToRedis(List<String> words) {


    }
}
