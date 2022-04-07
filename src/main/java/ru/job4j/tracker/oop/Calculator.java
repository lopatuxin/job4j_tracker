package ru.job4j.tracker.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int i) {
        return i - x;
    }

    public int divide(int d) {
        return d / x;
    }

    public int sumAllOperation(int s) {
        return sum(s) + multiply(s) + minus(s) + divide(s);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(Calculator.sum(10));
        System.out.println(calculator.multiply(3));
        System.out.println(Calculator.minus(10));
        System.out.println(calculator.divide(25));
        System.out.println(calculator.sumAllOperation(5));
    }
}
