package com.sensiblemetrics.api.alpenidos.pattern.visitor6;

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
