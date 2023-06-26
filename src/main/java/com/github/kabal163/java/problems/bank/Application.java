package com.github.kabal163.java.problems.bank;

import com.github.kabal163.java.problems.bank.solution.Bank;
import com.github.kabal163.java.problems.bank.solution.Banknote;
import com.github.kabal163.java.problems.bank.solution.Banknote.Denomination;
import com.github.kabal163.java.problems.bank.solution.Key;
import com.github.kabal163.java.problems.bank.solution.Mark;

import java.util.List;
import java.util.UUID;

public class Application {

    public static void main(String[] args) {
        List<Mark> marks = List.of(
            new Mark("Марка из Москвы"),
            new Mark("Марка из Тольятти")
        );

        List<Banknote> banknotes = List.of(
            new Banknote(Denomination.ONE),
            new Banknote(Denomination.TEN),
            new Banknote(Denomination.ONE_THOUSAND)
        );

        Bank bank = new Bank();
        Key key = bank.newCell(UUID.randomUUID().toString());

        bank.putMarks(key, marks);
        bank.putBanknotes(key, banknotes);

        System.out.println(bank.cell(key).balance());
    }
}
