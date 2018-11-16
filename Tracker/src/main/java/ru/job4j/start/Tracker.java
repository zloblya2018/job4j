package ru.job4j.start;

import ru.job4j.models.*;

import java.util.Arrays;
import java.util.Random;

/**
 * В этом классе хранятся все заявки.
 * Возможно добавлять, редактировать и удалять заявки, также
 * возможен вывод списка всех заявок и вывод списка по фильтру.
 */

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
        int position = 0;
        for (Item counter : items) {
           for (int index = 0; index != this.position; index++) {
               if (counter != null && counter.getId().equals(id)) {
                   position = index;
                   break;
               }
               this.items[position] = item;
           }
        }
    }
    /**
     * Удаление заявок.
     */
    public void delete(String id) {
       for (int index = 0; index != this.position; index++) {
           if (items[index] != null && items[index].getId().equals(id)) {
               System.arraycopy(this.items, index + 1, this.items, index,
                       this.items.length - 1 - index);
               this.position--;
               break;
           }
           this.items[index] = null;
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
        Arrays.copyOf(this.items, result.length);
        for(int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }
}
