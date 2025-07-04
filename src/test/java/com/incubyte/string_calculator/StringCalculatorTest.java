package com.incubyte.string_calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @Test
    void shouldReturnZeroForEmptyString() {
        assertEquals(0, new StringCalculator().add(""));
    }

    @Test
    void shouldReturnSingleNumber() {
        assertEquals(5, new StringCalculator().add("5"));
    }

    @Test
    void shouldReturnSumOfTwoNumbersSeparatedByComma() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    void shouldReturnSumOfMultipleNumbersSeparatedByComma() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(10, calculator.add("1,2,3,4"));
    }


    @Test
    void shouldSupportNewLineAsDelimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(11, calculator.add("1\n7,3"));
    }

    @Test
    void shouldThrowExceptionWhenNegativeNumbersArePresent() {
        StringCalculator calculator = new StringCalculator();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3,-4");
        });

        assertEquals("negative numbers not allowed: -2, -4", exception.getMessage());
    }


}
