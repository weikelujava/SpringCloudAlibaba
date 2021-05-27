package com.smart.algorithm.dp;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lukewei
 * @date 2021/5/8 10:03
 */
public class DpTest {

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

    Map<String,List<ShopCoupon>> shopMap = new HashMap<>(3);

    LinkedList<List<ShopCoupon>> zuheList = new LinkedList<List<ShopCoupon>>();
    ShopCoupon[][]  temp = {};

        for (Shop shop : shops) {
            Map<Boolean, List<ShopCoupon>> map = shop.getShopCoupons().stream().collect(Collectors.groupingBy(ShopCoupon::isFlag));
            List<ShopCoupon> shopCoupons = new ArrayList<>(2);
            Iterator<Map.Entry<Boolean, List<ShopCoupon>>> iterator = map.entrySet().iterator();
            while (true){
                if(iterator.hasNext()){
                    Map.Entry<Boolean, List<ShopCoupon>> next = iterator.next();
                    ShopCoupon shopCoupon = next.getValue().stream().max(Comparator.comparing(ShopCoupon::getAmount)).get();
                    shopCoupon.setShopCode(shop.getShopCode());
//                    System.out.println(shopCoupon);
                    shopCoupons.add(shopCoupon);
                    continue;
                }
                break;
            }
            zuheList.add(shopCoupons);

            shopMap.put(shop.getShopCode(),shopCoupons);
        }


        System.out.println(shopMap);

        // todo 如何将map中，对不同key下的列表进行组合？？？
        // 比如 12+7+3 、12+7+5 ... 数字为couponCode值
        Iterator<Map.Entry<String, List<ShopCoupon>>> iterator = shopMap.entrySet().iterator();
        while (true){
            if(iterator.hasNext()){
                Map.Entry<String, List<ShopCoupon>> next = iterator.next();
                String key = next.getKey();
                List<ShopCoupon> value = next.getValue();


                continue;
            }
            break;
        }

    }





}
