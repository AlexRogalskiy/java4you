package com.sensiblemetrics.api.alpenidos.pattern.factory2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

@Slf4j
public class FactoryPatternLoader3 {

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

    public static void main(final String[] args) {
        final Map<String, Color> colorMap = new HashMap<>();
        colorMap.put("blue", Color.BLUE);
        colorMap.put("violet", Color.MAGENTA);

        final Function<String, Color> colorFactory = name -> colorMap.getOrDefault(name, Color.BLACK);

        final Map<String, Function<Color, Vehicle>> shapeMap = new HashMap<>();
        shapeMap.put("car", Car::new);
        shapeMap.put("moto", Moto::new);

        final Function<String, Function<Color, Vehicle>> vehicleFactoryFactory =
            kind -> shapeMap.getOrDefault(kind, k -> {
                throw new IllegalStateException("unknown kind " + k);
            });

        final BiFunction<String, String, Vehicle> createVehicle =
            (kind, colorName) -> vehicleFactoryFactory.apply(kind).apply(colorFactory.apply(colorName));

        final Vehicle vehicle = createVehicle.apply("car", "violet");
        log.info("Vehicle: " + vehicle);
    }
}
