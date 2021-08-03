package com.sensiblemetrics.api.alpenidos.pattern.specification.model.impl;

import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Color;
import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Movement;
import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Size;

/**
 * Dragon creature.
 */
public class Dragon extends AbstractCreature {

    public Dragon() {
        super("Dragon", Size.LARGE, Movement.FLYING, Color.RED);
    }
}
