package com.sensiblemetrics.api.alpenidos.core.builder4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class BuilderPatternLoader2 {

    public interface Vehicle {
    }

    public static class Car implements Vehicle {
        @Override
        public String toString() {
            return "Car ";
        }
    }

    public static class Moto implements Vehicle {
        @Override
        public String toString() {
            return "Moto ";
        }
    }

    static <K, T> Function<K, T> factoryKit(final Consumer<BiConsumer<K, T>> consumer, final Function<? super K, ? extends T> ifAbsent) {
        final Map<K, T> map = new HashMap<>();
        consumer.accept(map::put);
        return key -> map.computeIfAbsent(key, ifAbsent);
    }

    public static void main(final String[] args) {
        final Function<String, Vehicle> factory = BuilderPatternLoader2.<String, Supplier<Vehicle>>factoryKit(builder -> {
            builder.accept("car", Car::new);
            builder.accept("moto", Moto::new);
        }, name -> {
            throw new IllegalArgumentException("unknown vehicle " + name);
        })
            .andThen(Supplier::get);

        final Vehicle vehicle1 = factory.apply("car");
        System.out.println(vehicle1);
        final Vehicle vehicle2 = factory.apply("moto");
        System.out.println(vehicle2);
    }
}
