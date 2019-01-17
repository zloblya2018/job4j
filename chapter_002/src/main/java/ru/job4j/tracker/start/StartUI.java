package ru.job4j.tracker.start;

import java.util.ArrayList;
import java.util.List;

public class StartUI {

    private final Input input;
    private int[] ranges = new int[] {0,1,2,3,4,5};
    /**
     * Хранилище заявок.
     */
    private Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menuTracker = new MenuTracker(this.input, tracker);
        List<Integer> range = new ArrayList<>();
        menuTracker.fillAction();
        for (int i = 0; i < menuTracker.getActionMenuLength(); i++) {
            range.add(i);
        }
        do {
            menuTracker.showMenu();
            menuTracker.select(input.ask("Выберите пункт меню: ", ranges));
        } while (!"y".equals(this.input.ask( "Выйти из меню? (y) ")));
    }
    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}