package com.sensiblemetrics.api.alpenidos.core.command6.receiver;

/**
 * A Receiver.
 * <p>
 * This is the exchange's regulatory and compliance system. Massively simplified for the demo!
 * <p>
 */
public class RegulatorySystem {

    public void regulateBuyOrderDetails() {
        System.out.println(RegulatorySystem.class.getSimpleName() + " - regulating BUY order details.");
    }

    public void regulateSellOrderDetails() {
        System.out.println(RegulatorySystem.class.getSimpleName() + " regulating SELL order details.");
    }
}
