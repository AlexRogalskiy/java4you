package com.sensiblemetrics.api.alpenidos.core.visitor4;

import java.util.function.Function;

public class VisitorPatternLoader2 {

    public interface Vehicle {
    }

    public static class Car implements Vehicle {
    }

    public static class Moto implements Vehicle {
    }

    public static class Visitor<R> {
        public <T> Visitor<R> when(final Class<? extends T> type, final Function<? super T, ? extends R> fun) {
            throw new UnsupportedOperationException("TODO");
        }

        public R call(final Object receiver) {
            throw new UnsupportedOperationException("TODO");
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
