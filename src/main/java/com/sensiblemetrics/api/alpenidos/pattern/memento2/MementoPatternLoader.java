package com.sensiblemetrics.api.alpenidos.pattern.memento2;

import com.sensiblemetrics.api.alpenidos.pattern.memento2.enums.StarType;
import com.sensiblemetrics.api.alpenidos.pattern.memento2.iface.StarMemento;
import com.sensiblemetrics.api.alpenidos.pattern.memento2.impl.Star;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * The Memento pattern is a software design pattern that provides the ability to restore an object
 * to its previous state (undo via rollback).
 * <p>
 * The Memento pattern is implemented with three objects: the originator, a caretaker and a memento.
 * The originator is some object that has an internal state. The caretaker is going to do something
 * to the originator, but wants to be able to undo the change. The caretaker first asks the
 * originator for a memento object. Then it does whatever operation (or sequence of operations) it
 * was going to do. To roll back to the state before the operations, it returns the memento object
 * to the originator. The memento object itself is an opaque object (one which the caretaker cannot,
 * or should not, change). When using this pattern, care should be taken if the originator may
 * change other objects or resources - the memento pattern operates on a single object.
 * <p>
 * In this example the object ({@link Star}) gives out a "memento" ({@link StarMemento}) that
 * contains the state of the object. Later on the memento can be set back to the object restoring
 * the state.
 */
@Slf4j
public class MementoPatternLoader {

    /**
     * Program entry point
     */
    public static void main(final String[] args) {
        final Stack<StarMemento> states = new Stack<>();
        final Star star = new Star(StarType.SUN, 10000000, 500000);

        log.info(star.toString());
        states.add(star.getMemento());
        star.timePasses();

        log.info(star.toString());
        states.add(star.getMemento());
        star.timePasses();

        log.info(star.toString());
        states.add(star.getMemento());
        star.timePasses();

        log.info(star.toString());
        states.add(star.getMemento());
        star.timePasses();

        log.info(star.toString());
        while (states.size() > 0) {
            star.setMemento(states.pop());
            log.info(star.toString());
        }
    }
}
