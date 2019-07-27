package com.sensiblemetrics.api.alpenidos.core.flyweight.model;

import com.sensiblemetrics.api.alpenidos.core.flyweight.iface.Vehicle;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.concurrent.Immutable;
import java.awt.*;

/**
 * Represents a car. This class is immutable.
 *
 * @author Donato Rimenti
 */
@Slf4j
@Immutable
public class Car implements Vehicle {
    /**
     * The car's engine.
     */
    private final Engine engine;

    /**
     * The car's color.
     */
    private final Color color;

    /**
     * Instantiates a new Car.
     *
     * @param engine the {@link #engine}
     * @param color  the {@link #color}
     */
    public Car(final Engine engine, final Color color) {
        this.engine = engine;
        this.color = color;

        // Building a new car is a very expensive operation!
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("Error while creating a new car", e);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baeldung.flyweight.Vehicle#start()
     */
    @Override
    public void start() {
        log.info("Car is starting!");
        this.engine.start();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baeldung.flyweight.Vehicle#stop()
     */
    @Override
    public void stop() {
        log.info("Car is stopping!");
        this.engine.stop();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.baeldung.flyweight.Vehicle#getColor()
     */
    @Override
    public Color getColor() {
        return this.color;
    }
}
