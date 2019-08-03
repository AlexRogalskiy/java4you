package com.sensiblemetrics.api.alpenidos.core.double_checked_locking.model;

import com.sensiblemetrics.api.alpenidos.core.double_checked_locking.model.Item;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Inventory
 */
@Slf4j
public class Inventory {
    private final int inventorySize;
    private final List<Item> items;
    private final Lock lock;

    /**
     * Constructor
     */
    public Inventory(int inventorySize) {
        this.inventorySize = inventorySize;
        this.items = new ArrayList<>(inventorySize);
        this.lock = new ReentrantLock();
    }

    /**
     * Add item
     */
    public boolean addItem(final Item item) {
        if (this.items.size() < this.inventorySize) {
            this.lock.lock();
            try {
                if (this.items.size() < this.inventorySize) {
                    this.items.add(item);
                    log.info("{}: items.size()={}, inventorySize={}", Thread.currentThread(), items.size(), this.inventorySize);
                    return true;
                }
            } finally {
                this.lock.unlock();
            }
        }
        return false;
    }

    /**
     * Get all the items in the inventory
     *
     * @return All the items of the inventory, as an unmodifiable list
     */
    public final List<Item> getItems() {
        return Collections.unmodifiableList(this.items);
    }
}
