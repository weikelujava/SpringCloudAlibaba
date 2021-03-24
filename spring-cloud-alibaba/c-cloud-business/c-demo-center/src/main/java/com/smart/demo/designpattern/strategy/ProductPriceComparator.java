package com.smart.demo.designpattern.strategy;

/**
 * @author weike
 */
public class ProductPriceComparator implements Comparator<Product> {


    @Override
    public int compare(Product o1, Product o2) {
        if(o1.price < o2.price){
            return -1;
        }else if(o1.price > o2.price){
            return 1;
        }else {
            return 0;
        }
    }
}
