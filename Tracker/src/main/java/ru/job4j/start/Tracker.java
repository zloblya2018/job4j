package ru.job4j.start;

import ru.job4j.models.*;
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
    public void replace(Item item) {
        Item replaceItem = this.findById(item.getId());
        replaceItem.setId(item.getId());
        replaceItem.setName(item.getName());
        replaceItem.setCreate(item.getCreate());
        replaceItem.setDescription(item.getDescription());
        replaceItem.setComments(item.getComments());
    }
    /**
     * Удаление заявок.
     */
    public void delete(Item id) {
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
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result[this.position] = item;
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
        for(int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }
}
