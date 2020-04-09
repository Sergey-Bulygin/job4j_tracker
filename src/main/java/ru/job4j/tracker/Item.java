package ru.job4j.tracker;

import java.util.Objects;

/**
 * Class   Item
 * Created 09/04/2020 - 9:14
 * Project job4j_tracker
 * Author  Sergey Bulygin
 */
public class Item {
    private String id;
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id.equals(item.id)
                && name.equals(item.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
