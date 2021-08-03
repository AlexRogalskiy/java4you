package com.sensiblemetrics.api.alpenidos.pattern.observer2.observer;

import com.sensiblemetrics.api.alpenidos.pattern.observer2.enums.WeatherType;
import com.sensiblemetrics.api.alpenidos.pattern.observer2.iface.Race;
import com.sensiblemetrics.api.alpenidos.pattern.observer2.observable.GWeather;
import lombok.extern.slf4j.Slf4j;

/**
 * GOrcs
 */
@Slf4j
public class GOrcs implements Race {

    @Override
    public void update(final GWeather weather, final WeatherType weatherType) {
        switch (weatherType) {
            case COLD:
                log.info("The orcs are freezing cold.");
                break;
            case RAINY:
                log.info("The orcs are dripping wet.");
                break;
            case SUNNY:
                log.info("The sun hurts the orcs' eyes.");
                break;
            case WINDY:
                log.info("The orc smell almost vanishes in the wind.");
                break;
            default:
                break;
        }
    }
}
