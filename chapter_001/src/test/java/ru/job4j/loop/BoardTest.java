package ru.job4j.loop;
 /*
 * Test
 */
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void when3X3() {
        Board board = new Board();
        String result = board.paint(3, 3);
        String ln = System.lineSeparator();
        assertThat(result, is(
                String.format("X X%s X %sX X%s", ln, ln, ln)));
    }
    @Test
    public void when5X4() {
        Board board = new Board();
        String result = board.paint(5, 4);
        String ln = System.lineSeparator();
        assertThat(result, is(
                String.format("X X X%s X X %sX X X%s X X %s", ln, ln, ln, ln)));
    }
}