package com.github.kabal163.java.problems.relayrace.solution;

import com.github.kabal163.java.problems.relayrace.solution.exception.BatonDroppedException;

import java.util.Random;

public class BatonTransfer {

    private final Random random;
    private final Athlete receiver;
    private final AthleteWithBaton contributor;

    public BatonTransfer(Athlete receiver, AthleteWithBaton contributor) {
        this.random = new Random();
        this.receiver = receiver;
        this.contributor = contributor;
    }

    /**
     * Безопасная передача палочки следующему атлету
     *
     * @return атлета, взявшего палочку
     */
    public AthleteWithBaton giveAway() {
        return contributor.transferTo(receiver);
    }

    /**
     * Рисковая передача палочки - атлет кидает палочку следующему атлету,
     * вместо того, чтобы сделать {@link #giveAway() безопасную передачу}.
     *
     * @return атлета, взявшего палочку
     * @throws BatonDroppedException в случае, если атлет не смог докинуть палочку
     */
    public AthleteWithBaton throwAway() throws BatonDroppedException {
        if (random.nextDouble() < Config.FAIL_CHANCE_WHILE_THROWING) {
            throw new BatonDroppedException("Атлет \"%s\" не смог докинуть палочку".formatted(contributor));
        }
        return giveAway();
    }
}
