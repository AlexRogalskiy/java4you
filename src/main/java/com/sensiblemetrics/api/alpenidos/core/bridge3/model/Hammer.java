package com.sensiblemetrics.api.alpenidos.core.bridge3.model;

import com.sensiblemetrics.api.alpenidos.core.bridge3.iface.Enchantment;
import com.sensiblemetrics.api.alpenidos.core.bridge3.iface.Weapon;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Hammer
 */
@Data
@Slf4j
@RequiredArgsConstructor
public class Hammer implements Weapon {
    private final Enchantment enchantment;

    @Override
    public void wield() {
        log.info("The hammer is wielded.");
        this.enchantment.onActivate();
    }

    @Override
    public void swing() {
        log.info("The hammer is swinged.");
        this.enchantment.apply();
    }

    @Override
    public void unwield() {
        log.info("The hammer is unwielded.");
        this.enchantment.onDeactivate();
    }
}
