package ru.job4j.tracker.start;

import org.junit.*;
import java.io.*;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"invalid", "1"}));
        List<Integer> range = new ArrayList<>();
        range.add(1);
        input.ask("Enter", range);
        assertThat(this.mem.toString(), is(String.format("Пожалуйста введите корректные данные.%n"))
        );
    }
    @Test
    public void whenOutOfMenuRangeInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"-1", "1"}));
        List<Integer> range = new ArrayList<>();
        range.add(1);
        input.ask("Enter", range);
        assertThat(this.mem.toString(), is(String.format("Пожалуйста введите цифру из заданного диапазона.%n")));
    }
}