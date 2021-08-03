package com.sensiblemetrics.api.alpenidos.pattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;

@Slf4j
public class ReflectionSingletonTest {

    public static void main(final String[] args) {
        final EagerSingleton instanceOne = EagerSingleton.getInstance();
        EagerSingleton instanceTwo = null;
        try {
            final Constructor[] constructors = EagerSingleton.class.getDeclaredConstructors();
            for (final Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EagerSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
