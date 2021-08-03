package com.sensiblemetrics.api.alpenidos.pattern.visitor2.unit;

import com.sensiblemetrics.api.alpenidos.pattern.visitor2.iface.UnitVisitor;

/**
 * Sergeant
 */
public class Sergeant extends Unit {

    public Sergeant(final Unit... children) {
        super(children);
    }

    @Override
    public void accept(final UnitVisitor visitor) {
        visitor.visitSergeant(this);
        super.accept(visitor);
    }

    @Override
    public String toString() {
        return "sergeant";
    }
}
