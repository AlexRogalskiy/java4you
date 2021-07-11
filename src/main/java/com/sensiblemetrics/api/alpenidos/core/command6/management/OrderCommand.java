package com.sensiblemetrics.api.alpenidos.core.command6.management;

import com.sensiblemetrics.api.alpenidos.core.command6.model.Order;

/**
 * The Command interface.
 */
@FunctionalInterface
public interface OrderCommand {

    /**
     * The Command Invoker calls this.
     */
    void execute(Order order);
}
