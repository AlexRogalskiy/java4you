package com.sensiblemetrics.api.alpenidos.pattern.observer5.event;

import com.sensiblemetrics.api.alpenidos.pattern.observer5.enumeration.MarketType;
import java.math.BigDecimal;
import java.util.EventObject;

/**
 * Event sent from the Subject to interested Observers when a new bid price comes in.
 * <p>
 */
public class LatestMarketBidPriceEvent extends EventObject {

    /**
     * SID
     */
    private static final long serialVersionUID = 3503294561418438023L;

    /**
     * The info the Observers are actually interested in
     */
    private final BigDecimal latestBidPrice;

    /**
     * The market this event is for
     */
    private final MarketType marketType;

    /**
     * Constructor builds the event.
     *
     * @param source         where this event came from - don't care for this demo.
     * @param latestBidPrice the latest bid price.
     */
    public LatestMarketBidPriceEvent(Object source, BigDecimal latestBidPrice, MarketType marketType) {
        super(source);
        this.latestBidPrice = latestBidPrice;
        this.marketType = marketType;
    }

    /**
     * Returns the latest bid price.
     *
     * @return latest bid price
     */
    public BigDecimal getLatestBidPrice() {
        return latestBidPrice;
    }

    /**
     * Returns the market type.
     *
     * @return the market type
     */
    public MarketType getMarketType() {
        return marketType;
    }
}
