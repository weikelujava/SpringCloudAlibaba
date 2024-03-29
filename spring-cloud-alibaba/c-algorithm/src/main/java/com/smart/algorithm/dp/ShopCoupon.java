package com.smart.algorithm.dp;

import java.io.Serializable;

/**
 * @author lukewei
 * @date 2021/4/30 17:09
 */

public class ShopCoupon implements Serializable {

    private static final long serialVersionUID = -2203725152894550565L;
    /**
     * 优惠券编号
     */
    private String couponCode;

    /**
     * 面值
     */
    private Long amount;

    /**
     * 是否可以叠加
     */
    private boolean flag;

    /**
     * 所属店铺编号
     */
    private String shopCode;


    /**
     * 商品编号
     */
    private String productCode;


    public ShopCoupon(String s, long l, boolean b, String tf,String productCode) {
    }

    public ShopCoupon(String couponCode, Long amount, boolean flag,String productCode) {
        this.couponCode = couponCode;
        this.amount = amount;
        this.flag = flag;
        this.productCode = productCode;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    public String getShopCode() {
        return shopCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    @Override
    public String toString() {
        return "ShopCoupon{" +
                "couponCode='" + couponCode + '\'' +
                ", amount=" + amount +
                ", flag=" + flag +
                ", shopCode=" + shopCode +
                ", productCode=" + productCode +
                '}';
    }
}
