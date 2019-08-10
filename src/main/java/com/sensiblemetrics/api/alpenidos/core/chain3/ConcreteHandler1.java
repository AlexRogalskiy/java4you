package com.sensiblemetrics.api.alpenidos.core.chain3;

/**
 * ConcreteHandler1 class, handles the request, can access to the next object in
 * a chain and forward the request if necessary.
 */
public class ConcreteHandler1 extends Handler {
    private boolean handleRequestInvoked = false;

    public void handleRequest() {
        this.handleRequestInvoked = true;
        // if some condition call handleRequest on successor
        if (this.handleRequestInvoked) {
            this.succesor.handleRequest();
        }
    }

    protected boolean isHandleRequestInvoked() {
        return this.handleRequestInvoked;
    }
}
