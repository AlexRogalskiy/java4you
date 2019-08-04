package com.sensiblemetrics.api.alpenidos.core.flyweight2.factory;

import com.sensiblemetrics.api.alpenidos.core.flyweight2.enums.PotionType;
import com.sensiblemetrics.api.alpenidos.core.flyweight2.iface.Potion;
import com.sensiblemetrics.api.alpenidos.core.flyweight2.impl.*;

import java.util.EnumMap;
import java.util.Map;

/**
 * PotionFactory is the Flyweight in this example. It minimizes memory use by sharing object
 * instances. It holds a map of potion instances and new potions are created only when none of the
 * type already exists.
 */
public class PotionFactory {
    private final Map<PotionType, Potion> potions;

    public PotionFactory() {
        this.potions = new EnumMap<>(PotionType.class);
    }

    public Potion createPotion(final PotionType type) {
        Potion potion = this.potions.get(type);
        if (potion == null) {
            switch (type) {
                case HEALING:
                    potion = new HealingPotion();
                    this.potions.put(type, potion);
                    break;
                case HOLY_WATER:
                    potion = new HolyWaterPotion();
                    this.potions.put(type, potion);
                    break;
                case INVISIBILITY:
                    potion = new InvisibilityPotion();
                    this.potions.put(type, potion);
                    break;
                case POISON:
                    potion = new PoisonPotion();
                    this.potions.put(type, potion);
                    break;
                case STRENGTH:
                    potion = new StrengthPotion();
                    this.potions.put(type, potion);
                    break;
                default:
                    break;
            }
        }
        return potion;
    }
}
