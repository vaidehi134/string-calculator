package com.incubyte.string_calculator;

import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) return 0;

        String delimiter = ",|\n"; // default delimiters

        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            delimiter = Pattern.quote(parts[0].substring(2)); // escape special chars
            input = parts[1];
        }

        String[] numbers = input.split(delimiter);
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }




}
