package com.smart.demo.redis.controller;

public enum  TestEnum {

    CART_UPDATE_1(1,"修改购物车");

    int type;
    String remark;

    TestEnum(int type, String remark) {
        this.type = type;
        this.remark = remark;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
