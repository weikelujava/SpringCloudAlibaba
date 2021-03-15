package com.smart.search.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: ExcelData
 * @description:
 * @author: lukewei
 * @date: 2020-11-01 18:12
 * @remark: 修改内容
 */
public class ExcelData implements Serializable {

    private static final long serialVersionUID = 7237826973358996612L;


    /**
     * 升旗日期，格式 2020-11-01
     */
    @ExcelProperty("fd_sensitive_name")
    private String sensitiveName;



    public ExcelData() {
    }

    public String getSensitiveName() {
        return sensitiveName;
    }

    public void setSensitiveName(String sensitiveName) {
        this.sensitiveName = sensitiveName;
    }

    @Override
    public String toString() {
        return "ExcelData{" +
                "sensitiveName='" + sensitiveName + '\'' +
                '}';
    }
}
