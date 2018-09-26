package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactorialTest {

    @Test
    public void factorialOfNumber5() {
        Factorial factorial = new Factorial();
        int result = factorial.factorialOfNumber(5);
        assertThat(result, is(120));
    }

    @Test
    public void factorialOfNumber0() {
        Factorial factorial = new Factorial();
        int result = factorial.factorialOfNumber(0);
        assertThat(result, is(1));
    }
}