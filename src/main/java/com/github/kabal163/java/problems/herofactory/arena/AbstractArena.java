package com.github.kabal163.java.problems.herofactory.arena;

import com.github.kabal163.java.problems.herofactory.hero.Hero;

public abstract class AbstractArena implements Arena {

    @Override
    public void fight(Hero first, Hero second) {
        validate(first, second);
        System.out.printf("""
                \nБитва начинается! Всех зрителей просим занять свои места!
                Сегодня в бою встретятся %s и %s. Первый боец представляет
                лейбл %s, второй %s. Оба являются достойными соперниками!
                Да начнется битва!
                """,
            first.getName(), second.getName(), first.getLabel(), second.getLabel()
        );
        System.out.printf("- %s: ", first.getName());
        first.useSuperPower();
        System.out.printf("- %s: ", second.getName());
        second.useSuperPower();

        System.out.println("Вот это бой! Такого мы с вами еще ни разу не видели!");

        System.out.printf("- %s: ", first.getName());
        first.useSuperPower();
        System.out.printf("- %s: ", second.getName());
        second.useSuperPower();

        Hero winner = defineWinner(first, second);

        System.out.printf("А вот и наш победитель - %s!!!\n", winner.getName());
    }

    /**
     * Определяет и возвращает победителя сражения
     *
     * @param first  первый герой, участвующий в сражении
     * @param second второй герой, участвующий в сражении
     * @return победителя
     * @implSpec не должен возвращать {@code null}
     */
    protected abstract Hero defineWinner(Hero first, Hero second);

    private static void validate(Hero first, Hero second) {
        if (first == null) {
            throw new IllegalArgumentException("Первый герой не может быть null");
        }
        if (second == null) {
            throw new IllegalArgumentException("Второй герой не может быть null");
        }
    }
}
