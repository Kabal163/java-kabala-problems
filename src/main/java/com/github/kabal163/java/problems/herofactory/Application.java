package com.github.kabal163.java.problems.herofactory;

import com.github.kabal163.java.problems.herofactory.arena.Arena;
import com.github.kabal163.java.problems.herofactory.arena.LuckyArena;
import com.github.kabal163.java.problems.herofactory.arena.LucklessArena;
import com.github.kabal163.java.problems.herofactory.hero.Hero;
import com.github.kabal163.java.problems.herofactory.hero.HeroFactory;
import com.github.kabal163.java.problems.herofactory.hero.Hulk;
import com.github.kabal163.java.problems.herofactory.hero.SuperMan;

public class Application {

    public static void main(String[] args) {
        HeroFactory heroFactory = new HeroFactory();
        Arena lucklessArena = new LucklessArena();
        Arena luckfulArena = new LuckyArena();

        Hero hulk = heroFactory.newInstance(Hulk.class);
        Hero superMan = heroFactory.newInstance(SuperMan.class);

        lucklessArena.fight(hulk, superMan);
        System.out.println("\n===============");
        luckfulArena.fight(hulk, superMan);
    }
}
