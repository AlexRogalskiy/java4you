package com.sensiblemetrics.api.alpenidos.core.iterator2.list;

import com.sensiblemetrics.api.alpenidos.core.iterator2.iface.Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * TreasureChest, the collection class.
 */
public class TreasureChest {
    private List<Item> items;

    /**
     * Constructor
     */
    public TreasureChest() {
        this.items = new ArrayList<>();
        this.items.add(new Item(ItemType.POTION, "Potion of courage"));
        this.items.add(new Item(ItemType.RING, "Ring of shadows"));
        this.items.add(new Item(ItemType.POTION, "Potion of wisdom"));
        this.items.add(new Item(ItemType.POTION, "Potion of blood"));
        this.items.add(new Item(ItemType.WEAPON, "Sword of silver +1"));
        this.items.add(new Item(ItemType.POTION, "Potion of rust"));
        this.items.add(new Item(ItemType.POTION, "Potion of healing"));
        this.items.add(new Item(ItemType.RING, "Ring of armor"));
        this.items.add(new Item(ItemType.WEAPON, "Steel halberd"));
        this.items.add(new Item(ItemType.WEAPON, "Dagger of poison"));
    }

    public Iterator<Item> iterator(final ItemType itemType) {
        return new TreasureChestItemIterator(this, itemType);
    }

    /**
     * Get all items
     */
    public List<Item> getItems() {
        return new ArrayList<>(this.items);
    }
}
