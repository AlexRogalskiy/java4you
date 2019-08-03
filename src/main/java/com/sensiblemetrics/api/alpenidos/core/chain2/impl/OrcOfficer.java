package com.sensiblemetrics.api.alpenidos.core.chain2.impl;

import com.sensiblemetrics.api.alpenidos.core.chain2.model.Request;

/**
 * OrcOfficer
 */
public class OrcOfficer extends RequestHandler {

    public OrcOfficer(final RequestHandler handler) {
        super(handler);
    }

    @Override
    public void handleRequest(final Request req) {
        if (req.getRequestType().isTorturePrisoner()) {
            this.printHandling(req);
            req.markHandled();
        } else {
            super.handleRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Orc officer";
    }

}
