package com.sensiblemetrics.api.alpenidos.pattern.visitor4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class VisitorPatternLoader4 {

    public interface Vehicle {
    }

    public static class Car implements Vehicle {
    }

    public static class Moto implements Vehicle {
    }

    public static class Fruit {
    }

    public static class Visitor<U, R> {
        private final Map<Class<? extends U>, Function<U, ? extends R>> map = new HashMap<>();

        public <T extends U> Visitor<U, R> when(final Class<? extends T> type, final Function<? super T, ? extends R> fun) {
            this.map.put(type, fun.compose(type::cast));
            return this;
        }

        public R call(final U receiver) {
            return this.map.getOrDefault(receiver.getClass(),
                obj -> {
                    throw new IllegalArgumentException("invalid " + obj);
                })
                .apply(receiver);
        }
    }

    public static void main(final String[] args) {
        final Visitor<Vehicle, String> visitor = new Visitor<>();
        visitor.when(Car.class, car -> "car")
            .when(Moto.class, moto -> "moto");

        final Vehicle vehicle = new Car();
        final String text = visitor.call(vehicle);
        System.out.println(text);
    }
}
