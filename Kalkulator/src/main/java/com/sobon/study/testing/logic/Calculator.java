package com.sobon.study.testing.logic;

public class Calculator {
    public static double add(String number1, String number2) {
        return Double.parseDouble(number1) + Double.parseDouble(number2);
    }

    public static double divide(String number1, String number2) {
        if ("0".equals(number2)) {
            throw new RuntimeException();

        }
        return Double.parseDouble(number1) / Double.parseDouble(number2);
    }

    public static double subtract(String number1, String number2) {
        return Double.parseDouble(number1) - Double.parseDouble(number2);
    }

    public static double multiply(String number1, String number2) {
        return Double.parseDouble(number1) * Double.parseDouble(number2);
    }
}
