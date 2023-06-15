package com.github.kabal163.java.problems.relayrace.solution;

import com.github.kabal163.java.problems.relayrace.solution.exception.AthleteFailedException;

import java.util.Random;

import static com.github.kabal163.java.problems.relayrace.solution.Config.FAIL_CHANCE_WHILE_RUNNING;

public class AthleteWithBaton extends Athlete {

    private final Random random;
    protected final Baton baton;

    public AthleteWithBaton(String name, Baton baton) {
        super(name);
        if (baton == null) {
            throw new IllegalArgumentException("Эстафетная полочка не может быть null");
        }
        this.random = new Random();
        this.baton = baton;
    }

    /**
     * Начинает бежать с палочкой к следующему атлету
     *
     * @param targetAthlete следующий атлет, которому нужно передать палочку
     * @return бегущего атлета
     */
    public RunningAthlete runTo(Athlete targetAthlete) {
        if (random.nextDouble() < FAIL_CHANCE_WHILE_RUNNING) {
            throw new AthleteFailedException("Атлет \"%s\" споткнулся и упал".formatted(this));
        }
        System.out.printf("Атлет \"%s\" побежал дальше%n", this);
        return new RunningAthlete(super.name, this.baton, targetAthlete);
    }

    public void runToFinish() {
        System.out.printf("Атлет \"%s\" успешно финишировал%n", this);
    }

    AthleteWithBaton transferTo(Athlete receiver) {
        return receiver.takeBaton(this.baton);
    }
}
