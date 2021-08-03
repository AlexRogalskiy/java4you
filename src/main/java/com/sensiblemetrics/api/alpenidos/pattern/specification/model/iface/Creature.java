package com.sensiblemetrics.api.alpenidos.pattern.specification.model.iface;

import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Color;
import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Movement;
import com.sensiblemetrics.api.alpenidos.pattern.specification.property.Size;

/**
 * Creature interface.
 */
public interface Creature {

    String getName();

    Size getSize();

    Movement getMovement();

    Color getColor();
}
