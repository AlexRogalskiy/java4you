package com.sensiblemetrics.api.alpenidos.core.visitor2.unit;

import com.sensiblemetrics.api.alpenidos.core.visitor2.iface.UnitVisitor;
import com.sensiblemetrics.api.alpenidos.core.visitor2.unit.Unit;

/**
 * Commander
 */
public class Commander extends Unit {

    public Commander(final Unit... children) {
        super(children);
    }

    @Override
    public void accept(final UnitVisitor visitor) {
        visitor.visitCommander(this);
        super.accept(visitor);
    }

    @Override
    public String toString() {
        return "commander";
    }
}
