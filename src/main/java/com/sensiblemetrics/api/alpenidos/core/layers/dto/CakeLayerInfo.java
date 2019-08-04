package com.sensiblemetrics.api.alpenidos.core.layers.dto;

import java.util.Optional;

/**
 * DTO for cake layers
 */
public class CakeLayerInfo {
    public Optional<Long> id;
    public String name;
    public int calories;

    /**
     * Constructor
     */
    public CakeLayerInfo(final Long id, final String name, final int calories) {
        this.id = Optional.ofNullable(id);
        this.name = name;
        this.calories = calories;
    }

    /**
     * Constructor
     */
    public CakeLayerInfo(final String name, final int calories) {
        this(null, name, calories);
    }

    @Override
    public String toString() {
        return String.format("CakeLayerInfo id=%d name=%s calories=%d", id.orElse(-1L), this.name, this.calories);
    }
}
