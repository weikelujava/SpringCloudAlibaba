package com.smart.data.mode;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @version V1.0
 * @title: Product
 * @description:
 * @author: lukewei
 * @date: 2021-01-04 14:31
 * @remark: 修改内容
 */

public class Product implements Serializable {

    private static final long serialVersionUID = 608355466921745661L;

    /**
     * 商品ID
     */
    private int id;

    /**
     * 商品价格
     */
    private int price;

    /**
     * 商品名称
     */
    private String name;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                price == product.price &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
