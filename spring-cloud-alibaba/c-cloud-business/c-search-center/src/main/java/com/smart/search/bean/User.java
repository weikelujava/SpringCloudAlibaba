package com.smart.search.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: User
 * @description:
 * @author: lukewei
 * @date: 2020-12-28 16:32
 * @remark: 修改内容
 */
@TableName("user")
@Document(indexName = "t_user",type = "docs",shards = 3,replicas = 1)
@TypeAlias("t_user_prod")
public class User implements Serializable {

    private static final long serialVersionUID = -1780739868711869926L;

    @Id
    @TableId(value = "id",type = IdType.INPUT)
    private Long id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String password;

    @Field(type = FieldType.Date)
    private Date loginTime;

    @Field(type = FieldType.Text)
    private String remark;


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                Objects.equals(loginTime, user.loginTime) &&
                Objects.equals(remark, user.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, loginTime, remark);
    }
}
