package ru.job4j.tracker.start;

import java.util.List;

public class ValidateInput extends ConsoleInput {
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutExeption moe) {
                System.out.println("Пожалуйста введите цифру из заданного диапазона!");
            }
            catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста введите корректные данные!");
            }
        } while (invalid);
        return value;
    }
}
