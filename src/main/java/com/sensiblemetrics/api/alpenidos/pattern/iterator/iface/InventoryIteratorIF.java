package com.sensiblemetrics.api.alpenidos.pattern.iterator.iface;

import com.sensiblemetrics.api.alpenidos.pattern.iterator.impl.InventoryItem;

public interface InventoryIteratorIF {

    boolean hasNextInventoryItem();

    InventoryItem getNextInventoryItem();

    boolean hasPreviousInventoryItem();

    InventoryItem getPreviousInventoryItem();
}
