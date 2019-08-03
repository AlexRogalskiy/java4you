package com.sensiblemetrics.api.alpenidos.core.chain2.model;

import com.sensiblemetrics.api.alpenidos.core.chain2.impl.OrcCommander;
import com.sensiblemetrics.api.alpenidos.core.chain2.impl.OrcOfficer;
import com.sensiblemetrics.api.alpenidos.core.chain2.impl.OrcSoldier;
import com.sensiblemetrics.api.alpenidos.core.chain2.impl.RequestHandler;

/**
 * OrcKing makes requests that are handled by the chain.
 */
public class OrcKing {

    private RequestHandler chain;

    public OrcKing() {
        this.buildChain();
    }

    private void buildChain() {
        this.chain = new OrcCommander(new OrcOfficer(new OrcSoldier(null)));
    }

    public void makeRequest(final Request req) {
        this.chain.handleRequest(req);
    }
}
