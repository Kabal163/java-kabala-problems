package com.github.kabal163.java.problems.herofactory.hero;

public class SuperMan extends AbstractHero {

    public SuperMan(String name, int strength, Label label) {
        super(name, strength, label);
    }

    @Override
    public void useSuperPower() {
        System.out.println("Испепеление лазером из глаз");
    }
}
