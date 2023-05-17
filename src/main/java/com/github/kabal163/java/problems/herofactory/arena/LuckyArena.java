package com.github.kabal163.java.problems.herofactory.arena;

import com.github.kabal163.java.problems.herofactory.hero.Hero;

import java.util.Random;

/**
 * Арена, на которой шанс победить есть у каждого. Здесь
 * победа зависит не только от силы соперников, но также
 * от того, на чьей стороне сегодня удача.
 */
public class LuckyArena extends AbstractArena {

    private final Random random = new Random();

    @Override
    protected Hero defineWinner(Hero first, Hero second) {
        int firstHeroPower = random.nextInt(first.getStrength() + 1);
        int secondHeroPower = random.nextInt(second.getStrength() + 1);

        return firstHeroPower > secondHeroPower ? first : second;
    }
}
