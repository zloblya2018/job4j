package ru.job4j.tracker.start;

import ru.job4j.tracker.models.*;
import ru.job4j.tracker.start.Tracker.*;
import java.util.*;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();
    /**
     * Добавление заявок.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }
    /**
     * Редактирование заявок.
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                item.setId(id);
                break;
            }
        }
    }
    /**
     * Удаление заявок.
     */
    public void delete(String id) {
        int position = 0;
        for (Item itemIndex : items) {
            for (int index = 0; index != this.position; index++) {
                if (itemIndex != null && itemIndex.getId().equals(id)) {
                    position = index;
                    break;
                }
            }
            this.items[position] = null;
        }
    }

    /**
     * Получение заявки.
     */
    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index != position; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                result = items[index];
                break;
            }
        }
        return result;
    }
    /**
     * Получение списка по имени.
     */
    public Item[] findByName(String name) {
       Item[] result = new Item[this.position];
       int counter = 0;
        for (int index = 0; index != position; index++) {
            if (items[index] != null && items[index].getName().equals(name)) {
                result[counter] = items[index];
                counter++;
            }
        }
        return Arrays.copyOf(result, counter);
    }

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
    /**
     * Получение списка всех заявок.
     */
    public Item[] getAll() {
        return Arrays.copyOf(items, this.position);
    }


    public enum SingletonVariableOne {
        INSTANCE;

        public Tracker add(Tracker model) {
            return model;
        }
    }


    public static class SingletonVariableTwo {

        private static SingletonVariableTwo instance;

        public SingletonVariableTwo() {
        }

        public static SingletonVariableTwo getInstance() {
            if (instance == null) {
                instance = new SingletonVariableTwo();
            }
            return instance;
        }

        public Tracker add(Tracker model) {
            return model;
        }
    }

    public static class SingletonVariableThree {
        private static SingletonVariableThree instance = new SingletonVariableThree();

        public SingletonVariableThree() {
        }

        public static SingletonVariableThree getInstance() {
            return instance;
        }

        public Tracker add(Tracker model) {
            return model;
        }
    }

    public static class SingletonVariableFour {
        private SingletonVariableFour() {
        }

        public static SingletonVariableFour getInstance() {
            return Holder.INSTANCE;
        }

        public Tracker add(Tracker model) {
            return model;
        }

        private static final class Holder {
            public static final SingletonVariableFour INSTANCE = new SingletonVariableFour();
        }


    }
}