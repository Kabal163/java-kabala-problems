package com.github.kabal163.java.problems.relayrace;

import com.github.kabal163.java.problems.relayrace.solution.Athlete;
import com.github.kabal163.java.problems.relayrace.solution.Baton;
import com.github.kabal163.java.problems.relayrace.solution.exception.AthleteFailedException;
import com.github.kabal163.java.problems.relayrace.solution.exception.BatonDroppedException;

/*
Эстафета с исключениями

Давайте организуем соревнования – передачу эстафетной палочки.
Что нам для этого нужно? Наверное, нам понадобится две сущность – эстафетная палочка и спортсмен.
Давайте создадим несколько спортсменов (штук 10), сделаем одну палочку и пусть они передают ее друг
другу. У них при этом будет 2 метода:
- Безопасная передача палочки. Палочка передается, и мы считаем, что ничто не предвещает беды.
Однако спортсмен может споткнуться и упасть, тогда должны быть выкинуто исключение (упали во время
бега). Подумайте, какого типа тут должно быть исключение (check или unchecked).
- Рисковая передача палочки – это когда спортсмен еще не добежал до своего товарища и швыряет ему
эту палочку. Тогда другой спортсмен может не поймать ее. Подумайте, какого типа тут должно быть
исключение.
Эти два метода должны выкидывать исключение с вероятностью 20% (можете сделать свою вероятность).

Не забудьте в main методе обработать исключения. В качестве обработки можем считать обычный вывод в
консоль сообщения о том, что произошло исключение.
 */
public class Application {

    public static void main(String[] args) {
        Athlete mihail = new Athlete("Михаил");
        Athlete alexey = new Athlete("Алексей");
        Athlete artem = new Athlete("Артем");
        Athlete dmitrii = new Athlete("Дмитрий");
        Athlete sergei = new Athlete("Сергей");
        Athlete vladislav = new Athlete("Владислав");
        Athlete konstantin = new Athlete("Константин");
        Athlete vladimir = new Athlete("Владимир");
        Athlete nikolai = new Athlete("Николай");
        Athlete stepan = new Athlete("Степан");

        Baton baton = new Baton();

        try {
            mihail.takeBaton(baton)
                .runTo(alexey)
                .prepareForTransfer().giveAway()
                .runTo(artem)
                .prepareForTransfer().giveAway()
                .runTo(dmitrii)
                .prepareForTransfer().throwAway()
                .runTo(sergei)
                .prepareForTransfer().giveAway()
                .runTo(vladislav)
                .prepareForTransfer().throwAway()
                .runTo(konstantin)
                .prepareForTransfer().giveAway()
                .runTo(vladimir)
                .prepareForTransfer().throwAway()
                .runTo(nikolai)
                .prepareForTransfer().throwAway()
                .runTo(stepan)
                .prepareForTransfer().giveAway()
                .runToFinish();
        } catch (BatonDroppedException ex) {
            // логика по обработке исключения
            System.out.println(ex.getMessage());
        } catch (AthleteFailedException ex) {
            // логика для обработки другого исключения
            System.out.println(ex.getMessage());
        }
    }
}
