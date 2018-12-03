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
    public Item[] delete(String id) {
        Item[] result = new Item[position];
        for (int index = 0; index != position; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                result[0] = items[index];
                break;
            } else {
                System.arraycopy(items, index, result, index, items.length - 1);
            }
        }
        return result;
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
       Item[] result = new Item[position];
       for (int index = 0; index != position; index++) {
           if (items[index] != null && items[index].getName().equals(name)) {
               result[index] = items[index];
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
        return Arrays.copyOf(items, this.position);
    }

    /**
     * Вывод на консоль отдельной заявки.
     */
    public void outputToTaskInConsole(Item item) {
        System.out.println("Уникальный номер: " + item.getId() + " Имя заявки: "
                + item.getName() + " Описание заявки: " + item.getDescription());
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
