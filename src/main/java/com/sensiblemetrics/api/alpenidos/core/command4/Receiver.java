package com.sensiblemetrics.api.alpenidos.core.command4;

/**
 * Receiver class, knows how to perform the operations associated with carrying
 * out a request
 */
public class Receiver {
    private boolean operationPerfomed = false;

    public void action() {
        this.operationPerfomed = true;
    }

    protected boolean isOperationPerfomed() {
        return this.operationPerfomed;
    }
}
