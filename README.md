# String Calculator – TDD Kata

This repository contains my solution to the **Incubyte TDD Assessment** based on the classic String Calculator Kata.

## Features Implemented

-  Return `0` for empty string
-  Return the number itself for single input
-  Sum two comma-separated numbers
-  Support multiple comma-separated numbers
-  Support newline `\n` as a valid delimiter
-  Support custom delimiter `//[delimiter]\n...` format
-  Throw exception for negative numbers with message:  
  `"negative numbers not allowed: -2, -5"`
-  Ignore numbers greater than 1000


##  Testing Approach

I strictly followed the **Test-Driven Development (TDD) cycle:

>  Red →  Green →  Refactor

Each test case was added **before** writing the actual logic, and committed individually to reflect the evolution of the codebase clearly.


##  Note

>  In the first commit, I began with the test and partial logic. The complete logic followed in the next step, in line with the TDD cycle (Red → Green → Refactor).


##  How to Run the Tests

Make sure you have Maven and JDK 21 installed.

From the root of the project:

```bash
mvn test
