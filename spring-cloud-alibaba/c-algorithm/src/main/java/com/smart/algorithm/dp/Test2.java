//package com.smart.algorithm.dp;
//
//import java.util.*;
//
///**
// * @author lukewei
// * @date 2021/5/7 17:31
// *
// * 背包问题
// */
//public class Test2 {
//    private static List<Shop> shops = new ArrayList<>(3);
//    private static List<PlatformCoupon> platformCoupons = new ArrayList<>(4);
//
//    static {
//        ShopCoupon c1 = new ShopCoupon("1", 20L, false);
//        ShopCoupon c2 = new ShopCoupon("2", 30L, false);
//        ShopCoupon c3 = new ShopCoupon("3", 40L, false);
//        ShopCoupon c4 = new ShopCoupon("4", 20L, true);
//        ShopCoupon c5 = new ShopCoupon("5", 35L, true);
//        List<ShopCoupon> shopCoupon1 = Arrays.asList(c1, c2, c3, c4, c5);
//        Shop s1 = new Shop("TF", shopCoupon1);
//
//        ShopCoupon c6 = new ShopCoupon("6", 40L, false);
//        ShopCoupon c7 = new ShopCoupon("7", 50L, false);
//        ShopCoupon c8 = new ShopCoupon("8", 30L, true);
//        ShopCoupon c9 = new ShopCoupon("9", 50L, true);
//        ShopCoupon c10 = new ShopCoupon("10", 20L, true);
//        List<ShopCoupon> shopCoupon2 = Arrays.asList(c6, c7, c8, c9, c10);
//        Shop s2 = new Shop("GL", shopCoupon2);
//
//        ShopCoupon c11 = new ShopCoupon("11", 20L, false);
//        ShopCoupon c12 = new ShopCoupon("12", 60L, false);
//        ShopCoupon c13 = new ShopCoupon("13", 20L, false);
//        ShopCoupon c14 = new ShopCoupon("14", 30L, false);
//        ShopCoupon c15 = new ShopCoupon("15", 50L, true);
//        ShopCoupon c16 = new ShopCoupon("16", 30L, true);
//        List<ShopCoupon> shopCoupon3 = Arrays.asList(c11, c12, c13, c14, c15, c16);
//        Shop s3 = new Shop("SS", shopCoupon3);
//
//        shops = Arrays.asList(s1, s2, s3);
//        PlatformCoupon p1 = new PlatformCoupon("A", 20L, Arrays.asList("TF", "GL", "SS"));
//        PlatformCoupon p2 = new PlatformCoupon("B", 30L, Arrays.asList("GL", "SS"));
//        PlatformCoupon p3 = new PlatformCoupon("C", 40L, Arrays.asList("TF", "SS"));
//        PlatformCoupon p4 = new PlatformCoupon("D", 60L, Collections.singletonList("SS"));
//
//        platformCoupons = Arrays.asList(p1, p2, p3, p4);
//    }
//
//    public int maxW =  Integer.MIN_VALUE;
//
//
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int num=sc.nextInt();
//        int sum=sc.nextInt();
//        int[] price=new int[num];
//        for (int i = 0; i < price.length; i++) {
//            price[i]=sc.nextInt();
//        }
//        int[][] count=new int[num][sum+1];
//        for (int i = 1; i <= sum; i++) {
//            if (i<=price[0]) {
//                count[0][i]=price[0];
//            } else {
//                count[0][i]=200000000;
//            }
//        }
//
//        for (int i = 1; i < count.length; i++) {
//            int a=i;
//            for (int j = 0; j <= sum; j++) {
//                if (j<=price[i]) {
//                    count[i][j]=Math.min(price[i],count[i-1][j]);
//                } else {
//                    count[i][j]=Math.min(price[i]+count[i-1][j-price[i]],count[i-1][j]);
//                }
//            }
//        }
//
//        System.out.println(count[count.length-1][sum]);
//
//    }
//
//
//
//
//
//
//
//
//
//
//}
