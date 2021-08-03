package com.sensiblemetrics.api.alpenidos.pattern.visitor2.iface;

import com.sensiblemetrics.api.alpenidos.pattern.visitor2.unit.Commander;
import com.sensiblemetrics.api.alpenidos.pattern.visitor2.unit.Sergeant;
import com.sensiblemetrics.api.alpenidos.pattern.visitor2.unit.Soldier;

/**
 * Visitor interface.
 */
public interface UnitVisitor {

    void visitSoldier(final Soldier soldier);

    void visitSergeant(final Sergeant sergeant);

    void visitCommander(final Commander commander);
}
