package com.sensiblemetrics.api.alpenidos.core.iterator.impl;

import com.sensiblemetrics.api.alpenidos.core.iterator.iface.InventoryIteratorIF;

public class InventoryCollection {

    public InventoryIteratorIF iterator() {
        return new InventoryIterator();
    }

    private class InventoryIterator implements InventoryIteratorIF {

        @Override
        public boolean hasNextInventoryItem() {
            return false;
        }

        @Override
        public InventoryItem getNextInventoryItem() {
            return null;
        }

        @Override
        public boolean hasPreviousInventoryItem() {
            return false;
        }

        @Override
        public InventoryItem getPreviousInventoryItem() {
            return null;
        }
    }
}
