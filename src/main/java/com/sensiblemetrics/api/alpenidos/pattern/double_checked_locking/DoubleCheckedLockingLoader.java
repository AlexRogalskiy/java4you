package com.sensiblemetrics.api.alpenidos.pattern.double_checked_locking;

import com.sensiblemetrics.api.alpenidos.pattern.double_checked_locking.model.Inventory;
import com.sensiblemetrics.api.alpenidos.pattern.double_checked_locking.model.Item;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Double Checked Locking is a concurrency design pattern used to reduce the overhead of acquiring a
 * lock by first testing the locking criterion (the "lock hint") without actually acquiring the
 * lock. Only if the locking criterion check indicates that locking is required does the actual
 * locking logic proceed.
 * <p>
 * In {@link Inventory} we store the items with a given size. However, we do not store more items
 * than the inventory size. To address concurrent access problems we use double checked locking to
 * add item to inventory. In this method, the thread which gets the lock first adds the item.
 */
@Slf4j
public class DoubleCheckedLockingLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        final Inventory inventory = new Inventory(1000);
        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
                while (inventory.addItem(new Item())) {
                }
                ;
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Error waiting for ExecutorService shutdown");
        }
    }
}
