package com.taylor.Stack.test;


import com.taylor.Stack.application.Calculator;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator=new Calculator("30+(2+500*39)-2");
        System.out.println(calculator.getResult());
    }
}
