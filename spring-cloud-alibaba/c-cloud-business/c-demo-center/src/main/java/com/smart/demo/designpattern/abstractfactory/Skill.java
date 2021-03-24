package com.smart.demo.designpattern.abstractfactory;

public class Skill {

    private String name;

    public Skill() {
    }

    public Skill(String name) {
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
        return "Skill{" +
                "name='" + name + '\'' +
                '}';
    }
}
