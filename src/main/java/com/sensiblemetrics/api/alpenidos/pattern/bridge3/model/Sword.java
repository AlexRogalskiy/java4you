package com.sensiblemetrics.api.alpenidos.pattern.bridge3.model;

import com.sensiblemetrics.api.alpenidos.pattern.bridge3.iface.Enchantment;
import com.sensiblemetrics.api.alpenidos.pattern.bridge3.iface.Weapon;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Sword
 */
@Data
@Slf4j
@RequiredArgsConstructor
public class Sword implements Weapon {
    private final Enchantment enchantment;

    @Override
    public void wield() {
        log.info("The sword is wielded.");
        this.enchantment.onActivate();
    }

    @Override
    public void swing() {
        log.info("The sword is swinged.");
        this.enchantment.apply();
    }

    @Override
    public void unwield() {
        log.info("The sword is unwielded.");
        this.enchantment.onDeactivate();
    }
}
