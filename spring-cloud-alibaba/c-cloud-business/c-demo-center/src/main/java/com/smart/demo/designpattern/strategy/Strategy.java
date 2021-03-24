package com.smart.demo.designpattern.strategy;

import java.util.Arrays;

/**
 * 策略模式
 *
 * @author weike
 */
public class Strategy {


    /**
     * 想对公园按照公园的优先级排序
     * 对商品按照价格高低排序
     *
     * 定义一个Comparator接口，所有需要进行比较的类都需要自己构造一个比较器，实现@{linked com.smart.demo.designpattern.strategyComparator}接口，
     * 在比较类@{linked CategoryPriorityComparator} @{linked productPriceComparator}中进行自己的属性比较
     * 在@{linked Sorter}类中通过泛型的使用来实现比较
     *
     * @param args
     */
    public static void main(String[] args) {

        Category[] categories = {new Category(1,5),new Category(2,9),new Category(3,2)};
        Sorter<Category> sorter = new Sorter<>();
        sorter.sort(categories,new CategoryPriorityComparator());
        System.out.println(Arrays.asList(categories));

        Product[] products = {new Product(1,20),new Product(2,2),new Product(3,10)};
        Sorter<Product> productSorter = new Sorter<>();
        productSorter.sort(products,new ProductPriceComparator());
        System.out.println(Arrays.asList(products));
    }
}
