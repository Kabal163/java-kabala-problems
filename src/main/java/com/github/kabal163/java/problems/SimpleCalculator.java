package com.github.kabal163.java.problems;

/*
Теперь, когда вы знаете о Java почти все, вы можете создать свою первую программу. Давайте
сделаем простенький калькулятор. Что я хочу видеть:
- В методе main две переменных типа double, которым можно задавать разные значения.
- В этом же классе несколько других методов, каждый из которых будет соответствовать операциям
сложения, вычитания, умножения, деления, получение остатка от деления, возведение в степень.
- Каждый из этих методов должен принимать на вход два аргумента и возвращать результат операции.
- Результат операции должен выводиться в консоль.
 */
public class SimpleCalculator {

    public static void main(String[] args) {
        String message = "a = %s, b = %s, %s = %s\n";
        double a = 10;
        double b = 3;

        System.out.printf(message, a, b, "sum", sum(a, b));
        System.out.printf(message, a, b, "subtract", subtract(a, b));
        System.out.printf(message, a, b, "multiply", multiply(a, b));
        System.out.printf(message, a, b, "divide", divide(a, b));
        System.out.printf(message, a, b, "reminder", reminder(a, b));
        System.out.printf(message, a, b, "power", power(a, b));
    }

    public static double sum(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static double reminder(double a, double b) {
        return a % b;
    }

    public static double power(double a, double b) {
        return Math.pow(a, b);
    }
}
