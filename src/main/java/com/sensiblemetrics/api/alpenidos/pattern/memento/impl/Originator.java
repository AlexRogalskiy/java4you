package com.sensiblemetrics.api.alpenidos.pattern.memento.impl;

import com.sensiblemetrics.api.alpenidos.pattern.memento.model.Memento;

public class Originator {
    /*
    State of the originator in the Memento pattern.
    */
    private String state;

    public void set(final String state) {
        System.out.println("Originator: Setting state to " + state);
        this.state = state;
    }

    public Memento saveToMemento() {
        System.out.println("Originator: Saving " + this.state + " to Memento.");
        return new Memento(this.state);
    }

    public void restoreFromMemento(final Memento memento) {
        this.state = memento.getState();
        System.out.println("Originator: State after restoring from Memento: " + state);
    }
}
