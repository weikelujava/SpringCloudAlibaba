package com.smart.demo.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Child {

    private boolean cry = false;

    private List<ObServer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }


    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        cry = true;
        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(),"bed",this);
        System.out.println(event.getSource());
        for (ObServer observer : observers) {
            observer.actionOnWakeUp(event);
        }

    }

    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }

    @Override
    public String toString() {
        return "Child{" +
                "cry=" + cry +
                ", observers=" + observers +
                '}';
    }
}

abstract class Event<T>{
    abstract T getSource();
}

class WakeUpEvent extends Event<Child>{
    long timestamp;
    String loc;
    Child source;

    public WakeUpEvent(long timestamp, String loc, Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }

    @Override
    Child getSource() {
        return source;
    }
}

interface ObServer{
    void actionOnWakeUp(WakeUpEvent event);
}

class Dad implements ObServer{

    public void feed(){
        System.out.println("dad feeding ...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        feed();
    }

    @Override
    public String toString() {
        return "Dad{}";
    }
}

class Mum implements ObServer{

    public void hug(){
        System.out.println("mum hug ...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        hug();
    }

    @Override
    public String toString() {
        return "Mum{}";
    }
}

class Dog implements ObServer{

    public void wang(){
        System.out.println("dog wang ...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        wang();
    }

    @Override
    public String toString() {
        return "Dog{}";
    }
}
