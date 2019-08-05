package com.sensiblemetrics.api.alpenidos.core.specification.model.impl;

import com.sensiblemetrics.api.alpenidos.core.specification.property.Color;
import com.sensiblemetrics.api.alpenidos.core.specification.property.Movement;
import com.sensiblemetrics.api.alpenidos.core.specification.property.Size;

/**
 * Goblin creature.
 */
public class Goblin extends AbstractCreature {

    public Goblin() {
        super("Goblin", Size.SMALL, Movement.WALKING, Color.GREEN);
    }
}
