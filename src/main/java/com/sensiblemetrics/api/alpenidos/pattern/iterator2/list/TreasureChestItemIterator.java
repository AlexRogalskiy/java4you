package com.sensiblemetrics.api.alpenidos.pattern.iterator2.list;

import com.sensiblemetrics.api.alpenidos.pattern.iterator2.iface.Iterator;

import java.util.List;

/**
 * TreasureChestItemIterator
 */
public class TreasureChestItemIterator implements Iterator<Item> {
    private TreasureChest chest;
    private int idx;
    private ItemType type;

    /**
     * Constructor
     */
    public TreasureChestItemIterator(final TreasureChest chest, final ItemType type) {
        this.chest = chest;
        this.type = type;
        this.idx = -1;
    }

    @Override
    public boolean hasNext() {
        return this.findNextIdx() != -1;
    }

    @Override
    public Item next() {
        this.idx = this.findNextIdx();
        if (idx != -1) {
            return this.chest.getItems().get(idx);
        }
        return null;
    }

    private int findNextIdx() {
        final List<Item> items = this.chest.getItems();
        boolean found = false;
        int tempIdx = idx;
        while (!found) {
            tempIdx++;
            if (tempIdx >= items.size()) {
                tempIdx = -1;
                break;
            }
            if (this.type.equals(ItemType.ANY) || items.get(tempIdx).getType().equals(this.type)) {
                break;
            }
        }
        return tempIdx;
    }
}
