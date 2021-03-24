package com.smart.demo.designpattern.abstractfactory;

public class Test {


    public static void main(String[] args) {
        AbstractFactory up = new UpFactory();
        System.out.println(up.createRole());
        System.out.println(up.createArms());
        System.out.println(up.createSkill());

        System.out.println("-----------------------------------");

        AbstractFactory middle = new MiddleFactory();
        System.out.println(middle.createRole());
        System.out.println(middle.createArms());
        System.out.println(middle.createSkill());

        System.out.println("-----------------------------------");

        AbstractFactory down = new DownFactory();
        System.out.println(down.createRole());
        System.out.println(down.createArms());
        System.out.println(down.createSkill());
    }
}
