package com.sensiblemetrics.api.alpenidos.pattern.specification.model.impl;

import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Color;
import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Movement;
import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Size;

/**
 * Goblin creature.
 */
public class Goblin extends AbstractCreature {

    public Goblin() {
        super("Goblin", Size.SMALL, Movement.WALKING, Color.GREEN);
    }
}
