package com.sensiblemetrics.api.alpenidos.pattern.visitor4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class VisitorPatternLoader3 {

    public interface Vehicle {
    }

    public static class Car implements Vehicle {
    }

    public static class Moto implements Vehicle {
    }

    public static class Visitor<R> {
        private final Map<Class<?>, Function<Object, ? extends R>> map = new HashMap<>();

        public <T> Visitor<R> when(final Class<? extends T> type, final Function<? super T, ? extends R> fun) {
            this.map.put(type, (Function<Object, ? extends R>) fun);
            return this;
        }

        public R call(final Object receiver) {
            return this.map.getOrDefault(receiver.getClass(),
                obj -> {
                    throw new IllegalArgumentException("invalid " + obj);
                })
                .apply(receiver);
        }
    }

    public static void main(final String[] args) {
        final Visitor<String> visitor = new Visitor<>();
        visitor.when(Car.class, car -> "car")
            .when(Moto.class, moto -> "moto");

        final Vehicle vehicle = new Car();
        final String text = visitor.call(vehicle);
        System.out.println(text);
    }
}
