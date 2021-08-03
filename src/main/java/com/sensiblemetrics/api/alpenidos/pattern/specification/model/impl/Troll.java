package com.sensiblemetrics.api.alpenidos.pattern.specification.model.impl;

import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Color;
import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Movement;
import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Size;

/**
 * Troll creature.
 */
public class Troll extends AbstractCreature {

    public Troll() {
        super("Troll", Size.LARGE, Movement.WALKING, Color.DARK);
    }
}
