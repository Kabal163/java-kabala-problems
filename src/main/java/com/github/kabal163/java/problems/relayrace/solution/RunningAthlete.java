package com.github.kabal163.java.problems.relayrace.solution;

public class RunningAthlete extends AthleteWithBaton {

    private final Athlete targetAthlete;

    public RunningAthlete(String name, Baton baton, Athlete targetAthlete) {
        super(name, baton);
        this.targetAthlete = targetAthlete;
    }

    /**
     * Подготавливает атлета к передаче палочки следующему атлету
     *
     * @return передачу палочки
     */
    public BatonTransfer prepareForTransfer() {
        System.out.printf("Атлет \"%s\" приготовился к передаче палочки для \"%s\"%n", this, targetAthlete);
        return new BatonTransfer(targetAthlete, this);
    }
}
