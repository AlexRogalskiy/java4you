package com.sensiblemetrics.api.alpenidos.core.specification.model.impl;

import com.sensiblemetrics.api.alpenidos.core.specification.property.Color;
import com.sensiblemetrics.api.alpenidos.core.specification.property.Movement;
import com.sensiblemetrics.api.alpenidos.core.specification.property.Size;

/**
 * Octopus creature.
 */
public class Octopus extends AbstractCreature {

    public Octopus() {
        super("Octopus", Size.NORMAL, Movement.SWIMMING, Color.DARK);
    }
}
