package com.sensiblemetrics.api.alpenidos.pattern.facade4.system;

import com.sensiblemetrics.api.alpenidos.pattern.facade4.model.TradeDetails;

/**
 * Clears the filled orders in the back office.
 */
public class SettlementSystem {

    public void settle(TradeDetails trade) {
        System.out.println("Queueing up trade in Settlements system for backoffice to clear...");
    }
}
