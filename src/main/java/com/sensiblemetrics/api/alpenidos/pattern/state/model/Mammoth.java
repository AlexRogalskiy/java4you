package com.sensiblemetrics.api.alpenidos.pattern.state.model;

import com.sensiblemetrics.api.alpenidos.pattern.state.iface.State;
import com.sensiblemetrics.api.alpenidos.pattern.state.impl.AngryState;
import com.sensiblemetrics.api.alpenidos.pattern.state.impl.PeacefulState;

/**
 * Mammoth has internal state that defines its behavior.
 */
public class Mammoth {
    private State state;

    public Mammoth() {
        this.state = new PeacefulState(this);
    }

    /**
     * Makes time pass for the mammoth
     */
    public void timePasses() {
        if (this.state.getClass().equals(PeacefulState.class)) {
            this.changeStateTo(new AngryState(this));
        } else {
            this.changeStateTo(new PeacefulState(this));
        }
    }

    private void changeStateTo(final State newState) {
        this.state = newState;
        this.state.onEnterState();
    }

    @Override
    public String toString() {
        return "The mammoth";
    }

    public void observe() {
        this.state.observe();
    }
}
