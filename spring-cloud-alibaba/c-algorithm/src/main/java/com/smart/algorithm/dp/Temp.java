package com.smart.algorithm.dp;

import java.io.Serializable;

/**
 * @author lukewei
 * @date 2021/5/31 10:51
 */
public class Temp implements Serializable {

    private static final long serialVersionUID = 1777258425226780134L;


    /**
     * 店铺优惠券
     */
    private ShopCoupon shopCoupon;

    /**
     * 平台优惠券
     */
    private PlatformCoupon platformCoupon;

    /**
     * 合计总优惠
     */
    private Long totalAmount = 0L;

    public Temp() {
    }

    public ShopCoupon getShopCoupon() {
        return shopCoupon;
    }

    public void setShopCoupon(ShopCoupon shopCoupon) {
        this.shopCoupon = shopCoupon;
    }

    public PlatformCoupon getPlatformCoupon() {
        return platformCoupon;
    }

    public void setPlatformCoupon(PlatformCoupon platformCoupon) {
        this.platformCoupon = platformCoupon;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Temp{" +
                "shopCoupon=" + shopCoupon +
                ", platformCoupon=" + platformCoupon +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
