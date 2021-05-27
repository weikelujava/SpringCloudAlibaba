package com.smart.algorithm.dp;


import java.util.*;

/**
 * @ClassName
 * @Description <p> TODO </p>
 * @Author jackstraw_yu
 * @Date 2021/5/8 13:33
 **/
public class CouponCalculatorNew {

    /**
     *
     * 最优优惠计算
     *
     *  店铺TF
     *   不可叠加：店铺1券 20; 店铺2券 30; 店铺3券 40
     *   可叠加： 店铺4券 20; 店铺5券 35
     *
     *  店铺GL
     *   不可叠加：店铺6券 40; 店铺7券 50
     *   可叠加： 店铺8券 30; 店铺9券 50; 店铺10券 20
     *
     *  店铺SS
     *   不可叠加：店铺11券 20; 店铺12券 60; 店铺13券 20; 店铺14券 30
     *   可叠加：店铺15券 50; 店铺16券 30
     ************************************************************
     *  平台券A 20  适用于(TF GL SS); 平台券B 30 适用于(GL SS)
     *  平台券C 40  适用于(TF GL); 平台券D 60 适用于(SS)
     ***********************************************************
     *  计算路径：店铺3券
     *
     *   店铺3券(40)+店铺9券(50)+店铺12券(60)=150
     *   店铺3券+店铺9券+店铺15券+平台券B=170
     *   店铺3券+店铺9券+店铺15券+平台券D=200
     *   店铺5券+店铺9券+店铺12券+平台券C=185
     *   店铺5券+店铺9券+店铺15券+平台券A=155
     *   店铺5券+店铺9券+店铺15券+平台券B=165
     *   店铺5券+店铺9券+店铺15券+平台券C=175
     *   店铺5券+店铺9券+店铺15券+平台券D=195
     *   .....
     *  所以最大优惠金额为 200
     **************************************************************
     *  备注:
     *      假设 店铺TF下使用了 不可叠加券3 店铺GL使用了可叠加的店铺券9
     *      店铺SS使用了可叠加的店铺券15 那么 与平台优惠券组合的时候就不会组合平台A券，可以使用平台券B和平台券D
     *      就是把3个店铺下的优惠券组合到一起，然后在与平台券组合,如果发现店铺优惠券的类型为补可叠加，那就不能与可以使用的平台券组合。
     *
     */


    private static List<Shop> shops = new ArrayList(){{
        add(new Shop("TF", new ArrayList<ShopCoupon>(){{
            add(new ShopCoupon("1", 20L, false,"TF"));
            add(new ShopCoupon("2", 30L, false,"TF"));
            add(new ShopCoupon("3", 40L, false,"TF"));
            add(new ShopCoupon("4", 20L, true,"TF"));
            add(new ShopCoupon("5", 35L, true,"TF"));
        }}));
        add(new Shop("GL",  new ArrayList<ShopCoupon>(){{
            add(new ShopCoupon("6", 40L, false,"GL"));
            add(new ShopCoupon("7", 50L, false,"GL"));
            add(new ShopCoupon("8", 30L, true,"GL"));
            add(new ShopCoupon("9", 50L, true,"GL"));
            add(new ShopCoupon("10", 20L, true,"GL"));
        }}));
        add(new Shop("SS", new ArrayList<ShopCoupon>(){{
            add(new ShopCoupon("11", 20L, false,"SS"));
            add(new ShopCoupon("12", 60L, false,"SS"));
            add(new ShopCoupon("13", 20L, false,"SS"));
            add(new ShopCoupon("14", 30L, false,"SS"));
            add(new ShopCoupon("15", 50L, true,"SS"));
            add(new ShopCoupon("16", 30L, true,"SS"));
        }}));

    }};
    private static List<PlatformCoupon> platformCoupons = new ArrayList(){{
        add(new PlatformCoupon("A", 20L, Arrays.asList("TF", "GL", "SS")));
        add(new PlatformCoupon("B", 30L, Arrays.asList("GL", "SS")));
        add(new PlatformCoupon("C", 40L, Arrays.asList("TF", "SS")));
        add(new PlatformCoupon("D", 60L, Collections.singletonList("SS")));
    }};

    /**
     * 需求: 假设现在买了上述三个店铺的东西  然后还有ABCD四个平台优惠券 怎么配置优惠券
     */


    public static void main(String[] args) {
        //先构造-> map<店铺,[平台优惠券...]>
        Map<String,List<PlatformCoupon>> mapPlatform = new HashMap();
        platformCoupons.forEach(x->{
            List<String> used = x.getUsed();
            used.forEach(key->{
                List<PlatformCoupon> platforms = mapPlatform.get(key);
                if(platforms==null) platforms= new ArrayList();
                if(!platforms.contains(x)) platforms.add(x);//偷懒一下 hashcode&equals
                mapPlatform.put(key,platforms);
            });
        });
        List<List<ShopCoupon>> result = new ArrayList();
        //组合店铺优惠券 三家店铺5*5*5
        combineShop(shops,0,result);
        //在组合 平台优惠券 TODO 将店铺List<ShopCoupon> 抽取成一个DTO

        System.out.println("adsfasdfasfasdfas");


    }

    public static void combineShop(List<Shop> shops, int index, List<List<ShopCoupon>> result){
        if(index>=shops.size()) return;
        Shop shop = shops.get(index);
        if(shop.getShopCoupons()==null || shop.getShopCoupons().isEmpty()){
            combineShop(shops,++index,result);
            return;
        }
        if(result.isEmpty())
            for(ShopCoupon coupon : shop.getShopCoupons()) result.add(new ArrayList<ShopCoupon>(){{add(coupon);}});
        else {
            List<List<ShopCoupon>> copy = new ArrayList(){{//DEEP COPY
                for(List<ShopCoupon> list:result) add(new ArrayList<ShopCoupon>(list));
            }};
            result.clear();
            //a/b  1/2 ->a1 a2 b1 b2
            //A/B ->a1A a1B a2A a2B b1A b1B b2A b2B
            //....
            for(List<ShopCoupon> list:copy){
                //for(ShopCoupon coupon :list){
                for (ShopCoupon temp : shop.getShopCoupons()) {
                    result.add(new ArrayList(list){{add(temp);}});
                }
            }
        }
        combineShop(shops,++index,result);
    }





}
