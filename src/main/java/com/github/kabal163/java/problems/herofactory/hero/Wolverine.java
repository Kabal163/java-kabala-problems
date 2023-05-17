package com.github.kabal163.java.problems.herofactory.hero;

public class Wolverine extends AbstractHero {

    public Wolverine(String name, int strength, Label label) {
        super(name, strength, label);
    }

    @Override
    public void useSuperPower() {
        System.out.println("Атака когтями");
    }
}
