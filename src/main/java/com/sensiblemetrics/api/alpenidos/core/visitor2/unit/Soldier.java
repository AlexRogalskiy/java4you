package com.sensiblemetrics.api.alpenidos.core.visitor2.unit;

import com.sensiblemetrics.api.alpenidos.core.visitor2.iface.UnitVisitor;

/**
 * Soldier
 */
public class Soldier extends Unit {

    public Soldier(final Unit... children) {
        super(children);
    }

    @Override
    public void accept(final UnitVisitor visitor) {
        visitor.visitSoldier(this);
        super.accept(visitor);
    }

    @Override
    public String toString() {
        return "soldier";
    }
}
