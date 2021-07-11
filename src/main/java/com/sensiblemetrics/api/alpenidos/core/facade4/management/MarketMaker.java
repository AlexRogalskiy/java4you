package com.sensiblemetrics.api.alpenidos.core.facade4.management;

import com.sensiblemetrics.api.alpenidos.core.facade4.model.TradeDetails;

/**
 * Market maker system determines the bid-ask spread for the exchange.
 */
public class MarketMaker {

    public void updateMarketMakingStrategy(TradeDetails trade) {
        System.out.println("Informing MarketMaker about trade so they can refine spread strategy...");
    }
}
