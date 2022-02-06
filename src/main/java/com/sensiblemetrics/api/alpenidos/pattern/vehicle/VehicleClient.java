package com.sensiblemetrics.api.alpenidos.pattern.vehicle;

import com.sensiblemetrics.api.alpenidos.pattern.vehicle.enumeration.VehicleColor;
import com.sensiblemetrics.api.alpenidos.pattern.vehicle.enumeration.VehicleType;
import com.sensiblemetrics.api.alpenidos.pattern.vehicle.factory.OldStyleVehicleFactory;
import com.sensiblemetrics.api.alpenidos.pattern.vehicle.model.Vehicle;

public class VehicleClient {

    public static void main(final String[] args) {
        final Vehicle redCar = VehicleType.CAR.factory.apply(VehicleColor.RED);
        final Vehicle redCar2 = OldStyleVehicleFactory.instanceOfType(VehicleType.CAR, VehicleColor.RED);

        final Vehicle blackTruck = VehicleType.TRUCK.factory.apply(VehicleColor.BLACK);
        final Vehicle blueBus = VehicleType.BUS.factory.apply(VehicleColor.BLUE);
        blueBus.start(nil -> {
            System.out.println("Check if every new passenger has paid for their tickets");
            System.out.println("Check if every passenger is seated");
        });
    }
}
