package com.incubyte.string_calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


}
