package com.sensiblemetrics.api.alpenidos.core.cor.handler;

public abstract class Handler {
    protected Handler successor;

    public void setSuccessor(final Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(final String request);
}
