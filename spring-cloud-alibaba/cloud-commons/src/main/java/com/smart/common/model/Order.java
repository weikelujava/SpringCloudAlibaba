package com.smart.common.model;

import java.io.Serializable;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: Order
 * @description:
 * @author: lukewei
 * @date: 2021-01-29 14:42
 * @remark: 修改内容
 */
public class Order implements Serializable {

    private static final long serialVersionUID = -1642969016244237308L;


    private Long id;

    private Long userId;

    private String productId;

    private String product;

    private int price;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId='" + productId + '\'' +
                ", product='" + product + '\'' +
                ", price=" + price +
                '}';
    }
}
