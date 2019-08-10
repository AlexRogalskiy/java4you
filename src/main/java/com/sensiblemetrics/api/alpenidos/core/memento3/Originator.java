package com.sensiblemetrics.api.alpenidos.core.memento3;

import lombok.Data;

/**
 * Originator creates a Memento containing a snapshot of its current internal
 * state. Originator use Memento to restore its internal state.
 */
@Data
public class Originator {
    private int state;

    public void setMemento(final Memento memento) {
        this.state = memento.getState();
    }

    public Memento createMemento() {
        return new Memento(this.state);
    }
}
