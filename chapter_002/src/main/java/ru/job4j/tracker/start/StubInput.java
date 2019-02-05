package ru.job4j.tracker.start;

import java.util.List;

public class StubInput implements Input {
    private final String[] answers;
    private int position;

    public StubInput(final String[] answers) {
        this.answers = answers;
    }

    @Override
    public String ask(String question) {
        return answers[position++];
    }

    @Override
    public int ask(String question, List<Integer> value) {
        //throw new UnsupportedOperationException("Операция не поддерживается!");
        return -1;
    }
}
