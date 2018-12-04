package ru.job4j.tracker.start;

public class StartUITest {
    public static void main(String[] args) {
        //new StartUI(new StubInput(new String[] {"cteate stub task"})).init();
        Input input = new StubInput(new String[] {"cteate stub task"});
        new StartUI(input).init();
    }
}
