package com.smart.demo.designpattern.abstractfactory;

public abstract class AbstractFactory {

    /**
     * 创建角色
     * @return
     */
    abstract Role createRole();

    /**
     * 创建武器
     * @return
     */
    abstract Arms createArms();


    /**
     * 创建技能
     * @return
     */
    abstract Skill createSkill();
}
