package com.sensiblemetrics.api.alpenidos.pattern.chain2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.chain2.model.Request;

/**
 * OrcCommander
 */
public class OrcCommander extends RequestHandler {

    public OrcCommander(final RequestHandler handler) {
        super(handler);
    }

    @Override
    public void handleRequest(final Request req) {
        if (req.getRequestType().isDefendCastle()) {
            this.printHandling(req);
            req.markHandled();
        } else {
            super.handleRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Orc commander";
    }
}
