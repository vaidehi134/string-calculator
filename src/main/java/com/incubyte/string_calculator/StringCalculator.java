package com.incubyte.string_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) return 0;

        String delimiter = ",|\n"; // default delimiters

        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            String delimiterPart = parts[0].substring(2);
            input = parts[1];

            List<String> delimiters = new ArrayList<>();

            Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimiterPart);
            while (matcher.find()) {
                delimiters.add(Pattern.quote(matcher.group(1)));
            }

            if (!delimiters.isEmpty()) {
                delimiter = String.join("|", delimiters);
            } else {
                delimiter = Pattern.quote(delimiterPart); // single char delimiter
            }
        }

        String[] numbers = input.split(delimiter);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (String number : numbers) {
            if (number.isEmpty()) continue;
            int num = Integer.parseInt(number);
            if (num < 0) negatives.add(num);
            else if (num <= 1000) sum += num;
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negative numbers not allowed: " +
                    negatives.toString().replaceAll("[\\[\\]]", ""));
        }

        return sum;
    }




}
