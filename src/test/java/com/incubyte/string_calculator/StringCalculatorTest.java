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

    @Test
    void shouldIgnoreNumbersGreaterThan1000() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(5, calculator.add("2,1001,3"));
    }

    @Test
    void shouldSupportDelimitersOfAnyLength() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[***]\n1***2***3"));
    }

    @Test
    void shouldSupportMultipleDelimiters() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    void shouldSupportMultipleDelimitersOfAnyLength() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[***][%%]\n1***2%%3"));
    }



}
