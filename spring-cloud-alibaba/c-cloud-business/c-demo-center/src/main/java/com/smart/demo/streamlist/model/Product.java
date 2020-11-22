package com.smart.demo.streamlist.model;

import java.io.Serializable;

/**
 *
 * @version V1.0
 * @title: Product
 * @description:
 * @author: lukewei
 * @date: 2020-11-21 10:35
 * @remark: 修改内容
 */
public class Product implements Serializable {

    private Integer id;

    private Integer categoryId;

    public Product() {
    }

    public Product(Integer id, Integer categoryId) {
        this.id = id;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                '}';
    }
}
