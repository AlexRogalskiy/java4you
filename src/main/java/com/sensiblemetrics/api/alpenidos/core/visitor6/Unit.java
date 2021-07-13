package com.sensiblemetrics.api.alpenidos.core.visitor6;

/**
 * Interface for the nodes in hierarchy.
 */
public abstract class Unit {

    private final Unit[] children;

    public Unit(final Unit... children) {
        this.children = children;
    }

    public void accept(final UnitVisitor visitor) {
        for (final Unit child : this.children) {
            child.accept(visitor);
        }
    }
}
