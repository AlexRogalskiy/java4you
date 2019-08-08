package com.sensiblemetrics.api.alpenidos.core.factory2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Slf4j
public class FactoryPatternLoader2 {

    public interface Vehicle {
    }

    @RequiredArgsConstructor
    public static class Car implements Vehicle {
        private final Color color;

        @Override
        public String toString() {
            return "Car " + this.color;
        }
    }

    @RequiredArgsConstructor
    public static class Moto implements Vehicle {
        private final Color color;

        @Override
        public String toString() {
            return "Moto " + this.color;
        }
    }

    static Color getColor(final String name) {
        return COLOR_MAP.getOrDefault(name, Color.BLACK);
    }

    static final Map<String, Color> COLOR_MAP = createColorMap();

    static Map<String, Color> createColorMap() {
        final Map<String, Color> colorMap = new HashMap<>();
        colorMap.put("blue", Color.BLUE);
        colorMap.put("violet", Color.MAGENTA);
        return colorMap;
    }

    static Function<Color, Vehicle> getVehicleFactory(final String kind) {
        return VEHICLE_FACTORY_MAP.getOrDefault(kind, k -> {
            throw new IllegalStateException("unkonwn kind " + k);
        });
    }

    static final Map<String, Function<Color, Vehicle>> VEHICLE_FACTORY_MAP = createVehicleFactoryMap();

    static Map<String, Function<Color, Vehicle>> createVehicleFactoryMap() {
        final Map<String, Function<Color, Vehicle>> factoryMap = new HashMap<>();
        factoryMap.put("car", Car::new);
        factoryMap.put("moto", Moto::new);
        return factoryMap;
    }

    static Vehicle createVehicle(final String kind, final String colorName) {
        final Function<Color, Vehicle> vehiceFactory = getVehicleFactory(kind);
        final Color color = getColor(colorName);
        return vehiceFactory.apply(color);
    }

    public static void main(final String[] args) {
        final Vehicle vehicle = createVehicle("car", "violet");
        log.info("Vehicle: " + vehicle);
    }
}
