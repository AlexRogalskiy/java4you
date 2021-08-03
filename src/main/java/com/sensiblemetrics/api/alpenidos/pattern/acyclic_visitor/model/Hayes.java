package com.sensiblemetrics.api.alpenidos.pattern.acyclic_visitor.model;

import com.sensiblemetrics.api.alpenidos.pattern.acyclic_visitor.iface.HayesVisitor;
import com.sensiblemetrics.api.alpenidos.pattern.acyclic_visitor.iface.ModemVisitor;
import lombok.extern.slf4j.Slf4j;

/**
 * Hayes class implements its accept method
 */
@Slf4j
public class Hayes extends Modem {

    /**
     * Accepts all visitors but honors only HayesVisitor
     */
    @Override
    public void accept(ModemVisitor modemVisitor) {
        if (modemVisitor instanceof HayesVisitor) {
            ((HayesVisitor) modemVisitor).visit(this);
        } else {
            log.info("Only HayesVisitor is allowed to visit Hayes modem");
        }
    }

    /**
     * Hayes' modem's toString
     * method
     */
    @Override
    public String toString() {
        return "Hayes modem";
    }
}
