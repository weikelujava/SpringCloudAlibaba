package com.smart.demo.designpattern.strategy;

/**
 * @author weike
 */
public interface Comparator<T> {

    /**
     * 比较排序
     * 按照o1和o2的属性进行排序
     * 如果o1的属性值大于o2的属性值，返回 -1
     * 如果o1的属性值小于o2的属性值，返回 1
     * 如果o1的属性值等于o2的属性值，返回 0
     *
     * @param o1
     * @param o2
     * @return
     */
    int compare(T o1,T o2);
}
