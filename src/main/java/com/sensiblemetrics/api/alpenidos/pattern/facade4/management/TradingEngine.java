package com.sensiblemetrics.api.alpenidos.pattern.facade4.management;

import com.sensiblemetrics.api.alpenidos.pattern.facade4.model.TradeDetails;

/**
 * The main trading engine that fills the orders.
 */
public class TradingEngine {

    public TradingEngine() {
    }

    public void fillBuyOrder(TradeDetails trade) {
        System.out.println("Filling Buy order...");
    }

    public void fillSellOrder(TradeDetails trade) {
        System.out.println("Filling Sell order...");
    }
}
