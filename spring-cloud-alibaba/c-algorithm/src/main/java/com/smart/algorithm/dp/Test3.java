package com.smart.algorithm.dp;

import java.util.*;

/**
 * @author lukewei
 * @date 2021/5/8 10:49
 */
public class Test3 {

    private static List<Shop> shops = new ArrayList<>(3);
    private static List<PlatformCoupon> platformCoupons = new ArrayList<>(4);

    static {
        ShopCoupon c1 = new ShopCoupon("1", 20L, false,"a");
        ShopCoupon c2 = new ShopCoupon("2", 30L, false,"b");
        ShopCoupon c3 = new ShopCoupon("3", 40L, false,"c");
        ShopCoupon c4 = new ShopCoupon("4", 20L, true,"b,a");
        ShopCoupon c5 = new ShopCoupon("5", 35L, true,"a,b,c");
        List<ShopCoupon> shopCoupon1 = Arrays.asList(c1, c2, c3, c4, c5);
        Shop s1 = new Shop("TF", shopCoupon1);

        ShopCoupon c6 = new ShopCoupon("6", 40L, false,"a1");
        ShopCoupon c7 = new ShopCoupon("7", 50L, false,"b1");
        ShopCoupon c8 = new ShopCoupon("8", 30L, true,"c1");
        ShopCoupon c9 = new ShopCoupon("9", 50L, true,"a1,b1");
        ShopCoupon c10 = new ShopCoupon("10", 20L, true,"a1,b1,c1");
        List<ShopCoupon> shopCoupon2 = Arrays.asList(c6, c7, c8, c9, c10);
        Shop s2 = new Shop("GL", shopCoupon2);

        ShopCoupon c11 = new ShopCoupon("11", 20L, false,"a2");
        ShopCoupon c12 = new ShopCoupon("12", 60L, false,"b2");
        ShopCoupon c13 = new ShopCoupon("13", 20L, false,"c2");
        ShopCoupon c14 = new ShopCoupon("14", 30L, false,"a2,b2");
        ShopCoupon c15 = new ShopCoupon("15", 50L, true,"b2,c2");
        ShopCoupon c16 = new ShopCoupon("16", 30L, true,"a2,b2,c2");
        List<ShopCoupon> shopCoupon3 = Arrays.asList(c11, c12, c13, c14, c15, c16);
        Shop s3 = new Shop("SS", shopCoupon3);

        shops = Arrays.asList(s1, s2, s3);
        PlatformCoupon p1 = new PlatformCoupon("A", 20L, Arrays.asList("TF", "GL", "SS"),"a1,a2,a3");
        PlatformCoupon p2 = new PlatformCoupon("B", 30L, Arrays.asList("GL", "SS"),"a1,a2");
        PlatformCoupon p3 = new PlatformCoupon("C", 40L, Arrays.asList("TF", "SS"),"a1,c2");
        PlatformCoupon p4 = new PlatformCoupon("D", 60L, Collections.singletonList("SS"),"c2");

        platformCoupons = Arrays.asList(p1, p2, p3, p4);
    }




