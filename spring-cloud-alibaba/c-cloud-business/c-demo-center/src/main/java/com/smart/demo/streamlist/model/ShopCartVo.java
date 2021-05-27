package com.smart.demo.streamlist.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lukewei
 * @date 2021/5/10 15:05
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopCartVo implements Serializable {

    private static final long serialVersionUID = -6582850138542297562L;

    /**
     * id, 主键自增
     */
    private Long id;

    /**
     * userCode, 用户编号
     */
    private String userCode;

    /**
     * skuCode, 商品规格编号
     */
    private String skuCode;

    /**
     * shopCode, 店铺编号
     */
    private String shopCode;

    /**
     * skuCount, 商品购买数量
     */
    private Integer skuCount;

    /**
     * productCode, 商品编号
     */
    private String productCode;

    /**
     * tenantId, 租户ID
     */
    private Integer tenantId;

    /**
     * status, 商品勾选标识，0：未勾选，1：已勾选；
     */
    private Integer status;

    /**
     * 商品加入购物车的系统时间的时间戳值，对应Redis中ZSet的Score
     */
    private Long addTime;

    /**
     * type, 数据产生类型，0：用户移除购物车产生，1：下单完成移除购物车产生，2：添加商品到购物车产生；
     */
    private Integer type;

    /**
     * create_pin, 创建者
     */
    private String createPin;

    /**
     * create_time, 创建时间
     */
    private Date createTime;

    /**
     * update_pin, 更新者
     */
    private String updatePin;

    /**
     * update_time, 更新时间（数据库自动）
     */
    private Date ts;

    /**
     * yn, 删除标识（默认：0）：0-未删除；1-删除
     */
    private Integer yn;

}
