package com.smart.search.controller;

import com.alibaba.excel.EasyExcel;
import com.smart.search.model.excel.ExcelData;
import com.smart.search.model.excel.ExcelTemplateListener;
import com.smart.search.service.ExcelUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: ExcelDataToRedisController
 * @description:
 * @author: lukewei
 * @date: 2021-03-13 10:53
 * @remark: 修改内容
 */
@RestController
public class ExcelDataToRedisController {

    @Autowired
    private ExcelUploadService excelUploadService;


    @GetMapping("/upload")
    public void test(){

        InputStream inputStream = this.getClass().getResourceAsStream("/bus_sensitive_word.xlsx");

        EasyExcel.read(inputStream, ExcelData.class, new ExcelTemplateListener(excelUploadService)).sheet().doRead();
    }

}
