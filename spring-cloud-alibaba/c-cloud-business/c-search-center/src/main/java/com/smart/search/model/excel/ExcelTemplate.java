package com.smart.search.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: ExcelTemplate
 * @description:
 * @author: lukewei
 * @date: 2020-11-01 13:48
 * @remark: 修改内容
 */
@TableName("blc_flying_flag_time")
public class ExcelTemplate implements Serializable {


    private static final long serialVersionUID = 2975845123696612998L;

    @TableId(value = "ID", type = IdType.AUTO)
    @NotNull(message = "ID不能为空",groups = {updateExcelTemplateForValidator.class})
    private Integer id;

    /**
     * 年，格式 2020
     */

    @ExcelProperty("年份")
    private String year;

    /**
     * 天，格式 2020-11-01
     */
    @NotBlank(message = "天(2020-10-01)不能为空",groups = {saveExcelTemplateForValidator.class, updateExcelTemplateForValidator.class})
    @ExcelProperty("天")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date day;

    /**
     * 升旗时间
     */
    @NotBlank(message = "升旗时间(06:10)不能为空",groups = {saveExcelTemplateForValidator.class, updateExcelTemplateForValidator.class})
    @ExcelProperty("升旗时间")
    private String upTime;

    /**
     * 降旗时间
     */
    @NotBlank(message = "降旗时间(18:10)不能为空",groups = {saveExcelTemplateForValidator.class, updateExcelTemplateForValidator.class})
    @ExcelProperty("降旗时间")
    private String downTime;

    /**
     * 类型，备用
     */
    private String type;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date dateCreated;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date dateUpdated;
    /**
     * 版本号
     */
    private Integer version;

    public ExcelTemplate() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public String getDownTime() {
        return downTime;
    }

    public void setDownTime(String downTime) {
        this.downTime = downTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    public interface saveExcelTemplateForValidator {
    }

    ;

    public interface updateExcelTemplateForValidator {
    }

    ;
}
