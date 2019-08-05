package com.sensiblemetrics.api.alpenidos.core.specification.model.impl;

import com.sensiblemetrics.api.alpenidos.core.specification.property.Color;
import com.sensiblemetrics.api.alpenidos.core.specification.property.Movement;
import com.sensiblemetrics.api.alpenidos.core.specification.property.Size;

/**
 * KillerBee creature.
 */
public class KillerBee extends AbstractCreature {

    public KillerBee() {
        super("KillerBee", Size.SMALL, Movement.FLYING, Color.LIGHT);
    }
}
