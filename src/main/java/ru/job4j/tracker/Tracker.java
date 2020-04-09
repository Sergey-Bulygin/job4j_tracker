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
        Item result = null;
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Method find all items.
     * @return array items.
     */
    public Item[] findAll(){
        return Arrays.copyOf(items, position);
    }

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
}
