package com.sensiblemetrics.api.alpenidos.pattern.double_dispatch;

import com.sensiblemetrics.api.alpenidos.pattern.double_dispatch.model.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * When a message with a parameter is sent to an object, the resultant behaviour is defined by the implementation of
 * that method in the receiver. Sometimes the behaviour must also be determined by the type of the parameter.
 * <p>
 * One way to implement this would be to create multiple instanceof-checks for the methods parameter. However, this
 * creates a maintenance issue. When new types are added we would also need to change the method's implementation and
 * add a new instanceof-check. This violates the single responsibility principle - a class should have only one reason
 * to change.
 * <p>
 * Instead of the instanceof-checks a better way is to make another virtual call on the parameter object. This way new
 * functionality can be easily added without the need to modify existing implementation (open-closed principle).
 * <p>
 * In this example we have hierarchy of objects ({@link GameObject}) that can collide to each other. Each object has its
 * own coordinates which are checked against the other objects' coordinates. If there is an overlap, then the objects
 * collide utilizing the Double Dispatch pattern.
 */
@Slf4j
public class DoubleDispatchPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        // initialize game objects and print their status
        final List<GameObject> objects = Arrays.asList(
            new FlamingAsteroid(0, 0, 5, 5),
            new SpaceStationMir(1, 1, 2, 2),
            new Meteoroid(10, 10, 15, 15),
            new SpaceStationLess(12, 12, 14, 14)
        );

        objects.stream().forEach(o -> log.info(o.toString()));

        // collision check
        objects.stream().forEach(o1 -> objects.stream().forEach(o2 -> {
            if (o1 != o2 && o1.intersectsWith(o2)) {
                o1.collision(o2);
            }
        }));

        // output eventual object statuses
        objects.stream().forEach(o -> log.info(o.toString()));
    }
}
