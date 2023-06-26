package com.github.kabal163.java.problems.bank.solution;

import org.apache.commons.collections4.CollectionUtils;

import javax.annotation.concurrent.Immutable;
import java.util.Collection;
import java.util.Collections;

/**
 * Банковская ячейка
 */
@Immutable
public class Cell {

    private final Collection<Mark> marks;
    private final Collection<Banknote> banknotes;

    public Cell() {
        this.marks = Collections.emptyList();
        this.banknotes = Collections.emptyList();
    }

    public Cell(Collection<Mark> marks, Collection<Banknote> banknotes) {
        this.marks = marks;
        this.banknotes = banknotes;
    }

    /**
     * Добавляет банкноты к уже существующим.
     *
     * @param banknotes добавляемые банкноты
     * @return новый экземпляр ячейки, содержащий добавленные банкноты
     */
    public Cell putBanknotes(Collection<Banknote> banknotes) {
        return new Cell(marks, CollectionUtils.union(this.banknotes, banknotes));
    }

    /**
     * Добавляет марки к уже существующим.
     *
     * @param marks добавляемые марки
     * @return новый экземпляр ячейки, содержащий добавленные марки
     */
    public Cell putMarks(Collection<Mark> marks) {
        return new Cell(CollectionUtils.union(this.marks, marks), banknotes);
    }

    /**
     * Рассчитывает и возвращает текущий баланс ячейки - сумма номиналов всех банкнот.
     *
     * @return текущий баланс
     */
    public int balance() {
        return banknotes.stream()
            .map(Banknote::getDenomination)
            .map(Banknote.Denomination::getValue)
            .reduce(0, Integer::sum);
    }
}
