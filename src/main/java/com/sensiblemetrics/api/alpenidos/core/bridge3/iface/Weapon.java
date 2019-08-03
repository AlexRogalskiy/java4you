package com.sensiblemetrics.api.alpenidos.core.bridge3.iface;

import com.sensiblemetrics.api.alpenidos.core.bridge3.iface.Enchantment;

/**
 * Weapon
 */
public interface Weapon {

    void wield();

    void swing();

    void unwield();

    Enchantment getEnchantment();
}
