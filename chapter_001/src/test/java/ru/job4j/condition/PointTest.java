package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void distanceFromTwoPoints() {
        Point firstPoint = new Point(1, 2);
        Point secondPoint = new Point(1, 5); 
        double result = firstPoint.distanceTo(secondPoint);
        double expected = 3.0;
        assertThat(result, is(expected));
    }
}