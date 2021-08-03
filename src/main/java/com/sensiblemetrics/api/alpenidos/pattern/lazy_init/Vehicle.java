package com.sensiblemetrics.api.alpenidos.pattern.lazy_init;

import com.sensiblemetrics.api.alpenidos.pattern.lazy_init.enums.VehicleType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Slf4j
@RequiredArgsConstructor
public class Vehicle {
    private static Map<VehicleType, Vehicle> types = new HashMap<>();

    private final VehicleType type;

    public static Vehicle getVehicleByTypeName(final VehicleType type) {
        Vehicle vehicle;
        if (!types.containsKey(type)) {
            vehicle = new Vehicle(type);
            types.put(type, vehicle);
        } else {
            vehicle = types.get(type);
        }
        return vehicle;
    }

    public static void showAll() {
        if (types.size() > 0) {
            log.info("Number of instances made = " + types.size());
            for (final Entry<VehicleType, Vehicle> entry : types.entrySet()) {
                String vehicle = entry.getKey().toString();
                vehicle = Character.toUpperCase(vehicle.charAt(0)) + vehicle.substring(1);
                log.info(vehicle);
            }
        }
    }
}
