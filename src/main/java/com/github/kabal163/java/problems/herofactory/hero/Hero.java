package com.github.kabal163.java.problems.herofactory.hero;

/**
 * Определяет базовое поведение героя.
 *
 * @see AbstractHero
 */
public interface Hero {

    /**
     * Возвращает имя героя.
     *
     * @return имя героя
     * @implSpec имя героя должно быть в нижнем регистре.
     * Не должен возвращать {@code null}
     */
    String getName();

    /**
     * Возвращает силу героя в диапазоне от 0 до 10 включительно.
     * Чем выше уровень силы, тем сильнее герой.
     *
     * @return силу героя
     */
    int getStrength();

    /**
     * Возвращает название лейбла, к которому принадлежит герой.
     *
     * @return лейбл супер героя
     * @implSpec не должен возвращать {@code null}
     */
    Label getLabel();

    /**
     * Использует силу героя.
     */
    void useSuperPower();
}
