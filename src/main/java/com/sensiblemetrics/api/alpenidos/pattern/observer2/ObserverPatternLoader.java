package com.sensiblemetrics.api.alpenidos.pattern.observer2;

import com.sensiblemetrics.api.alpenidos.pattern.observer2.observable.GWeather;
import com.sensiblemetrics.api.alpenidos.pattern.observer2.observable.Weather;
import com.sensiblemetrics.api.alpenidos.pattern.observer2.observer.GHobbits;
import com.sensiblemetrics.api.alpenidos.pattern.observer2.observer.GOrcs;
import com.sensiblemetrics.api.alpenidos.pattern.observer2.observer.Hobbits;
import com.sensiblemetrics.api.alpenidos.pattern.observer2.observer.Orcs;
import lombok.extern.slf4j.Slf4j;

/**
 * The Observer pattern is a software design pattern in which an object, called the subject,
 * maintains a list of its dependents, called observers, and notifies them automatically of any
 * state changes, usually by calling one of their methods. It is mainly used to implement
 * distributed event handling systems. The Observer pattern is also a key part in the familiar
 * model–view–controller (MVC) architectural pattern. The Observer pattern is implemented in
 * numerous programming libraries and systems, including almost all GUI toolkits.
 * <p>
 * In this example {@link Weather} has a state that can be observed. The {@link Orcs} and
 * {@link Hobbits} register as observers and receive notifications when the {@link Weather} changes.
 */
@Slf4j
public class ObserverPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        final Weather weather = new Weather();
        weather.addObserver(new Orcs());
        weather.addObserver(new Hobbits());

        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
        weather.timePasses();

        // Generic observer inspired by Java Generics and Collection by Naftalin & Wadler
        log.info("--Running generic version--");
        final GWeather gWeather = new GWeather();
        gWeather.addObserver(new GOrcs());
        gWeather.addObserver(new GHobbits());

        gWeather.timePasses();
        gWeather.timePasses();
        gWeather.timePasses();
        gWeather.timePasses();
    }
}
