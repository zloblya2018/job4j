package ru.job4j.pseudo;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.lang.*;

public class PaintTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("Метод выполняется до запуска теста");
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("Метод выполняется после запуска теста");
    }
    @Test
    public void whenDrawSquare() {
        //PrintStream stdout = System.out;
        //ByteArrayOutputStream out = new ByteArrayOutputStream();
        //System.setOut(new PrintStream(out));
        //this.loadOutput();
        new Paint().draw(new Square());
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(" ++++ ")
                                .append("+    +")
                                .append("+    +")
                                .append(" ++++ ")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
        //System.setOut(stdout);
        //this.backOutput();
    }
    @Test
    public void whenDrawTriangle() {
        //PrintStream stdout = System.out;
        //ByteArrayOutputStream out = new ByteArrayOutputStream();
        //System.setOut(new PrintStream(out));
        //this.loadOutput();
        new Paint().draw(new Triangle());
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                        .append("   ^   ")
                        .append("  ^^^  ")
                        .append(" ^^^^^ ")
                        .append("^^^^^^^")
                        .append(System.lineSeparator())
                        .toString()
                )
        );
        //System.setOut(stdout);
        //this.backOutput();
    }
}