package com.sensiblemetrics.api.alpenidos.pattern.carwash;

import com.sensiblemetrics.api.alpenidos.pattern.carwash.enumeration.WashState;
import com.sensiblemetrics.api.alpenidos.pattern.carwash.model.Car;

import java.util.function.Function;

public class CarWashClient {

    public static void main(final String[] args) {
        final Car car = new Car();
        final Function<Car, Car> initial = c -> new Car();

        final Function<Car, Car> chain = initial
            .andThen(c1 -> c1.updateState(WashState.INITIAL_WASH))
            .andThen(c2 -> c2.updateState(WashState.SOAP))
            .andThen(c3 -> c3.updateState(WashState.RINSED))
            .andThen(c4 -> c4.updateState(WashState.POLISHED))
            .andThen(c5 -> c5.updateState(WashState.DRIED));

        final Car finalCar = chain.apply(car);

        System.out.println("Final car state is " + finalCar.washState());
    }
}
