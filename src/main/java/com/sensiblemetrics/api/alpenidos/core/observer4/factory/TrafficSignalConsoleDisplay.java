package com.sensiblemetrics.api.alpenidos.core.observer4.factory;

import com.sensiblemetrics.api.alpenidos.core.observer4.enums.TrafficSignalEvent;
import com.sensiblemetrics.api.alpenidos.core.observer4.iface.TrafficSignalObserver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TrafficSignalConsoleDisplay implements TrafficSignalObserver {

    @Override
    public void notify(final TrafficSignalEvent event) {
        switch (event) {
            case BUTTON_PRESSED:
                log.info("Button pressed!");
                break;
            case TURNED_GREEN:
                log.info("Traffic signal turns GREEN");
                break;
            case TURNED_ORANGE:
                log.info("Traffic signal turns ORANGE");
                break;
            case TURNED_RED:
                log.info("Traffic signal turns RED");
                break;
        }
    }
}
