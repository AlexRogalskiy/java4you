package com.sensiblemetrics.api.alpenidos.core.specification.model.iface;

import com.sensiblemetrics.api.alpenidos.core.specification.property.Color;
import com.sensiblemetrics.api.alpenidos.core.specification.property.Movement;
import com.sensiblemetrics.api.alpenidos.core.specification.property.Size;

/**
 * Creature interface.
 */
public interface Creature {

    String getName();

    Size getSize();

    Movement getMovement();

    Color getColor();
}
