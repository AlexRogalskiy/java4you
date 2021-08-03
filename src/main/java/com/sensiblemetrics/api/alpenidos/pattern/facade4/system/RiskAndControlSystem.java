package com.sensiblemetrics.api.alpenidos.pattern.facade4.system;

import com.sensiblemetrics.api.alpenidos.pattern.facade4.model.TradeDetails;

/**
 * Manages the banks credit exposure and keeps tabs on Client credit history/dealings/defaults.
 */
public class RiskAndControlSystem {

    public void updateClientCreditScore(TradeDetails trade) {
        System.out.println("Updating Client's credit score...");
    }
}
