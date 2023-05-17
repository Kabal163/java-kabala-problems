package com.github.kabal163.java.problems.herofactory.hero;

public class SpiderMan extends AbstractHero {

    public SpiderMan(String name, int strength, Label label) {
        super(name, strength, label);
    }

    @Override
    public void useSuperPower() {
        System.out.println("Атака паутиной");
    }
}
