//package com.smart.demo.test;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author lukewei
// * @date 2021/5/17 16:13
// */
//public class Test3 {
//
//
//    public static void main(String[] args) {
//
//
//        Integer a = 1;
//        Integer b = 13;
//
//
//        BigDecimal d = new BigDecimal(1).divide(new BigDecimal(b),2,BigDecimal.ROUND_DOWN);
//
//        System.out.println(d.setScale(2,BigDecimal.ROUND_DOWN));
//
//        String key = CartCacheKey.CART_PREFIX+userCode;
//        ShopCartEntity shopCartEntity = ShopCartEntity.get();
//        // 校验当前用户的购物车是否在Redis中是否过期
//        Boolean notExist = shopCartEntity.getHashRedisUtil().hKeyNotExist(key);
//        if(notExist){
//            // 过期，从数据库中查询，并将数据写入Redis中
//            List<ShopCartVo> shopCartVoList = shopCartEntity.listShopCartSkuByUserCode(userCode);
//            ShopCartListVoParam shopCartListVoParam = shopCartEntity.getShopCartList(shopCartVoList,userCode);
//            ShopCartListVo shopCartListVo = ShopCartConvertUtils.INSTANCE.shopCartListVoParamToVo(shopCartListVoParam);
//            ShopCartListRespDto shopCartListRespDto = ShopCartConvertUtils.INSTANCE.shopCartListVoToRespDto(shopCartListVo);
//            return BaseRespDto.success(shopCartListRespDto);
//
//        }else {
//            // 未过期直接从Redis中查询
//            List<Object> cartRedisSkuList = shopCartEntity.getHashRedisUtil().hValues(key);
//            if(null == cartRedisSkuList || cartRedisSkuList.isEmpty()){
//                return BaseRespDto.success(new ShopCartListRespDto());
//            }
//            // 将 list 传到 aggr进行复合计算
//
//            List<ShopCartVo> shopCartVoList = new ArrayList<>(1);
//            for (Object obj : cartRedisSkuList) {
//                ShopCartVo shopCartVo = (ShopCartVo) obj;
//                shopCartVoList.add(shopCartVo);
//            }
//
//            ShopCartListVoParam shopCartListVoParam = shopCartEntity.getShopCartList(shopCartVoList,userCode);
//            ShopCartListVo shopCartListVo = ShopCartConvertUtils.INSTANCE.shopCartListVoParamToVo(shopCartListVoParam);
//            ShopCartListRespDto shopCartListRespDto = ShopCartConvertUtils.INSTANCE.shopCartListVoToRespDto(shopCartListVo);
//            return BaseRespDto.success(shopCartListRespDto);
//}
