package com.smart.demo.designpattern.strategy;

public class Category {

    int id;

    int priority;

    public Category() {
    }

    public Category(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", priority=" + priority +
                '}';
    }

}
