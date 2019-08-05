package com.sensiblemetrics.api.alpenidos.core.specification.model.impl;

import com.sensiblemetrics.api.alpenidos.core.specification.model.iface.Creature;
import com.sensiblemetrics.api.alpenidos.core.specification.property.Color;
import com.sensiblemetrics.api.alpenidos.core.specification.property.Movement;
import com.sensiblemetrics.api.alpenidos.core.specification.property.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Base class for concrete creatures.
 */
@Data
@AllArgsConstructor
public abstract class AbstractCreature implements Creature {
    private String name;
    private Size size;
    private Movement movement;
    private Color color;

    @Override
    public String toString() {
        return String.format("%s [size=%s, movement=%s, color=%s]", this.name, this.size, this.movement, this.color);
    }
}
