package com.sensiblemetrics.api.alpenidos.core.visitor2.impl;

import com.sensiblemetrics.api.alpenidos.core.visitor2.iface.UnitVisitor;
import com.sensiblemetrics.api.alpenidos.core.visitor2.unit.Commander;
import com.sensiblemetrics.api.alpenidos.core.visitor2.unit.Sergeant;
import com.sensiblemetrics.api.alpenidos.core.visitor2.unit.Soldier;
import lombok.extern.slf4j.Slf4j;

/**
 * SergeantVisitor
 */
@Slf4j
public class SergeantVisitor implements UnitVisitor {

    @Override
    public void visitSoldier(final Soldier soldier) {
        // Do nothing
    }

    @Override
    public void visitSergeant(Sergeant sergeant) {
        log.info("Hello {}", sergeant);
    }

    @Override
    public void visitCommander(final Commander commander) {
        // Do nothing
    }
}
