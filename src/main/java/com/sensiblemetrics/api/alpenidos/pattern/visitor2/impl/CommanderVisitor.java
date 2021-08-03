package com.sensiblemetrics.api.alpenidos.pattern.visitor2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.visitor2.iface.UnitVisitor;
import com.sensiblemetrics.api.alpenidos.pattern.visitor2.unit.Commander;
import com.sensiblemetrics.api.alpenidos.pattern.visitor2.unit.Sergeant;
import com.sensiblemetrics.api.alpenidos.pattern.visitor2.unit.Soldier;
import lombok.extern.slf4j.Slf4j;

/**
 * CommanderVisitor
 */
@Slf4j
public class CommanderVisitor implements UnitVisitor {

    @Override
    public void visitSoldier(final Soldier soldier) {
        // Do nothing
    }

    @Override
    public void visitSergeant(final Sergeant sergeant) {
        // Do nothing
    }

    @Override
    public void visitCommander(final Commander commander) {
        log.info("Good to see you {}", commander);
    }
}
