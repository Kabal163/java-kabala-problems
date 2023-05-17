package com.github.kabal163.java.problems.herofactory.hero;

public class Hulk extends AbstractHero {

    public Hulk(String name, int strength, Label label) {
        super(name, strength, label);
    }

    @Override
    public void useSuperPower() {
        System.out.println("Халк крушить, Халк ломать!");
    }
}
