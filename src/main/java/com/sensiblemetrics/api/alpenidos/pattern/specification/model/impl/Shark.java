package com.sensiblemetrics.api.alpenidos.pattern.specification.model.impl;

import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Color;
import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Movement;
import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Size;

/**
 * Shark creature.
 */
public class Shark extends AbstractCreature {

    public Shark() {
        super("Shark", Size.NORMAL, Movement.SWIMMING, Color.LIGHT);
    }
}
