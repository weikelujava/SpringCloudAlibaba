package com.smart.demo.designpattern.abstractfactory;

public class MiddleFactory extends AbstractFactory{

    @Override
    Role createRole() {
        return new Role("小乔");
    }

    @Override
    Arms createArms() {
        return new Arms("五彩扇");
    }

    @Override
    Skill createSkill() {
        return new Skill("回旋流星扇");
    }
}
