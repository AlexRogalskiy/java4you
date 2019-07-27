package com.sensiblemetrics.api.alpenidos.core.flyweight;

import com.sensiblemetrics.api.alpenidos.core.flyweight.iface.Vehicle;
import com.sensiblemetrics.api.alpenidos.core.flyweight.model.Car;
import com.sensiblemetrics.api.alpenidos.core.flyweight.model.Engine;
import lombok.experimental.UtilityClass;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory which implements the Flyweight pattern to return an existing vehicle
 * if present or a new one otherwise.
 */
@UtilityClass
public class VehicleFactory {

    /**
     * Stores the already created vehicles.
     */
    private static Map<Color, Vehicle> vehiclesCache = new HashMap<>();

    /**
     * Returns a vehicle of the same color passed as argument. If that vehicle
     * was already created by this factory, that vehicle is returned, otherwise
     * a new one is created and returned.
     *
     * @param color the color of the vehicle to return
     * @return a vehicle of the specified color
     */
    public static Vehicle createVehicle(final Color color) {
        // Looks for the requested vehicle into the cache.
        // If the vehicle doesn't exist, a new one is created.
        final Vehicle newVehicle = vehiclesCache.computeIfAbsent(color, newColor -> {
            // Creates the new car.
            final Engine newEngine = new Engine();
            return new Car(newEngine, newColor);
        });
        return newVehicle;
    }
}
