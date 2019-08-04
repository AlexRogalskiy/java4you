package com.sensiblemetrics.api.alpenidos.core.iterator2;

import com.sensiblemetrics.api.alpenidos.core.iterator2.iface.Iterator;
import com.sensiblemetrics.api.alpenidos.core.iterator2.list.Item;
import com.sensiblemetrics.api.alpenidos.core.iterator2.list.ItemType;
import com.sensiblemetrics.api.alpenidos.core.iterator2.list.TreasureChest;
import com.sensiblemetrics.api.alpenidos.core.iterator2.tree.BstIterator;
import com.sensiblemetrics.api.alpenidos.core.iterator2.tree.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * The Iterator pattern is a design pattern in which an iterator is used to traverse a container and
 * access the container's elements. The Iterator pattern decouples algorithms from containers.
 * <p>
 * In this example the Iterator ({@link Iterator}) adds abstraction layer on top of a collection
 * ({@link TreasureChest}). This way the collection can change its internal implementation without
 * affecting its clients.
 */
@Slf4j
public class IteratorPatternLoader {

    private static final TreasureChest TREASURE_CHEST = new TreasureChest();

    private static void demonstrateTreasureChestIteratorForType(final ItemType itemType) {
        log.info("------------------------");
        log.info("Item Iterator for ItemType " + itemType + ": ");
        final Iterator<Item> itemIterator = TREASURE_CHEST.iterator(itemType);
        while (itemIterator.hasNext()) {
            log.info(itemIterator.next().toString());
        }
    }

    private static void demonstrateBstIterator() {
        log.info("------------------------");
        log.info("BST Iterator: ");
        final TreeNode<Integer> root = buildIntegerBst();
        final BstIterator bstIterator = new BstIterator<>(root);
        while (bstIterator.hasNext()) {
            log.info("Next node: " + bstIterator.next().getVal());
        }
    }

    private static TreeNode<Integer> buildIntegerBst() {
        final TreeNode<Integer> root = new TreeNode<>(8);
        root.insert(3);
        root.insert(10);
        root.insert(1);
        root.insert(6);
        root.insert(14);
        root.insert(4);
        root.insert(7);
        root.insert(13);
        return root;
    }

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        // list iterator
        for (final ItemType type : ItemType.values()) {
            demonstrateTreasureChestIteratorForType(type);
        }

        // tree iterator
        demonstrateBstIterator();
    }
}
