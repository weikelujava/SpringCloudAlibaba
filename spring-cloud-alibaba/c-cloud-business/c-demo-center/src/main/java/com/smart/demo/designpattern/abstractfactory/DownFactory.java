package com.smart.demo.designpattern.abstractfactory;

public class DownFactory extends AbstractFactory {
    @Override
    Role createRole() {
        return new Role("鲁班7号");
    }

    @Override
    Arms createArms() {
        return new Arms("小手枪");
    }

    @Override
    Skill createSkill() {
        return new Skill("螺旋盘转");
    }
}
