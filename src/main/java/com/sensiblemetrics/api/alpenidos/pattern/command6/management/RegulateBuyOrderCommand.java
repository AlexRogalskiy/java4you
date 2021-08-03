package com.sensiblemetrics.api.alpenidos.pattern.command6.management;

import com.sensiblemetrics.api.alpenidos.pattern.command6.model.Order;
import com.sensiblemetrics.api.alpenidos.pattern.command6.receiver.RegulatorySystem;

/**
 * Concrete Command for regulating a BUY order.
 * <p>
 */
public class RegulateBuyOrderCommand implements OrderCommand {

    /**
     * The Regulatory system is the receiver
     */
    private final RegulatorySystem regulatorySystem;

    /**
     * Constructs the command with the Receiver.
     *
     * @param regulatorySystem the receiver the command will perform operations on.
     */
    public RegulateBuyOrderCommand(RegulatorySystem regulatorySystem) {
        this.regulatorySystem = regulatorySystem;
    }

    @Override
    public void execute(Order order) {
        regulatorySystem.regulateBuyOrderDetails(); // TODO pass the order in and do something! ;-)
    }
}
