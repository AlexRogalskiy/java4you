package com.sensiblemetrics.api.alpenidos.pattern.bridge3.iface;

/**
 * Weapon
 */
public interface Weapon {

    void wield();

    void swing();

    void unwield();

    Enchantment getEnchantment();
}
