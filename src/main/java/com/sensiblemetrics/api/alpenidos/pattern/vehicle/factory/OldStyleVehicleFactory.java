package com.sensiblemetrics.api.alpenidos.pattern.vehicle.factory;

import com.sensiblemetrics.api.alpenidos.pattern.vehicle.enumeration.VehicleColor;
import com.sensiblemetrics.api.alpenidos.pattern.vehicle.enumeration.VehicleType;
import com.sensiblemetrics.api.alpenidos.pattern.vehicle.model.Bus;
import com.sensiblemetrics.api.alpenidos.pattern.vehicle.model.Car;
import com.sensiblemetrics.api.alpenidos.pattern.vehicle.model.Truck;
import com.sensiblemetrics.api.alpenidos.pattern.vehicle.model.Vehicle;

public class OldStyleVehicleFactory {
    /*
    Issues:
        1 - if conditions to check type leads to duplication most of the times
        2 - Adding a new type of vehicle implies adding a new conditional
        3 - We have to throw IllegalArgumentException if there's no match for type
        4 - Harder to read
     */
    public static Vehicle instanceOfType(final VehicleType type,
                                         final VehicleColor color) {
        if (type.equals(VehicleType.CAR)) {
            return new Car(color);
        } else if (type.equals(VehicleType.BUS)) {
            return new Bus(color);
        } else if (type.equals(VehicleType.TRUCK)) {
            return new Truck(color);
        }

        throw new IllegalArgumentException("No support for type " + type);
    }
}
