package com.sensiblemetrics.api.alpenidos.core.factory2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
public class FactoryPatternLoader5 {

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

    static <K, T> Function<K, T> factory(final Consumer<BiConsumer<K, T>> consumer, final Function<? super K, ? extends T> ifAbsent) {
        final Map<K, T> map = new HashMap<>();
        consumer.accept(map::put);
        return key -> map.computeIfAbsent(key, ifAbsent);
    }

    public static void main(final String[] args) {
        final Function<String, Color> colorFactory = factory(builder -> {
            builder.accept("blue", Color.BLUE);
            builder.accept("violet", Color.MAGENTA);
        }, __ -> Color.BLACK);

        Function<String, Function<Color, Vehicle>> vehicleFactoryFactory = factory(builder -> {
            builder.accept("car", Car::new);
            builder.accept("moto", Moto::new);
        }, key -> __ -> {
            throw new IllegalStateException("unknow vehicle " + key);
        });

        Function<String, Function<String, Vehicle>> vehicleFactory =
            kind -> vehicleFactoryFactory.apply(kind).compose(colorFactory);

        Vehicle vehicle = vehicleFactory.apply("car").apply("violet");
        log.info("Vehicle: " + vehicle);
    }
}
