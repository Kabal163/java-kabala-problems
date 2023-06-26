package com.github.kabal163.java.problems.bank.solution;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Банковская купюра
 */
@Data
public class Banknote {

    /**
     * Номинал купюры
     */
    @Getter
    @RequiredArgsConstructor
    public enum Denomination {

        ONE(1),
        FIVE(5),
        TEN(10),
        FIFTY(50),
        ONE_HUNDRED(100),
        FIVE_HUNDRED(500),
        ONE_THOUSAND(1000);

        private final int value;
    }

    private final Denomination denomination;
}
