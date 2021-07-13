package com.sensiblemetrics.api.alpenidos.core.visitor6;

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
