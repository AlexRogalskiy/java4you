package com.sensiblemetrics.api.alpenidos.core.visitor6;

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
