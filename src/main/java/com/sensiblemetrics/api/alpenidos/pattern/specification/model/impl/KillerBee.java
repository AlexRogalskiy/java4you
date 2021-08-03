package com.sensiblemetrics.api.alpenidos.pattern.specification.model.impl;

import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Color;
import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Movement;
import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Size;

/**
 * KillerBee creature.
 */
public class KillerBee extends AbstractCreature {

    public KillerBee() {
        super("KillerBee", Size.SMALL, Movement.FLYING, Color.LIGHT);
    }
}
