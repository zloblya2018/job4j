package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    
    @Test
    public void whenSecondLessFirst() {
        Max maximum = new Max();
        int result = maximum.max(2, 1);
        assertThat(result, is(2));
    }
    
    @Test
    public void whenFirstLessSecond() {
        Max maximum = new Max();
        int result = maximum.max(3, 6);
        assertThat(result, is(6));
    }
}