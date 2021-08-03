package com.sensiblemetrics.api.alpenidos.pattern.bridge3;

import com.sensiblemetrics.api.alpenidos.pattern.bridge3.iface.Enchantment;
import com.sensiblemetrics.api.alpenidos.pattern.bridge3.iface.Weapon;
import com.sensiblemetrics.api.alpenidos.pattern.bridge3.impl.FlyingEnchantment;
import com.sensiblemetrics.api.alpenidos.pattern.bridge3.impl.SoulEatingEnchantment;
import com.sensiblemetrics.api.alpenidos.pattern.bridge3.model.Hammer;
import com.sensiblemetrics.api.alpenidos.pattern.bridge3.model.Sword;
import lombok.extern.slf4j.Slf4j;

/**
 * Composition over inheritance. The Bridge pattern can also be thought of as two layers of abstraction.
 * With Bridge, you can decouple an abstraction from its implementation so that the two can vary independently.
 * <p>
 * In Bridge pattern both abstraction ({@link Weapon}) and implementation (
 * {@link Enchantment}) have their own class hierarchies. The interface of the implementations
 * can be changed without affecting the clients.
 * <p>
 * In this example we have two class hierarchies. One of weapons and another one of enchantments. We can easily
 * combine any weapon with any enchantment using composition instead of creating deep class hierarchy.
 */
@Slf4j
public class App {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        log.info("The knight receives an enchanted sword.");
        final Sword enchantedSword = new Sword(new SoulEatingEnchantment());
        enchantedSword.wield();
        enchantedSword.swing();
        enchantedSword.unwield();

        log.info("The valkyrie receives an enchanted hammer.");
        final Hammer hammer = new Hammer(new FlyingEnchantment());
        hammer.wield();
        hammer.swing();
        hammer.unwield();
    }
}
