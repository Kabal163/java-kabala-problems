package com.github.kabal163.java.problems.relayrace.solution;

public class Athlete {

    protected final String name;

    public Athlete(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Имя атлета не может быть пустым");
        }
        this.name = name;
    }

    /**
     * Берет эстафетную палочку
     *
     * @param baton эстафетная палочка
     * @return атлета с полученной палочкой
     */
    public AthleteWithBaton takeBaton(Baton baton) {
        System.out.printf("Атлет \"%s\" успешно взял палочку%n", this);
        return new AthleteWithBaton(this.name, baton);
    }

    @Override
    public String toString() {
        return name;
    }
}
