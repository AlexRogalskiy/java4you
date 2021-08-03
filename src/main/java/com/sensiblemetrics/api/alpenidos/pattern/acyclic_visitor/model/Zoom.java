package com.sensiblemetrics.api.alpenidos.pattern.acyclic_visitor.model;

import com.sensiblemetrics.api.alpenidos.pattern.acyclic_visitor.iface.ModemVisitor;
import com.sensiblemetrics.api.alpenidos.pattern.acyclic_visitor.iface.ZoomVisitor;
import lombok.extern.slf4j.Slf4j;

/**
 * Zoom class implements its accept method
 */
@Slf4j
public class Zoom extends Modem {

    /**
     * Accepts all visitors but honors only ZoomVisitor
     */
    @Override
    public void accept(final ModemVisitor modemVisitor) {
        if (modemVisitor instanceof ZoomVisitor) {
            ((ZoomVisitor) modemVisitor).visit(this);
        } else {
            log.info("Only ZoomVisitor is allowed to visit Zoom modem");
        }
    }

    /**
     * Zoom modem's toString
     * method
     */
    @Override
    public String toString() {
        return "Zoom modem";
    }
}
