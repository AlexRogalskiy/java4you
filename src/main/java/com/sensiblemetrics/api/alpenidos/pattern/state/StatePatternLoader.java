package com.sensiblemetrics.api.alpenidos.pattern.state;

import com.sensiblemetrics.api.alpenidos.pattern.state.model.Mammoth;

/**
 * In State pattern the container object has an internal state object that defines the current
 * behavior. The state object can be changed to alter the behavior.
 * <p>
 * This can be a cleaner way for an object to change its behavior at runtime without resorting to
 * large monolithic conditional statements and thus improves maintainability.
 * <p>
 * In this example the {@link Mammoth} changes its behavior as time passes by.
 */
public class StatePatternLoader {

    /**
     * Program entry point
     */
    public static void main(final String[] args) {
        final Mammoth mammoth = new Mammoth();
        mammoth.observe();

        mammoth.timePasses();
        mammoth.observe();

        mammoth.timePasses();
        mammoth.observe();
    }
}
