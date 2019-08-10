package com.sensiblemetrics.api.alpenidos.core.chain3;

/**
 * ConcreteHandler2 class, handles the request, can access to the next object in
 * a chain and forward the request if necessary.
 */
public class ConcreteHandler2 extends Handler {
    private boolean handleRequestInvoked = false;

    public void handleRequest() {
        this.handleRequestInvoked = true;
    }

    protected boolean isHandleRequestInvoked() {
        return this.handleRequestInvoked;
    }
}
