package com.smart.demo.designpattern.abstractfactory;

public class UpFactory extends AbstractFactory {

    @Override
    Role createRole() {
        return new Role("程咬金");
    }

    @Override
    Arms createArms() {
        return new Arms("三板斧");
    }

    @Override
    Skill createSkill() {
        return new Skill("大招回血");
    }
}
