package com.sensiblemetrics.api.alpenidos.core.event.aggregator.impl;

import com.sensiblemetrics.api.alpenidos.core.event.aggregator.enums.Event;
import com.sensiblemetrics.api.alpenidos.core.event.aggregator.iface.EventObserver;
import lombok.extern.slf4j.Slf4j;

/**
 * KingJoffrey observes events from {@link KingsHand}.
 */
@Slf4j
public class KingJoffrey implements EventObserver {

    @Override
    public void onEvent(final Event e) {
        log.info("Received event from the King's Hand: {}", e.toString());
    }
}
