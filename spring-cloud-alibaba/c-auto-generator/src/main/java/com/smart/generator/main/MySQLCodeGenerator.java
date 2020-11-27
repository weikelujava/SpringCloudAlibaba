package com.smart.generator.main;

import com.baomidou.mybatisplus.annotation.DbType;
import com.smart.generator.utils.CommonUtils;

/**
 *
 * @version V1.0
 * @title: MySQLCodeGenerator
 * @description:
 * @author: lukewei
 * @date: 2020-11-21 14:02
 * @remark: 修改内容
 */
public class MySQLCodeGenerator {

    public static void main(String[] args) {
        DbType dbType = DbType.MYSQL;
        String dbUrl = "jdbc:mysql://114.116.17.142:54322/zgbx";
        String username = "root";
        String password = "root";
        String driver = "com.mysql.cj.jdbc.Driver";
        // 表前缀，生成的实体类，不含前缀
        String [] tablePrefixes = {};
        // 表名，为空，生成所有的表
        String [] tableNames = {"cms_category"};
        // 字段前缀
        String [] fieldPrefixes = {};
        // 基础包名
        String packageName = "com.smart.generator.db";
        CommonUtils.execute(dbType, dbUrl, username, password, driver, tablePrefixes, tableNames, packageName, fieldPrefixes);
    }
}
