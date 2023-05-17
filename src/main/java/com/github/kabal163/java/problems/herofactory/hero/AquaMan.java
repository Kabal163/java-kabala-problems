package com.github.kabal163.java.problems.herofactory.hero;

public class AquaMan extends AbstractHero {

    public AquaMan(String name, int strength, Label label) {
        super(name, strength, label);
    }

    @Override
    public void useSuperPower() {
        System.out.println("Атака в стиле дельфинчика");
    }
}
