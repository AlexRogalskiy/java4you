package com.sensiblemetrics.api.alpenidos.core.iterator.iface;

import com.sensiblemetrics.api.alpenidos.core.iterator.impl.InventoryItem;

public interface InventoryIteratorIF {

    boolean hasNextInventoryItem();

    InventoryItem getNextInventoryItem();

    boolean hasPreviousInventoryItem();

    InventoryItem getPreviousInventoryItem();
}
