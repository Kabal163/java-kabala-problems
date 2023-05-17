package com.github.kabal163.java.problems.herofactory.hero;

public abstract class AbstractHero implements Hero {

    private final String name;
    private final int strength;
    private final Label label;

    public AbstractHero(String name, int strength, Label label) {
        validate(name, strength, label);
        this.name = name.toLowerCase();
        this.strength = strength;
        this.label = label;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public Label getLabel() {
        return label;
    }

    private static void validate(String name, int strength, Label label) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("name не может быть пустым");
        }
        if (strength < 0 || strength > 10) {
            throw new IllegalArgumentException("strength должен быть в диапазоне от 0 до 10 включительно");
        }
        if (label == null) {
            throw new IllegalArgumentException("label не может быть null");
        }
    }
}
