package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Class   Tracker
 * Created 09/04/2020 - 9:15
 * Project job4j_tracker
 * Author  Sergey Bulygin
 */
public class Tracker {

    /**
     * Array for items.
     */
    private Item[] items = new Item[100];

    /**
     * Position new item in array.
     */
    private int position = 0;

    /**
     * Random value for generate id.
     */
    private static final Random RN = new Random();

    /**
     * Generate id.
     * @return id.
     */
    private String generateId() {
        return String.valueOf(RN.nextInt(10000));
    }

    /**
     * Method add item/
     * @param item item.
     * @return new item.
     */
    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    /**
     * Method find item by id.
     * @param id id
     * @return item.
     */
    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    /**
     * Method find all items.
     * @return array items.
     */
    public Item[] findAll(){
        return Arrays.copyOf(items, position);
    }

    /**
     * Method for retrieving a list by name.
     * @param key key.
     * @return  list.
     */
    public Item[] findByName(String key){
        int step = 0;
        Item[] result = new Item[position];
        for (int index = 0; index <= position; index++) {
            if (this.items[index].getName().equals(key)) {
                result[step++] = this.items[index];
                break;
            }
        }
        return Arrays.copyOf(result, step);
    }

    /**
     * The method of replacing the application with the same id.
     * @param id id.
     * @param item item.
     */
    public void replace(String id, Item item) {
        int index = indexOf(id);
        if (index > -1) {
            items[index] = item;
            item.setId(id);
        }
    }

    /**
     * Method return index by id.
     * @param id id.
     * @return index.
     */
    private int indexOf(String id) {
        int result = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }
}
