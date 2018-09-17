package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    
    @Test
    public void fromOneSubtractOneGetZero() {
        Calculator calc = new Calculator();
        calc.subtraction(1D, 1D);
        double result = calc.getResult();
        double expected = 0D;
        assertThat(result, is(expected));
    }
    
    @Test
    public void takeTwoMultiplyByTwoEqualsFour() {
        Calculator calc = new Calculator();
        calc.multiplication(2D, 2D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }
    
    @Test
    public void whenTwoDivideByTwoEqualsOne() {
        Calculator calc = new Calculator();
        calc.division(2D, 2D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }
}