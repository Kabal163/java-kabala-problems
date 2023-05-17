package com.github.kabal163.java.problems.herofactory.hero;

public class HeroFactory {

    public Hero newInstance(Class<? extends Hero> type) {
        if (type.isAssignableFrom(AquaMan.class)) {
            return new AquaMan("аквамен", 5, Label.DC);
        }
        if (type.isAssignableFrom(BatMan.class)) {
            return new BatMan("бэтмен", 4, Label.DC);
        }
        if (type.isAssignableFrom(SuperMan.class)) {
            return new SuperMan("супермен", 9, Label.DC);
        }
        if (type.isAssignableFrom(Hulk.class)) {
            return new Hulk("халк", 9, Label.MARVEL);
        }
        if (type.isAssignableFrom(Hulk.class)) {
            return new SpiderMan("человек паук", 6, Label.MARVEL);
        }
        if (type.isAssignableFrom(Hulk.class)) {
            return new Wolverine("росомаха", 7, Label.MARVEL);
        }
        throw new IllegalArgumentException("Неизвестный тип героя: %s".formatted(type.getName()));
    }
}
