package com.incubyte.string_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) return 0;

        String delimiter = ",|\n";

        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            delimiter = Pattern.quote(parts[0].substring(2));
            input = parts[1];
        }

        String[] numbers = input.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String number : numbers) {
            if (number.isEmpty()) continue;

            int num = Integer.parseInt(number);

            if (num < 0) {
                negatives.add(num);
            } else if (num <= 1000) {  //skip numbers > 1000
                sum += num;
            }

        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negative numbers not allowed: " +
                    negatives.toString().replaceAll("[\\[\\]]", ""));
        }

        return sum;
    }



}
