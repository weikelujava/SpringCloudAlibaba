package com.smart.algorithm.dp;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lukewei
 * @date 2021/4/28 9:41
 */
public class DynamicProgrammingTest {

    private static List<Shop> shops = new ArrayList<>(3);
    private static List<PlatformCoupon> platformCoupons = new ArrayList<>(4);

    static {
        ShopCoupon c1 = new ShopCoupon("1", 20L, false);
        ShopCoupon c2 = new ShopCoupon("2", 30L, false);
        ShopCoupon c3 = new ShopCoupon("3", 40L, false);
        ShopCoupon c4 = new ShopCoupon("4", 20L, true);
        ShopCoupon c5 = new ShopCoupon("5", 35L, true);
        List<ShopCoupon> shopCoupon1 = Arrays.asList(c1, c2, c3, c4, c5);
        Shop s1 = new Shop("TF", shopCoupon1);

        ShopCoupon c6 = new ShopCoupon("6", 40L, false);
        ShopCoupon c7 = new ShopCoupon("7", 50L, false);
        ShopCoupon c8 = new ShopCoupon("8", 30L, true);
        ShopCoupon c9 = new ShopCoupon("9", 50L, true);
        ShopCoupon c10 = new ShopCoupon("10", 20L, true);
        List<ShopCoupon> shopCoupon2 = Arrays.asList(c6, c7, c8, c9, c10);
        Shop s2 = new Shop("GL", shopCoupon2);

        ShopCoupon c11 = new ShopCoupon("11", 20L, false);
        ShopCoupon c12 = new ShopCoupon("12", 60L, false);
        ShopCoupon c13 = new ShopCoupon("13", 20L, false);
        ShopCoupon c14 = new ShopCoupon("14", 30L, false);
        ShopCoupon c15 = new ShopCoupon("15", 50L, true);
        ShopCoupon c16 = new ShopCoupon("16", 30L, true);
        List<ShopCoupon> shopCoupon3 = Arrays.asList(c11, c12, c13, c14, c15, c16);
        Shop s3 = new Shop("SS", shopCoupon3);

        shops = Arrays.asList(s1, s2, s3);
        PlatformCoupon p1 = new PlatformCoupon("A", 20L, Arrays.asList("TF", "GL", "SS"));
        PlatformCoupon p2 = new PlatformCoupon("B", 30L, Arrays.asList("GL", "SS"));
        PlatformCoupon p3 = new PlatformCoupon("C", 40L, Arrays.asList("TF", "SS"));
        PlatformCoupon p4 = new PlatformCoupon("D", 60L, Collections.singletonList("SS"));

        platformCoupons = Arrays.asList(p1, p2, p3, p4);
    }


    public static void main(String[] args) {
        for (Shop shop : shops) {
            System.out.println(shop);
        }

        for (PlatformCoupon platformCoupon : platformCoupons) {
            System.out.println(platformCoupon);
        }
        // 排列所有组合 计算最优
        Map<String, List<ShopCoupon>> map = new HashMap<String, List<ShopCoupon>>(2);
        for (int i = 0; i < shops.size(); i++) {

            List<ShopCoupon> shopCoupons = shops.get(i).getShopCoupons();
            // 获取集合中以类型区分 类型为true和false的最大值
//
            Map<Boolean, List<ShopCoupon>> collect = shopCoupons.stream().collect(Collectors.groupingBy(ShopCoupon::isFlag));
            Iterator<Boolean> iterator = collect.keySet().iterator();
            Iterator<Map.Entry<Boolean, List<ShopCoupon>>> iterator1 = collect.entrySet().iterator();
            List<ShopCoupon> list = new ArrayList<>(1);
            while (true) {
                if (iterator1.hasNext()) {
                    Map.Entry<Boolean, List<ShopCoupon>> next = iterator1.next();
                    List<ShopCoupon> s1 = collect.get(next.getKey());
                    int max = s1.stream().mapToInt(shopCoupon -> Math.toIntExact(shopCoupon.getAmount())).max().getAsInt();
                    System.out.println("-----------------------------------" + iterator.next());
                    System.out.println(max);
                    ShopCoupon shopCoupon1 = s1.stream().max(Comparator.comparing(ShopCoupon::getAmount)).get();
                    System.out.println(shopCoupon1);
                    if(next.getKey()){
                        // 可叠加
                        list.add(shopCoupon1);
                    }else {
                        // 不可叠加
                        list.add(shopCoupon1);
                    }
                } else {
                    break;
                }
            }
            map.put(shops.get(i).getShopCode(), list);
        }

        Iterator<Map.Entry<String, List<ShopCoupon>>> iterator2 = map.entrySet().iterator();
        if (iterator2.hasNext()) {
            while (true) {
                if (iterator2.hasNext()) {
                    Map.Entry<String, List<ShopCoupon>> next = iterator2.next();
                    System.out.println(next.getKey() + ": " + next.getValue());
                } else {
                    break;
                }
            }
        }

        System.out.println("-------------循环-----------");
        // 循环
        System.out.println(map);


        Iterator<Map.Entry<String, List<ShopCoupon>>> iterator3 = map.entrySet().iterator();
        if (iterator3.hasNext()) {
            while (true) {
                if (iterator3.hasNext()) {
                    Map.Entry<String, List<ShopCoupon>> next = iterator3.next();
                    List<ShopCoupon> shopCoupons = next.getValue();
                    // 动态规划计算
                    for (ShopCoupon shopCoupon : shopCoupons) {
                        if(shopCoupon.isFlag()){
                            // 可叠加 + 平台券优惠组合
                            for (PlatformCoupon platformCoupon : platformCoupons) {

                            }
                        }
                    }

                } else {
                    break;
                }
            }
        }
    }

}
