package com.sensiblemetrics.api.alpenidos.core.observer5.management;

import com.sensiblemetrics.api.alpenidos.core.observer5.enumeration.MarketType;
import com.sensiblemetrics.api.alpenidos.core.observer5.event.LatestMarketBidPriceEvent;
import java.math.BigDecimal;

/**
 * This would not exist in real world. Here because I'm too lazy to type same code for each bot...
 * <p>
 * Implements #{link MarketEventListener} to receive price updates...
 * <p>
 */
abstract class AbstractTradingBot implements MarketEventListener {

    /**
     * USD GBP market bid price
     */
    private BigDecimal latestUsdGbpMarketBidPrice = new BigDecimal("0.60");

    /**
     * USD EUR market bid price
     */
    private BigDecimal latestUsdEurMarketBidPrice = new BigDecimal("0.73");


    public BigDecimal getLatestUsdGbpMarketBidPrice() {
        return latestUsdGbpMarketBidPrice;
    }

    public BigDecimal getLatestUsdEuroMarketBidPrice() {
        return latestUsdEurMarketBidPrice;
    }


    /**
     * This is the callback for when price changes...
     */
    @Override
    public void onBidPriceUpdate(final LatestMarketBidPriceEvent newBidPriceEvent) {
        // Bleurgh! but you get the idea...
        if (newBidPriceEvent.getMarketType() == MarketType.USD_GBP) {
            latestUsdGbpMarketBidPrice = newBidPriceEvent.getLatestBidPrice();
        } else if (newBidPriceEvent.getMarketType() == MarketType.USD_EUR) {
            latestUsdEurMarketBidPrice = newBidPriceEvent.getLatestBidPrice();
        }
    }
}
