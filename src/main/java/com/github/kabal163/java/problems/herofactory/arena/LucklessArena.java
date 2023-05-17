package com.github.kabal163.java.problems.herofactory.arena;

import com.github.kabal163.java.problems.herofactory.hero.Hero;

/**
 * Арена, на которой нет понятия "удача". Победитель определяется
 * только исходя из силы героя.
 */
public class LucklessArena extends AbstractArena {

    @Override
    protected Hero defineWinner(Hero first, Hero second) {
        return first.getStrength() > second.getStrength() ? first : second;
    }
}
