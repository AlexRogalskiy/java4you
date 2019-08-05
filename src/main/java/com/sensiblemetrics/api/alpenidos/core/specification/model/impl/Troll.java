package com.sensiblemetrics.api.alpenidos.core.specification.model.impl;

import com.sensiblemetrics.api.alpenidos.core.specification.property.Color;
import com.sensiblemetrics.api.alpenidos.core.specification.property.Movement;
import com.sensiblemetrics.api.alpenidos.core.specification.property.Size;

/**
 * Troll creature.
 */
public class Troll extends AbstractCreature {

    public Troll() {
        super("Troll", Size.LARGE, Movement.WALKING, Color.DARK);
    }
}
