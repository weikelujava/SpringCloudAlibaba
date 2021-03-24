package com.smart.search.service;

import java.util.List;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: ExcelUploadService
 * @description:
 * @author: lukewei
 * @date: 2021-03-13 2021/3/13
 * @remark: 修改内容
 */
public interface ExcelUploadService {

    void saveExcelDateToRedis(List<String> list);
}
