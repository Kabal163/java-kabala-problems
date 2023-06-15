package com.github.kabal163.java.problems.relayrace.solution.exception;

/**
 * Атлет упал во время бега
 */
public class AthleteFailedException extends RuntimeException {

    public AthleteFailedException(String message) {
        super(message);
    }
}
