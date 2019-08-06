package com.sensiblemetrics.api.alpenidos.core.visitor2.unit;

import com.sensiblemetrics.api.alpenidos.core.visitor2.iface.UnitVisitor;

import java.util.Arrays;

/**
 * Interface for the nodes in hierarchy.
 */
public abstract class Unit {
    private final Unit[] children;

    public Unit(final Unit... children) {
        this.children = children;
    }

    /**
     * Accept visitor
     */
    public void accept(final UnitVisitor visitor) {
        Arrays.stream(this.children).forEach(c -> c.accept(visitor));
    }
}
