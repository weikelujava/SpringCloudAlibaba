package com.smart.demo.designpattern.strategy;

/**
 * @author weike
 */
public class CategoryPriorityComparator implements Comparator<Category>{



    @Override
    public int compare(Category o1, Category o2) {
        if (o1.priority< o2.priority) {
            return 1;
        } else if (o1.priority > o2.priority) {
            return -1;
        } else {
            return 0;
        }
    }
}
