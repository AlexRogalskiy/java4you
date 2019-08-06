package com.sensiblemetrics.api.alpenidos.core.visitor2.impl;

import com.sensiblemetrics.api.alpenidos.core.visitor2.iface.UnitVisitor;
import com.sensiblemetrics.api.alpenidos.core.visitor2.unit.Commander;
import com.sensiblemetrics.api.alpenidos.core.visitor2.unit.Sergeant;
import com.sensiblemetrics.api.alpenidos.core.visitor2.unit.Soldier;
import lombok.extern.slf4j.Slf4j;

/**
 * SoldierVisitor
 */
@Slf4j
public class SoldierVisitor implements UnitVisitor {

    @Override
    public void visitSoldier(final Soldier soldier) {
        log.info("Greetings {}", soldier);
    }

    @Override
    public void visitSergeant(final Sergeant sergeant) {
        // Do nothing
    }

    @Override
    public void visitCommander(final Commander commander) {
        // Do nothing
    }
}
