package com.sensiblemetrics.api.alpenidos.pattern.observer5.management;

import com.sensiblemetrics.api.alpenidos.pattern.observer5.event.LatestMarketBidPriceEvent;
import java.util.EventListener;

/**
 * The market event listener our Observable (Market) implements.
 * <p>
 * EventListener is just a marker/tag interface like Serializable.
 */
@FunctionalInterface
public interface MarketEventListener extends EventListener {

    /**
     * All the Observers (bots) must implement this.
     * <p>
     * This is the 'callback' for when bid price changes.
     *
     * @param newBidPriceEvent the event with the latest bid price.
     */
    void onBidPriceUpdate(LatestMarketBidPriceEvent newBidPriceEvent);
}
