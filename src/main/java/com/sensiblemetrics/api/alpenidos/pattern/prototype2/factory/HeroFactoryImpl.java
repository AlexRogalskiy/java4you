package com.sensiblemetrics.api.alpenidos.pattern.prototype2.factory;

import com.sensiblemetrics.api.alpenidos.pattern.prototype2.iface.HeroFactory;
import com.sensiblemetrics.api.alpenidos.pattern.prototype2.impl.Beast;
import com.sensiblemetrics.api.alpenidos.pattern.prototype2.impl.Mage;
import com.sensiblemetrics.api.alpenidos.pattern.prototype2.impl.Warlord;
import lombok.RequiredArgsConstructor;

/**
 * Concrete factory class.
 */
@RequiredArgsConstructor
public class HeroFactoryImpl implements HeroFactory {
    private final Mage mage;
    private final Warlord warlord;
    private final Beast beast;

    /**
     * Create mage
     */
    public Mage createMage() {
        try {
            return this.mage.copy();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /**
     * Create warlord
     */
    public Warlord createWarlord() {
        try {
            return this.warlord.copy();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /**
     * Create beast
     */
    public Beast createBeast() {
        try {
            return this.beast.copy();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
