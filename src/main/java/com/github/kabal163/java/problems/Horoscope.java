package com.github.kabal163.java.problems;

import java.util.Random;

import static com.github.kabal163.java.problems.Horoscope.AstrologicalSign.AQUARIUS;
import static com.github.kabal163.java.problems.Horoscope.AstrologicalSign.ARIES;
import static com.github.kabal163.java.problems.Horoscope.AstrologicalSign.CANCER;
import static com.github.kabal163.java.problems.Horoscope.AstrologicalSign.CAPRICORN;
import static com.github.kabal163.java.problems.Horoscope.AstrologicalSign.GEMINI;
import static com.github.kabal163.java.problems.Horoscope.AstrologicalSign.LEO;
import static com.github.kabal163.java.problems.Horoscope.AstrologicalSign.LIBRA;
import static com.github.kabal163.java.problems.Horoscope.AstrologicalSign.PISCES;
import static com.github.kabal163.java.problems.Horoscope.AstrologicalSign.SAGITTARIUS;
import static com.github.kabal163.java.problems.Horoscope.AstrologicalSign.SCORPIO;
import static com.github.kabal163.java.problems.Horoscope.AstrologicalSign.TAURUS;
import static com.github.kabal163.java.problems.Horoscope.AstrologicalSign.VIRGO;

/*
Мне пришли гениальная идея! Давайте сделаем астрологический прогноз, и будем продавать его за
деньги! Это же гениально! Ваша программа должна содержать гороскопы для каждого знака зодиака
(хардкодим). Для каждого знака зодиака нужно иметь по 2 гороскопа. На вход программа принимает
через аргументы командной строки название знака зодиака и подбирает для него подходящий гороскоп.
 Программа должна выбрать рандомный (с вероятностью 50%) гороскоп из двух подходящих и вывести
 его в консоль.
 */
public class Horoscope {

    static final String POSITIVE_TEXT = "У %s все хорошо";
    static final String NEGATIVE_TEXT = "Для %s сегодня все плохо";

    enum AstrologicalSign {
        ARIES(0), TAURUS(1), GEMINI(2),
        CANCER(3), LEO(4), VIRGO(5),
        LIBRA(6), SCORPIO(7), SAGITTARIUS(8),
        CAPRICORN(9), AQUARIUS(10), PISCES(11);

        AstrologicalSign(int code) {
            this.code = code;
        }

        final int code;
    }

    /**
     * Двумерный массив, содержащий астрологические прогнозы. Двумерный массив - это просто
     * массив из массивов. Основной массив состоит из множества других массивов. В нашем случае,
     * это множество других массивов - это не что иное, как прогнозы для конкретного знака
     * зодиака - по два для каждого (положительный и негативный). Важно, чтобы индекс подмассива
     * соответствовал {@link AstrologicalSign#code коду} нашего знака зодиака
     */
    static final String[][] PREDICTIONS = new String[][]{
        {POSITIVE_TEXT.formatted("овнов"), NEGATIVE_TEXT.formatted("овнов")},
        {POSITIVE_TEXT.formatted("тельцов"), NEGATIVE_TEXT.formatted("тельцов")},
        {POSITIVE_TEXT.formatted("близнецов"), NEGATIVE_TEXT.formatted("близнецов")},
        {POSITIVE_TEXT.formatted("раков"), NEGATIVE_TEXT.formatted("раков")},
        {POSITIVE_TEXT.formatted("львов"), NEGATIVE_TEXT.formatted("львов")},
        {POSITIVE_TEXT.formatted("дев"), NEGATIVE_TEXT.formatted("дев")},
        {POSITIVE_TEXT.formatted("весов"), NEGATIVE_TEXT.formatted("весов")},
        {POSITIVE_TEXT.formatted("скорпионов"), NEGATIVE_TEXT.formatted("скорпионов")},
        {POSITIVE_TEXT.formatted("стрельцов"), NEGATIVE_TEXT.formatted("стрельцов")},
        {POSITIVE_TEXT.formatted("козерогов"), NEGATIVE_TEXT.formatted("козерогов")},
        {POSITIVE_TEXT.formatted("водолей"), NEGATIVE_TEXT.formatted("водолей")},
        {POSITIVE_TEXT.formatted("рыб"), NEGATIVE_TEXT.formatted("рыб")}
    };

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("В качестве аргумента должен быть передан ровно " +
                "один знак зодиака");
        }

        // Распознаем (парсим) входящее значение и на его основе создаем объект типа
        // AstrologicalSign
        // Значение должно соответствовать названию AstrologicalSign, например, LEO, VIRGO и т.д.
        AstrologicalSign sign = AstrologicalSign.valueOf(args[0]);
        arrayApproach(sign);
        switchCaseApproach(sign);
    }

    /**
     * Пример того, как можно определить с вероятностью 50% нужный нам прогноз для определенного
     * знака зодиака. Каждый знак зодиака имеет код, который мы для него определили. Этот код мы
     * используем в качестве индекса, по которому из массива прогнозов мы получаем
     * соответствующий нашему знаку зодиака.
     *
     * @param sign знак зодиака, для которого необходимо показать гороскоп
     */
    public static void arrayApproach(AstrologicalSign sign) {
        // Получаем псевдослучайное значение от 0 до 1
        // 2 используется как верхняя граница диапазона (не включительно)
        int random = new Random().nextInt(2);

        // Из двумерного массива получаем необходимый прогноз
        // В качестве первого индекса используем код знака зодиака - получаем массив прогнозов
        // для этого знака
        // В качестве второго индекса используем псевдослучайное значение, которое вернет нам
        // конкретный прогноз
        String prediction = PREDICTIONS[sign.code][random];

        System.out.println(prediction);
    }

    /**
     * Пример с использованием конструкции switch-case. В данном случае, она притянута зауши и не
     * имеет смысла, так как у нашего {@code sign} и так есть код, по которому мы можем достать
     * нужный нам подмассив с прогнозами. Данный пример - это больше демонстрация работы
     * switch-case.
     *
     * @param sign знак зодиака, для которого необходимо показать гороскоп
     */
    public static void switchCaseApproach(AstrologicalSign sign) {
        // Получаем псевдослучайное значение от 0 до 1
        int random = new Random().nextInt(2);

        String prediction = switch (sign) {
            case ARIES -> PREDICTIONS[ARIES.code][random];
            case TAURUS -> PREDICTIONS[TAURUS.code][random];
            case GEMINI -> PREDICTIONS[GEMINI.code][random];
            case CANCER -> PREDICTIONS[CANCER.code][random];
            case LEO -> PREDICTIONS[LEO.code][random];
            case VIRGO -> PREDICTIONS[VIRGO.code][random];
            case LIBRA -> PREDICTIONS[LIBRA.code][random];
            case SCORPIO -> PREDICTIONS[SCORPIO.code][random];
            case SAGITTARIUS -> PREDICTIONS[SAGITTARIUS.code][random];
            case CAPRICORN -> PREDICTIONS[CAPRICORN.code][random];
            case AQUARIUS -> PREDICTIONS[AQUARIUS.code][random];
            case PISCES -> PREDICTIONS[PISCES.code][random];
        };

        System.out.println(prediction);
    }
}
