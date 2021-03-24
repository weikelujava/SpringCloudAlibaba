package com.smart.demo.designpattern.abstractfactory;

public class Arms{

    private String name;

    public Arms() {
    }

    public Arms(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Arms{" +
                "name='" + name + '\'' +
                '}';
    }
}
