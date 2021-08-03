package com.sensiblemetrics.api.alpenidos.pattern.iterator2.list;

import lombok.Data;

/**
 * Item
 */
@Data
public class Item {
    private ItemType type;
    private String name;

    public Item(final ItemType type, final String name) {
        this.setType(type);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