    public static void main(String[] args) {

        // 存放
        List<Temp> tempList = new ArrayList<>(1);

        // 存放最大的优惠对象
        Temp obj = new Temp();

        if (shops.size() > 0) {

            for (Shop shop : shops) {

                List<ShopCoupon> shopCoupons = shop.getShopCoupons();

                for (ShopCoupon shopCoupon : shopCoupons) {
                    if (shopCoupon.isFlag()) {

                        // 校验是否含有平台券
                        if (platformCoupons.size() > 0) {

                            // 如果有平台券
                            for (PlatformCoupon platformCoupon : platformCoupons) {
                                Temp temp = new Temp();
                                // 如果店铺券的作用域商品的的长度 > 平台券的作用域商品的长度
                                if (shopCoupon.getProductCode().length() > platformCoupon.getProductCode().length()) {

                                    if (shopCoupon.getProductCode().contains(platformCoupon.getProductCode())) {

                                        Long totalAmount = shopCoupon.getAmount() + platformCoupon.getAmount();

                                        if(obj.getTotalAmount() < totalAmount){
                                            obj.setShopCoupon(shopCoupon);
                                            obj.setPlatformCoupon(platformCoupon);
                                            obj.setTotalAmount(totalAmount);
                                        }

                                        // 统计平台券优惠和店铺优惠总金额相等的 所有可能
                                        if(shopCoupon.getAmount().equals(totalAmount)){
                                            temp.setShopCoupon(shopCoupon);
                                            temp.setPlatformCoupon(platformCoupon);
                                            temp.setTotalAmount(totalAmount);
                                            tempList.add(temp);
                                        }


                                    } else {
                                        // 店铺优惠金额
                                        Long shopAmount = shopCoupon.getAmount();
                                        // 平台优惠金额
                                        Long platAmount = platformCoupon.getAmount();

                                        if (shopAmount >= platAmount) {

                                            if(obj.getTotalAmount() < shopAmount){
                                                obj.setShopCoupon(shopCoupon);
                                                obj.setTotalAmount(shopAmount);
                                            }

                                            // 统计平台券优惠和店铺优惠总金额相等的 所有可能
                                            if(shopCoupon.getAmount().equals(shopAmount)){
                                                temp.setShopCoupon(shopCoupon);
                                                temp.setTotalAmount(shopAmount);
                                                tempList.add(temp);
                                            }

                                        } else {


                                            if(obj.getTotalAmount() < platAmount){
                                                obj.setPlatformCoupon(platformCoupon);
                                                obj.setTotalAmount(platAmount);
                                            }

                                            // 统计平台券优惠和店铺优惠总金额相等的 所有可能
                                            if(shopCoupon.getAmount().equals(platAmount)){
                                                temp.setPlatformCoupon(platformCoupon);
                                                temp.setTotalAmount(platAmount);
                                                tempList.add(temp);
                                            }
                                        }

                                    }

                                } else if (shopCoupon.getProductCode().length() < platformCoupon.getProductCode().length()) {

                                    if (platformCoupon.getProductCode().contains(shopCoupon.getProductCode())) {

                                        Long totalAmount = shopCoupon.getAmount() + platformCoupon.getAmount();
                                        obj.setShopCoupon(shopCoupon);
                                        obj.setPlatformCoupon(platformCoupon);
                                        obj.setTotalAmount(totalAmount);
                                    } else {
                                        // 店铺优惠金额
                                        Long shopAmount = shopCoupon.getAmount();
                                        // 平台优惠金额
                                        Long platAmount = platformCoupon.getAmount();

                                        if (shopAmount > platAmount) {
                                            obj.setShopCoupon(shopCoupon);
                                            obj.setTotalAmount(shopAmount);
                                        } else {
                                            obj.setPlatformCoupon(platformCoupon);
                                            obj.setTotalAmount(platAmount);
                                        }

                                    }

                                } else {
                                    if (shopCoupon.getProductCode().contains(platformCoupon.getProductCode())) {

                                        Long totalAmount = shopCoupon.getAmount() + platformCoupon.getAmount();
                                        obj.setShopCoupon(shopCoupon);
                                        obj.setPlatformCoupon(platformCoupon);
                                        obj.setTotalAmount(totalAmount);
                                    } else {
                                        // 店铺优惠金额
                                        Long shopAmount = shopCoupon.getAmount();
                                        // 平台优惠金额
                                        Long platAmount = platformCoupon.getAmount();

                                        if (shopAmount >= platAmount) {
                                            obj.setShopCoupon(shopCoupon);
                                            obj.setTotalAmount(shopAmount);
                                        } else {
                                            obj.setPlatformCoupon(platformCoupon);
                                            obj.setTotalAmount(platAmount);
                                        }

                                    }
                                }
                            }
                        }

                    }else {

                        if(obj == null){
                            // 不可叠加券，只计算店铺的
                            obj.setShopCoupon(shopCoupon);
                            obj.setTotalAmount(shopCoupon.getAmount());
                        }else {
                            Long totalAmount = obj.getTotalAmount();

                            if(shopCoupon.getAmount() > totalAmount){
                                obj.setShopCoupon(shopCoupon);
                                obj.setTotalAmount(shopCoupon.getAmount());
                            }
                            // 统计平台券优惠和店铺优惠总金额相等的 所有可能
                            if(shopCoupon.getAmount().equals(totalAmount)){
                                tempList.add(obj);
                            }
                        }

                    }
                }


            }

        } else {


            if (platformCoupons.size() > 0) {

                for (PlatformCoupon platformCoupon : platformCoupons) {


                    for (Shop shop : shops) {

                        List<ShopCoupon> shopCoupons = shop.getShopCoupons();
                        if (shopCoupons.size() > 0) {


                            for (ShopCoupon shopCoupon : shopCoupons) {
                                // 如果店铺券的作用域商品的的长度 > 平台券的作用域商品的长度
                                if (shopCoupon.getProductCode().length() > platformCoupon.getProductCode().length()) {

                                    if (shopCoupon.getProductCode().contains(platformCoupon.getProductCode())) {

                                        Long totalAmount = shopCoupon.getAmount() + platformCoupon.getAmount();
                                        obj.setShopCoupon(shopCoupon);
                                        obj.setPlatformCoupon(platformCoupon);
                                        obj.setTotalAmount(totalAmount);
                                    } else {
                                        // 店铺优惠金额
                                        Long shopAmount = shopCoupon.getAmount();
                                        // 平台优惠金额
                                        Long platAmount = platformCoupon.getAmount();

                                        if (shopAmount >= platAmount) {
                                            obj.setShopCoupon(shopCoupon);
                                            obj.setTotalAmount(shopAmount);
                                        } else {
                                            obj.setPlatformCoupon(platformCoupon);
                                            obj.setTotalAmount(platAmount);
                                        }

                                    }

                                } else if (shopCoupon.getProductCode().length() < platformCoupon.getProductCode().length()) {

                                    if (platformCoupon.getProductCode().contains(shopCoupon.getProductCode())) {

                                        Long totalAmount = shopCoupon.getAmount() + platformCoupon.getAmount();
                                        obj.setShopCoupon(shopCoupon);
                                        obj.setPlatformCoupon(platformCoupon);
                                        obj.setTotalAmount(totalAmount);
                                    } else {
                                        // 店铺优惠金额
                                        Long shopAmount = shopCoupon.getAmount();
                                        // 平台优惠金额
                                        Long platAmount = platformCoupon.getAmount();

                                        if (shopAmount > platAmount) {
                                            obj.setShopCoupon(shopCoupon);
                                            obj.setTotalAmount(shopAmount);
                                        } else {
                                            obj.setPlatformCoupon(platformCoupon);
                                            obj.setTotalAmount(platAmount);
                                        }

                                    }

                                } else {
                                    if (shopCoupon.getProductCode().contains(platformCoupon.getProductCode())) {

                                        Long totalAmount = shopCoupon.getAmount() + platformCoupon.getAmount();
                                        obj.setShopCoupon(shopCoupon);
                                        obj.setPlatformCoupon(platformCoupon);
                                        obj.setTotalAmount(totalAmount);
                                    } else {
                                        // 店铺优惠金额
                                        Long shopAmount = shopCoupon.getAmount();
                                        // 平台优惠金额
                                        Long platAmount = platformCoupon.getAmount();

                                        if (shopAmount >= platAmount) {
                                            obj.setShopCoupon(shopCoupon);
                                            obj.setTotalAmount(shopAmount);
                                        } else {
                                            obj.setPlatformCoupon(platformCoupon);
                                            obj.setTotalAmount(platAmount);
                                        }

                                    }
                                }
                            }
                        }


                    }

                }
            }

        }


        System.out.println(obj);

    }

}
