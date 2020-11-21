package com.smart.generator.main;

import com.baomidou.mybatisplus.annotation.DbType;
import com.smart.generator.utils.CommonUtils;

/**
 *
 * @version V1.0
 * @title: SqlServerCodeGenerator
 * @description:
 * @author: lukewei
 * @date: 2020-11-21 14:15
 * @remark: 修改内容
 */
public class SqlServerCodeGenerator {

    public static void main(String[] args) {
        DbType dbType = DbType.SQL_SERVER;
        String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=dbName";
        String username = "username";
        String password = "password";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        // 表前缀，生成的实体类，不含前缀
        String [] tablePrefixes = {};
        // 表名，为空，生成所有的表
        String [] tableNames = {};
        // 字段前缀
        String [] fieldPrefixes = {};
        // 基础包名
        String packageName = "com.example.module.db";
        CommonUtils.execute(dbType, dbUrl, username, password, driver, tablePrefixes, tableNames, packageName, fieldPrefixes);
    }
}
