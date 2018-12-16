package ru.job4j.tracker.start;

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

}
