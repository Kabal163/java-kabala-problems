package com.github.kabal163.java.problems.herofactory.arena;

import com.github.kabal163.java.problems.herofactory.hero.Hero;

public interface Arena {

    /**
     * Отправляет на сражение двух героев, используя их суперспособности.
     *
     * @param first  первый герой, отправленный на сражение
     * @param second второй герой, отправленный на сражение
     * @implSpec победитель может быть только один
     * @throws IllegalArgumentException если любой из аргументов равен {@code null}
     */
    void fight(Hero first, Hero second);
}
