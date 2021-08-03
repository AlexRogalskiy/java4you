package com.sensiblemetrics.api.alpenidos.pattern.specification.model.impl;

import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Color;
import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Movement;
import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Size;

/**
 * Octopus creature.
 */
public class Octopus extends AbstractCreature {

    public Octopus() {
        super("Octopus", Size.NORMAL, Movement.SWIMMING, Color.DARK);
    }
}
