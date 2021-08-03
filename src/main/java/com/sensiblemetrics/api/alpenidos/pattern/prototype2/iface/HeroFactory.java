package com.sensiblemetrics.api.alpenidos.pattern.prototype2.iface;

import com.sensiblemetrics.api.alpenidos.pattern.prototype2.impl.Beast;
import com.sensiblemetrics.api.alpenidos.pattern.prototype2.impl.Mage;
import com.sensiblemetrics.api.alpenidos.pattern.prototype2.impl.Warlord;

/**
 * Interface for the factory class.
 */
public interface HeroFactory {

    Mage createMage();

    Warlord createWarlord();

    Beast createBeast();
}
