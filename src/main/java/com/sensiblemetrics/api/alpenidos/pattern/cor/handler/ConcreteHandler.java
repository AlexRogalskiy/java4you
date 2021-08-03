package com.sensiblemetrics.api.alpenidos.pattern.cor.handler;

public class ConcreteHandler extends Handler {

    public void handleRequest(final String request) {
        this.successor.handleRequest(request);
    }
}
