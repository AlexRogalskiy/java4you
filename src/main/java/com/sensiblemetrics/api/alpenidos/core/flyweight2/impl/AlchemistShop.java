package com.sensiblemetrics.api.alpenidos.core.flyweight2.impl;

import com.sensiblemetrics.api.alpenidos.core.flyweight2.enums.PotionType;
import com.sensiblemetrics.api.alpenidos.core.flyweight2.factory.PotionFactory;
import com.sensiblemetrics.api.alpenidos.core.flyweight2.iface.Potion;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * AlchemistShop holds potions on its shelves. It uses PotionFactory to provide the potions.
 */
@Slf4j
public class AlchemistShop {
    private final List<Potion> topShelf;
    private final List<Potion> bottomShelf;

    /**
     * Constructor
     */
    public AlchemistShop() {
        this.topShelf = new ArrayList<>();
        this.bottomShelf = new ArrayList<>();
        this.fillShelves();
    }

    private void fillShelves() {
        final PotionFactory factory = new PotionFactory();
        this.topShelf.add(factory.createPotion(PotionType.INVISIBILITY));
        this.topShelf.add(factory.createPotion(PotionType.INVISIBILITY));
        this.topShelf.add(factory.createPotion(PotionType.STRENGTH));
        this.topShelf.add(factory.createPotion(PotionType.HEALING));
        this.topShelf.add(factory.createPotion(PotionType.INVISIBILITY));
        this.topShelf.add(factory.createPotion(PotionType.STRENGTH));
        this.topShelf.add(factory.createPotion(PotionType.HEALING));
        this.topShelf.add(factory.createPotion(PotionType.HEALING));

        this.bottomShelf.add(factory.createPotion(PotionType.POISON));
        this.bottomShelf.add(factory.createPotion(PotionType.POISON));
        this.bottomShelf.add(factory.createPotion(PotionType.POISON));
        this.bottomShelf.add(factory.createPotion(PotionType.HOLY_WATER));
        this.bottomShelf.add(factory.createPotion(PotionType.HOLY_WATER));
    }

    /**
     * Get a read-only list of all the items on the top shelf
     *
     * @return The top shelf potions
     */
    public final List<Potion> getTopShelf() {
        return Collections.unmodifiableList(this.topShelf);
    }

    /**
     * Get a read-only list of all the items on the bottom shelf
     *
     * @return The bottom shelf potions
     */
    public final List<Potion> getBottomShelf() {
        return Collections.unmodifiableList(this.bottomShelf);
    }

    /**
     * Enumerate potions
     */
    public void enumerate() {
        log.info("Enumerating top shelf potions\n");
        this.topShelf.forEach(Potion::drink);

        log.info("Enumerating bottom shelf potions\n");
        this.bottomShelf.forEach(Potion::drink);
    }
}
