package com.github.kabal163.java.problems.relayrace.solution.exception;

/**
 * Атлет не докинул палочку во время передачи
 */
public class BatonDroppedException extends Exception {

    public BatonDroppedException(String message) {
        super(message);
    }
}
