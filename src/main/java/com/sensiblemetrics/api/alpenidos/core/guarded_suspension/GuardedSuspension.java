package com.sensiblemetrics.api.alpenidos.core.guarded_suspension;

/**
 * Guarded Suspension ref: <https://en.wikipedia.org/wiki/Guarded_suspension>
 */
public class GuardedSuspension {

    synchronized void guardedMethod() {
        while (!this.preCondition()) { // preCodition() is a method
            try {
                // Continue to wait
                this.wait();
                // …
            } catch (InterruptedException e) {
                // …
            }
        }
        // Actual task implementation
    }

    private boolean preCondition() {
        return true;
    }

    synchronized void alterObjectStateMethod() {
        // Change the object state
        // …
        // Inform waiting threads
        this.notify();
    }
}
