package com.incubyte.string_calculator;

public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) return 0;

        String[] numbers = input.split(",|\n"); // split on comma OR newline
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }



}
