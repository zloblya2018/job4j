package ru.job4j.start;

import ru.job4j.models.*;

import java.util.*;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();
    /**
     * Добавление заявок.
     */
    public Item add(Item item) {
        item.setId(String.valueOf(RN.nextInt()));
        this.items[position++] = item;
        return item;
    }
    /**
     * Редактирование заявок.
     */
    public void replace(String id, Item item) {
        for (Item index : items) {
            for (int i = 0; i < items.length; i++) {
                if (id.equals(index.getId())) {
                    items[i] = item;
                    break;
                }
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
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
    /**
     * Получение списка по имени.
     */
    public Item findByName(String key) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result = item;
                break;
            }
        }
        return result;
    }

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
    /**
     * Получение списка всех заявок.
     */
    public Item[] getAll() {
        Item[] result = new Item[this.position];
        Arrays.copyOf(items, result.length);
        for(int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }
}
/*
        Item item = new Item("name", "desc", 0);
        System.out.println(item.getName() + " " + item.getDescription());

        Item task = new Task("nameTask", "descTask");
        System.out.println(task.getName() + " " + task.getDescription());

          Tracker tracker = new Tracker();
        tracker.items[0] = new Item("name", "desc", 0);
        tracker.items[1] = new Task("nameTask", "descTask");
        tracker.items[2] = new Bug();

        for (Item item : tracker.items) {
            if (item instanceof Task) {
                System.out.println(((Task) item).calculatePrice());
            }
            System.out.println(item.getName() + " " + item.getDescription());
        }

        */
