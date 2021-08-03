package com.sensiblemetrics.api.alpenidos.pattern.facade4.system;

import com.sensiblemetrics.api.alpenidos.pattern.facade4.model.TradeDetails;

/**
 * Regulatory system makes sure the trade activity complies with the Treasury and SEC regulations.
 */
public class RegulatorySystem {

    public void auditTrade(TradeDetails trade) {
        System.out.println("Checking trade for regulatory compliance...");
    }
}
