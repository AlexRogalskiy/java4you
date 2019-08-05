package com.sensiblemetrics.api.alpenidos.core.observer2.observer;

import com.sensiblemetrics.api.alpenidos.core.observer2.enums.WeatherType;
import com.sensiblemetrics.api.alpenidos.core.observer2.iface.Race;
import com.sensiblemetrics.api.alpenidos.core.observer2.observable.GWeather;
import lombok.extern.slf4j.Slf4j;

/**
 * GHobbits
 */
@Slf4j
public class GHobbits implements Race {

    @Override
    public void update(final GWeather weather, final WeatherType weatherType) {
        switch (weatherType) {
            case COLD:
                log.info("The hobbits are shivering in the cold weather.");
                break;
            case RAINY:
                log.info("The hobbits look for cover from the rain.");
                break;
            case SUNNY:
                log.info("The happy hobbits bade in the warm sun.");
                break;
            case WINDY:
                log.info("The hobbits hold their hats tightly in the windy weather.");
                break;
            default:
                break;
        }
    }
}
