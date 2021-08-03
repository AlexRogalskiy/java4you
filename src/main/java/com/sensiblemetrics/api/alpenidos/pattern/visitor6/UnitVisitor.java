package com.sensiblemetrics.api.alpenidos.pattern.visitor6;

public interface UnitVisitor {

    void visitSoldier(Soldier soldier);

    void visitSergeant(Sergeant sergeant);

    void visitCommander(Commander commander);
}
