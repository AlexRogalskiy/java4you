package com.sensiblemetrics.api.alpenidos.pattern.chain3;

/**
 * Handler interface, declares an interface for request handling
 */
abstract class Handler {
    protected Handler succesor;

    abstract void handleRequest();

    public void setSuccesor(final Handler succesor) {
        this.succesor = succesor;
    }
}
