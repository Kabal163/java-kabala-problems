package com.github.kabal163.java.problems.herofactory.hero;

public class BatMan extends AbstractHero {

    public BatMan(String name, int strength, Label label) {
        super(name, strength, label);
    }

    @Override
    public void useSuperPower() {
        System.out.println("Атака в стиле летучей мыши");
    }
}
