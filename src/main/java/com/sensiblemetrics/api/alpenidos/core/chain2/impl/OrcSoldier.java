package com.sensiblemetrics.api.alpenidos.core.chain2.impl;

import com.sensiblemetrics.api.alpenidos.core.chain2.model.Request;

/**
 * OrcSoldier
 */
public class OrcSoldier extends RequestHandler {

    public OrcSoldier(final RequestHandler handler) {
        super(handler);
    }

    @Override
    public void handleRequest(final Request req) {
        if (req.getRequestType().isCollectTax()) {
            this.printHandling(req);
            req.markHandled();
        } else {
            super.handleRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Orc soldier";
    }
}
